package lesson_8.math_operation;

class MathOperationDemo {

    public static void main(String[] args) {
        // build and calculate: 10 + 20
        Argument arg1 = new Argument(10);
        Argument arg2 = new Argument(20);
        MathOperation addition = new Addition(arg1, arg2);
        System.out.println("Left side Addition result = " + addition.calculate());

        // build and calculate: 50 - 20
        Argument arg3 = new Argument(50);
        Argument arg4 = new Argument(20);
        MathOperation subtraction = new Subtraction(arg3, arg4);
        System.out.println("Right side Subtraction result = " + subtraction.calculate());

        // build and calculate: (10 + 20) + (50 - 20)
        MathOperation addition1 = new Addition(addition, subtraction);
        System.out.println("Final Addition result = " + addition1.calculate());

        System.out.println();

        // build and calculate: (10 - 5)
        Argument arg5 = new Argument(10);
        Argument arg6 = new Argument(5);
        MathOperation subtraction1 = new Subtraction(arg5, arg6);
        System.out.println("Left side Subtraction result = " + subtraction1.calculate());

        // build and calculate: (20 / 5)
        Argument arg7 = new Argument(20);
        Argument arg8 = new Argument(5);
        MathOperation division = new Division(arg7, arg8);
        System.out.println("Right side Division result = " + division.calculate());

        // build and calculate: (10 - 5) * (20 / 5)
        MathOperation multiplication = new Multiplication(subtraction1, division);
        System.out.println("Final Multiplication result = " + multiplication.calculate());
    }

}

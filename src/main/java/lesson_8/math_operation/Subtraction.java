package lesson_8.math_operation;

class Subtraction extends TwoArgumentMathOperation {

    public Subtraction(MathOperation leftArgument,
                       MathOperation rightArgument) {
        super(leftArgument, rightArgument);
    }

    @Override
    public double calculate() {
        return calculateLeftSide() - calculateRightSide();
    }
}
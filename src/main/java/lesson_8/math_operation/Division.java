package lesson_8.math_operation;

class Division extends TwoArgumentMathOperation {
    public Division(MathOperation leftArgument, MathOperation rightArgument) {
        super(leftArgument, rightArgument);
    }

    @Override
    public double calculate() {
        double denominator = calculateRightSide();
        return (denominator == 0) ? Double.MAX_VALUE : calculateLeftSide() / denominator;
    }
}

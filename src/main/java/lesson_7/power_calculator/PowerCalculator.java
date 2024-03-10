package lesson_7.power_calculator;

class PowerCalculator {

    public double raiseToPower(double number, int power) {
        if (number == 0) {
            return 0;
        }

        if (power == 0) {
            return 1;
        }

        double result = number;

        int iterations = (power < 0) ? power * (-1) : power;

        for (int i = 1; i < iterations; i++) {
            result = result * number;
        }

        if (power < 0) {
            result = 1 / result;
        }

        return result;
    }
}

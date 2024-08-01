package lesson_9.Strategy;

class OperationMaxImpl implements Strategy {
    @Override
    public double doOperation(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        double result = numbers[0];
        for (int number : numbers) {
            if (number > result) {
                result = number;
            }
        }
        return result;
    }
}

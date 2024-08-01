package lesson_9.Strategy;

class OperationAverageImpl implements Strategy {
    @Override
    public double doOperation(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}

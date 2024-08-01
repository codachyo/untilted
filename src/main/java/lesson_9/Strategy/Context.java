package lesson_9.Strategy;

class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public double executeStrategy(int... numbers){
        return strategy.doOperation(numbers);
    }
}

package lesson_9.Strategy;

class StrategyTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    public static void main(String[] args) {
        shouldFindMaxNumber();
        shouldFindMinNumber();
        shouldFindSum();
        shouldFindAverage();
        printFooter();
    }

    private static void shouldFindMaxNumber() {
        totalRun++;
        Context context = new Context(new OperationMaxImpl());
        checkResult(5,  context.executeStrategy(1, 2, 3, 4, 5),"shouldFindMaxNumber");
    }

    private static void shouldFindMinNumber() {
        totalRun++;
        Context context = new Context(new OperationMinImpl());
        checkResult(1,  context.executeStrategy(1, 2, 3, 4, 5),"shouldFindMinNumber");
    }

    private static void shouldFindSum() {
        totalRun++;
        Context context = new Context(new OperationSumImpl());
        checkResult(15,  context.executeStrategy(1, 2, 3, 4, 5),"shouldFindSum");
    }

    private static void shouldFindAverage() {
        totalRun++;
        Context context = new Context(new OperationAverageImpl());
        checkResult(3,  context.executeStrategy(1, 2, 3, 4, 5),"shouldFindAverage");
    }

    private static void checkResult(double expected, double actual, String testName) {
        if (expected == actual) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual + TEXT_RESET);
            totalFailed++;
        }
    }

    private static void printFooter() {
        System.out.println("********************************************");
        if (totalFailed > 0) {
            System.out.println(TEXT_RED + "TOTAL: RUN = " + totalRun + "; PASSED = " + totalPassed +
                    "; FAILED = " + totalFailed + TEXT_RESET);
        } else {
            System.out.println(TEXT_GREEN + "TOTAL: RUN = " + totalRun + "; PASSED = " + totalPassed +
                    "; FAILED = " + totalFailed + TEXT_RESET);
        }
        System.out.println("********************************************");
    }
}

package lesson_8.math_operation;

class MathOperationTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    public static void main(String[] args) {
        shouldMultiplyTwoNumbersTest();
        shouldDivideTwoNumbersTest();
        shouldProceedDivisionByZeroTest();
        printFooter();
    }

    private static void shouldMultiplyTwoNumbersTest() {
        totalRun++;
        MathOperation operation = new Multiplication(new Argument(2), new Argument(3));
        checkResult(6, operation.calculate(), "shouldMultiplyTwoNumbersTest");
    }

    private static void shouldDivideTwoNumbersTest() {
        totalRun++;
        MathOperation operation = new Division(new Argument(9), new Argument(2));
        checkResult(4.5, operation.calculate(), "shouldDivideTwoNumbersTest");
    }

    private static void shouldProceedDivisionByZeroTest() {
        totalRun++;
        MathOperation operation = new Division(new Argument(9), new Argument(0));
        checkResult(Double.MAX_VALUE, operation.calculate(), "shouldProceedDivisionByZeroTest");
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

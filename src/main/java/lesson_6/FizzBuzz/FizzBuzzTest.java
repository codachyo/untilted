package lesson_6.FizzBuzz;

class FizzBuzzTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static FizzBuzz fizzBuzz = new FizzBuzz();

    public static void main(String[] args) {
        detectTestFizz();
        detectTestBuzz();
        detectTestFizzBuzz();
        detectTestOtherValue();
        printFooter();
    }

    private static void detectTestFizz() {
        totalRun++;
        checkResult("Fizz",  fizzBuzz.detect(9),"detectTestFizz");
    }

    private static void detectTestBuzz() {
        totalRun++;
        checkResult("Buzz",  fizzBuzz.detect(10),"detectTestBuzz");
    }

    private static void detectTestFizzBuzz() {
        totalRun++;
        checkResult("FizzBuzz",  fizzBuzz.detect(15),"detectTestFizzBuzz");
    }

    private static void detectTestOtherValue() {
        totalRun++;
        checkResult("17",  fizzBuzz.detect(17),"detectTestOtherValue");
    }

    private static void checkResult(String expectedResult, String actualResult, String testName) {
        if (expectedResult.equals(actualResult)) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual:   " + actualResult + TEXT_RESET);
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

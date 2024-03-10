package lesson_8.varags;

public class VarargsTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static Varargs varargs = new Varargs();

    public static void main(String[] args) {
        shouldCalculateSumTest1();
        shouldCalculateSumTest2();
        printFooter();
    }

    private static void shouldCalculateSumTest1() {
        totalRun++;
        int[] input = {1, 2, 3, 4, 5};
        checkResult(15,  varargs.sum(input),"shouldCalculateSumTest1");
    }

    private static void shouldCalculateSumTest2() {
        totalRun++;
        checkResult(40,  varargs.sum(6, 7, 8, 9, 10),"shouldCalculateSumTest2");
    }

    private static void checkResult(int expected, int actual, String testName) {
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

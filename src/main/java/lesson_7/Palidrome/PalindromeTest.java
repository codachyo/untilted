package lesson_7.Palidrome;

class PalindromeTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static Palindrome palindrome = new Palindrome();

    public static void main(String[] args) {
        isNotPalindromeTest();
        isPalindromeTest1();
        isPalindromeTest2();
        isPalindromeTest3();
        isPalindromeTest4();
        printFooter();
    }

    private static void isNotPalindromeTest() {
        totalRun++;
        checkResult(false, palindrome.isPalindrome("not palindrome"), "isNotPalindromeTest");
    }

    private static void isPalindromeTest1() {
        totalRun++;
        checkResult(true, palindrome.isPalindrome("racecar"), "isPalindromeTest1");
    }

    private static void isPalindromeTest2() {
        totalRun++;
        checkResult(true, palindrome.isPalindrome("level"), "isPalindromeTest2");
    }

    private static void isPalindromeTest3() {
        totalRun++;
        checkResult(true, palindrome.isPalindrome("sum summus mus"), "isPalindromeTest3");
    }

    private static void isPalindromeTest4() {
        totalRun++;
        checkResult(true, palindrome.isPalindrome("А роза упала на лапу Азора"), "isPalindromeTest4");
    }

    private static void checkResult(boolean expected, boolean actual, String testName) {
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
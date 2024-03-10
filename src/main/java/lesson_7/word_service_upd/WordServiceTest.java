package lesson_7.word_service_upd;

class WordServiceTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static WordService wordService = new WordService();

    public static void main(String[] args) {
        findMostFrequentWordTest1();
        findMostFrequentWordTest2();
        findMostFrequentWordTest3();
        printFooter();
    }

    private static void findMostFrequentWordTest1() {
        totalRun++;
        String input = "Code does not work due to the problems with register and punctuation marks!";
        checkResult("does",  wordService.findMostFrequentWord(input),"findMostFrequentWordTest1");
    }

    private static void findMostFrequentWordTest2() {
        totalRun++;
        String input = "Keep trying, keep trying. Comma will be a killer for this code!";
        checkResult("trying,",  wordService.findMostFrequentWord(input),"findMostFrequentWordTest2");
    }

    private static void findMostFrequentWordTest3() {
        totalRun++;
        String input = "try again try";
        checkResult("try",  wordService.findMostFrequentWord(input),"findMostFrequentWordTest3");
    }

    private static void checkResult(String expected, String actual, String testName) {
        if (expected.equals(actual)) {
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

package lesson_7.WordService;

class WordServiceTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static WordService wordService = new WordService();

    public static void main(String[] args) {
        shouldRemovePunctuationMarksTestEng();
        shouldRemovePunctuationMarksTestRus();
        shouldSplitStringTest();
        shouldRemoveAllEmptyStringsTest();
        shouldRemoveDuplicatesTest();
        shouldCountStringAppearanceTest();
        shouldFindMostFrequentWordTestEmptyInput();
        shouldFindMostFrequentWordTestMarksOnlyProvided();
        shouldFindMostFrequentWordTestOnlyOneFound();
        shouldFindMostFrequentWordTestMoreThanOneFound();
        printFooter();
    }

    private static void shouldRemovePunctuationMarksTestEng() {
        totalRun++;
        String input = "Main goal - to remove all punctuation marks (?, !, ...).";
        String expectedResult = "Main goal   to remove all punctuation marks             ";
        checkResult(expectedResult,  wordService.removePunctuationMarks(input),"shouldRemovePunctuationMarksTestEng");
    }

    private static void shouldRemovePunctuationMarksTestRus() {
        totalRun++;
        String input = "Главная цель - убрать все знаки препинания (?, !, ...).";
        String expectedResult = "Главная цель   убрать все знаки препинания             ";
        checkResult(expectedResult,  wordService.removePunctuationMarks(input),"shouldRemovePunctuationMarksTestRus");
    }

    private static void shouldSplitStringTest() {
        totalRun++;
        String input = "Text to split";
        String[] expectedResult = {"Text", "to", "split"};
        checkResult(expectedResult, wordService.splitString(input), "shouldSplitStringTest");
    }

    private static void shouldRemoveAllEmptyStringsTest() {
        totalRun++;
        String[] input = {"Testing", " ", "empty", " ", "strings", " ", "removing"};
        String[] expectedResult = {"Testing", "empty", "strings", "removing"};
        checkResult(expectedResult, wordService.removeAllEmptyStrings(input), "shouldRemoveAllEmptyStringsTest");
    }

    private static void shouldRemoveDuplicatesTest() {
        totalRun++;
        String[] input = {"s", "test", "Testing", "test1", "testing", "test", "t"};
        String[] expectedResult = {"s", "test", "Testing", "test1", "t"};
        checkResult(expectedResult, wordService.removeDuplicates(input), "shouldRemoveDuplicatesTest");
    }

    private static void shouldCountStringAppearanceTest() {
        totalRun++;
        String[] inputArray = {"s", "test", "Testing", "test1", "testing", "test", "t"};
        String toSearch = "testing";
        checkResult(2, wordService.stringAppearance(inputArray, toSearch), "shouldCountStringAppearanceTest");
    }

    private static void shouldFindMostFrequentWordTestEmptyInput() {
        totalRun++;
        String expectedResult = "";
        checkResult(expectedResult, wordService.findMostFrequentWord(""), "shouldFindMostFrequentWordTestEmptyInput");
    }

    private static void shouldFindMostFrequentWordTestMarksOnlyProvided() {
        totalRun++;
        String input = "!-, .?";
        String expectedResult = "";
        checkResult(expectedResult, wordService.findMostFrequentWord(input), "shouldFindMostFrequentWordTestMarksOnlyProvided");
    }

    private static void shouldFindMostFrequentWordTestOnlyOneFound() {
        totalRun++;
        String input = "Testing is very efficient here! Usage of testing - good practice!";
        String expectedResult = "testing";
        checkResult(expectedResult, wordService.findMostFrequentWord(input), "shouldFindMostFrequentWordTestOnlyOneFound");
    }

    private static void shouldFindMostFrequentWordTestMoreThanOneFound() {
        totalRun++;
        String input = "Is testing very efficient? Yes, testing is a good practice!";
        String expectedResult = "is";
        checkResult(expectedResult, wordService.findMostFrequentWord(input), "shouldFindMostFrequentWordTestMoreThanOneFound");
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

    private static void checkResult(String[] expectedResult, String[] actualResult, String testName) {
        if (arraysAreEqual(expectedResult, actualResult)) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + getArrayAsString(expectedResult));
            System.out.println("Actual:   " + getArrayAsString(actualResult) + TEXT_RESET);
            totalFailed++;
        }
    }

    private static void checkResult(int expectedResult, int actualResult, String testName) {
        if (expectedResult == actualResult) {
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

    private static boolean arraysAreEqual(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static String getArrayAsString(String[] arr) {
        if (arr.length == 0) {
            return "Array is empty";
        }
        String result = "[ ";
        for (String str : arr) {
            result += (str + " ");
        }
        return result + "]";
    }
}

package lesson_6.ArrayService;

class ArrayServiceTest {

    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static ArrayService arrayService = new ArrayService();

    public static void main(String[] args) {
        containsNumberTestReturnsTrue();
        containsNumberTestReturnsFalse();
        numberOccurrencesCountTestReturnsNotZero();
        numberOccurrencesCountTestReturnsZero();
        replaceNumberFirstOccurrenceTestReturnsTrue();
        replaceNumberFirstOccurrenceTestReturnsFalse();
        replaceNumberAllOccurrencesTestReturnsNotZero();
        replaceNumberAllOccurrencesTestReturnsZero();
        getReversedTestSucceed();
        getSortedTestSucceed();
        printFooter();
    }

    private static void containsNumberTestReturnsTrue() {
        totalRun++;
        int[] inputArray = {1, 20, 6, 45, -45};
        checkResult(true, arrayService.containsNumber(inputArray, 6), "containsNumberTestReturnsTrue");
    }

    private static void containsNumberTestReturnsFalse() {
        totalRun++;
        int[] inputArray = {1, 20, 6, 45, -45};
        checkResult(false, arrayService.containsNumber(inputArray, -6), "containsNumberTestReturnsFalse");
    }

    private static void numberOccurrencesCountTestReturnsNotZero() {
        totalRun++;
        int[] inputArray = {1, 2, 3, 4, 3};
        checkResult(2, arrayService.numberOccurrencesCount(inputArray, 3), "numberOccurrencesCountTestReturnsNotZero");
    }

    private static void numberOccurrencesCountTestReturnsZero() {
        totalRun++;
        int[] inputArray = {1, 2, 3, 4, 5};
        checkResult(0, arrayService.numberOccurrencesCount(inputArray, 6), "numberOccurrencesCountTestReturnsZero");
    }

    private static void replaceNumberFirstOccurrenceTestReturnsTrue() {
        totalRun++;
        int[] inputArray = {1, 2, 3, 4, 5};
        checkResult(true, arrayService.replaceNumberFirstOccurrence(inputArray, 3, 6), "replaceNumberFirstOccurrenceTestReturnsTrue");
    }

    private static void replaceNumberFirstOccurrenceTestReturnsFalse() {
        totalRun++;
        int[] inputArray = {1, 2, 3, 4, 5};
        checkResult(false, arrayService.replaceNumberFirstOccurrence(inputArray, 6, 3), "replaceNumberFirstOccurrenceTestReturnsFalse");
    }

    private static void replaceNumberAllOccurrencesTestReturnsNotZero() {
        totalRun++;
        int[] inputArray = {1, 2, 3, 4, 3};
        checkResult(2, arrayService.replaceNumberAllOccurrences(inputArray, 3, 6), "replaceNumberAllOccurrencesTestReturnsNotZero");
    }

    private static void replaceNumberAllOccurrencesTestReturnsZero() {
        totalRun++;
        int[] inputArray = {1, 2, 3, 4, 5};
        checkResult(0, arrayService.replaceNumberAllOccurrences(inputArray, 6, 3), "replaceNumberAllOccurrencesTestReturnsZero");
    }

    private static void getReversedTestSucceed() {
        totalRun++;
        int[] inputArray = {1, 2, 3, 4, 5};
        int[] expectedResult = {5, 4, 3, 2, 1};
        arrayService.getReversed(inputArray);
        checkResult(expectedResult, inputArray, "getReversedTestSucceed");
    }

    private static void getSortedTestSucceed() {
        totalRun++;
        int[] inputArray = {3, 5, 1, 4, 2};
        int[] expectedResult = {1, 2, 3, 4, 5};
        arrayService.getSorted(inputArray);
        checkResult(expectedResult, inputArray, "getSortedTestSucceed");
    }

    private static void checkResult(Boolean expectedResult, Boolean actualResult, String testName) {
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

    private static void checkResult(int[] expectedResult, int[] actualResult, String testName) {
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

    private static boolean arraysAreEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private static String getArrayAsString(int[] array) {
        if (array.length == 0) {
            return "Array is empty";
        }
        String result = "[ ";
        for (int number : array) {
            result += (number + " ");
        }
        return result + "]";
    }
}

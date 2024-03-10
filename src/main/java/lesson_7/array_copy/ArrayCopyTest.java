package lesson_7.array_copy;

class ArrayCopyTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static ArrayCopy arrayCopy = new ArrayCopy();

    public static void main(String[] args) {
        copyInRangeTest1();
        copyInRangeTest2();
        copyInRangeTest3();
        printFooter();
    }

    private static void copyInRangeTest1() {
        totalRun++;
        int[] input = {1, 20, 6, 45, -45};
        checkResult(null,  arrayCopy.copyInRange(input, 2, 5),"copyInRangeTest1");
    }

    private static void copyInRangeTest2() {
        totalRun++;
        int[] input = {1, 20, 6, 45, -45};
        int[] expected = {20, 6};
        checkResult(expected,  arrayCopy.copyInRange(input, 5, 40),"copyInRangeTest2");
    }

    private static void copyInRangeTest3() {
        totalRun++;
        int[] input = {1, 20, 6, 45, -45};
        int[] expected = {1, 20, 6, 45, -45};
        checkResult(expected,  arrayCopy.copyInRange(input, -45, 45),"copyInRangeTest3");
    }

    private static void checkResult(int[] expected, int[] actual, String testName) {
        if (arraysAreEqual(expected, actual)) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + getArrayAsString(expected));
            System.out.println("Actual:   " + getArrayAsString(actual) + TEXT_RESET);
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

    private static boolean arraysAreEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static String getArrayAsString(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "Array is empty";
        }
        String result = "[ ";
        for (int val : arr) {
            result += (val + " ");
        }
        return result + "]";
    }

}

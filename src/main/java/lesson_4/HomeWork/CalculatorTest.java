package lesson_4.HomeWork;

class CalculatorTest {

    // Define color constants
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";
    private static final String TEXT_YELLOW = "\u001B[33m";

    private int totalRun = 0;
    private int totalPassed = 0;
    private int totalFailed = 0;

    public static void main(String[] args) {
        CalculatorTest calculatorTest = new CalculatorTest(); // Create an instance as static method can't run non-static methods
        calculatorTest.sumTest();
        calculatorTest.subtractionTest();
        calculatorTest.divisionTest();
        calculatorTest.multiplicationTest();
        calculatorTest.isEvenTest();
        calculatorTest.maxOfTwoNumbersTest();
        calculatorTest.maxOfThreeNumbersTest();
        calculatorTest.printFooter(); // Print totals
    }

    private void sumTest() {
        int realResult;

        // Prepare data for testing
        int[] firstNumber = {-1, -1, 0, 0, 5};
        int[] secondNumber = {-1, 3, 0, 3, 10};
        int[] expectedResult = {-2, 2, 0, 3, 15};

        // Run tested method for each value combinations
        Calculator calculator = new Calculator();
        System.out.println("--------------------------------------------");
        System.out.println("Tested logic: " + TEXT_YELLOW + "sum" + TEXT_RESET);
        for (int i = 0; i < firstNumber.length; i++) {
            totalRun++;
            realResult = calculator.sum(firstNumber[i], secondNumber[i]);
            check(expectedResult[i], realResult, "Test Case " + (i + 1));
        }
    }

    private void subtractionTest() {
        int realResult;

        // Prepare data for testing
        int[] firstNumber = {-1, -1, 0, 0, 15};
        int[] secondNumber = {-1, 3, 0, 3, 10};
        int[] expectedResult = {0, -4, 0, -3, 5};

        // Run tested method for each value combinations
        Calculator calculator = new Calculator();
        System.out.println("--------------------------------------------");
        System.out.println("Tested logic: " + TEXT_YELLOW + "subtraction" + TEXT_RESET);
        for (int i = 0; i < firstNumber.length; i++) {
            totalRun++;
            realResult = calculator.subtraction(firstNumber[i], secondNumber[i]);
            check(expectedResult[i], realResult, "Test Case " + (i + 1));
        }
    }

    private void divisionTest() {
        int realResult;

        // Prepare data for testing
        int[] firstNumber = {-6, -10, 0, 0, 25};
        int[] secondNumber = {-3, 5, 0, 3, 5};
        int[] expectedResult = {2, -2, Integer.MIN_VALUE, 0, 5};

        // Run tested method for each value combinations
        Calculator calculator = new Calculator();
        System.out.println("--------------------------------------------");
        System.out.println("Tested logic: " + TEXT_YELLOW + "division" + TEXT_RESET);
        for (int i = 0; i < firstNumber.length; i++) {
            totalRun++;
            realResult = calculator.division(firstNumber[i], secondNumber[i]);
            check(expectedResult[i], realResult, "Test Case " + (i + 1));
        }
    }

    private void multiplicationTest() {
        int realResult;

        // Prepare data for testing
        int[] firstNumber = {-6, -10, 0, 0, 5};
        int[] secondNumber = {-3, 5, 0, 3, 5};
        int[] expectedResult = {18, -50, 0, 0, 25};

        // Run tested method for each value combinations
        Calculator calculator = new Calculator();
        System.out.println("--------------------------------------------");
        System.out.println("Tested logic: " + TEXT_YELLOW + "multiplication" + TEXT_RESET);
        for (int i = 0; i < firstNumber.length; i++) {
            totalRun++;
            realResult = calculator.multiplication(firstNumber[i], secondNumber[i]);
            check(expectedResult[i], realResult, "Test Case " + (i + 1));
        }
    }

    private void isEvenTest() {
        boolean realResult;

        // Prepare data for testing
        int[] number = {1, 2};
        boolean[] expectedResult = {false, true};

        // Run tested method for each value combinations
        Calculator calculator = new Calculator();
        System.out.println("--------------------------------------------");
        System.out.println("Tested logic: " + TEXT_YELLOW + "isEven" + TEXT_RESET);
        for (int i = 0; i < number.length; i++) {
            totalRun++;
            realResult = calculator.isEven(number[i]);
            check(expectedResult[i], realResult, "Test Case " + (i + 1));
        }
    }

    private void maxOfTwoNumbersTest() {
        int realResult;

        // Prepare data for testing
        int[] firstNumber = {1, 1, 5};
        int[] secondNumber = {-1, 3, 5};
        int[] expectedResult = {1, 3, 5};

        // Run tested method for each value combinations
        Calculator calculator = new Calculator();
        System.out.println("--------------------------------------------");
        System.out.println("Tested logic: " + TEXT_YELLOW + "maxOfTwoNumbers" + TEXT_RESET);
        for (int i = 0; i < firstNumber.length; i++) {
            totalRun++;
            realResult = calculator.maxOfTwoNumbers(firstNumber[i], secondNumber[i]);
            check(expectedResult[i], realResult, "Test Case " + (i + 1));
        }
    }

    private void maxOfThreeNumbersTest() {
        int realResult;

        // Prepare data for testing
        int[] firstNumber = {3, -1, 0, 4, 5, 6, 7};
        int[] secondNumber = {2, 3, 1, 4, 10, 1, 7};
        int[] thirdNumber = {1, 1, 2, 3, 10, 6, 7};
        int[] expectedResult = {3, 3, 2, 4, 10, 6, 7};

        // Run tested method for each value combinations
        Calculator calculator = new Calculator();
        System.out.println("--------------------------------------------");
        System.out.println("Tested logic: " + TEXT_YELLOW + "maxOfThreeNumbers" + TEXT_RESET);
        for (int i = 0; i < firstNumber.length; i++) {
            totalRun++;
            realResult = calculator.maxOfThreeNumbers(firstNumber[i], secondNumber[i], thirdNumber[i]);
            check(expectedResult[i], realResult, "Test Case " + (i + 1));
        }
    }

    private void check(int expectedResult, int actualResult, String testCase) {
        if (expectedResult == actualResult) {
            System.out.println(TEXT_GREEN + testCase + " passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testCase + " failed. Expected: " + expectedResult +
                    " but actual: " + actualResult + TEXT_RESET);
            totalFailed++;
        }
    }

    private void check(boolean expectedResult, boolean actualResult, String testCase) {
        if (expectedResult == actualResult) {
            System.out.println(TEXT_GREEN + testCase + " passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testCase + " failed. Expected: " + expectedResult +
                    " but actual: " + actualResult + TEXT_RESET);
            totalFailed++;
        }
    }

    private void printFooter() {
        System.out.println("\n********************************************");
        System.out.println("TOTAL: RUN = " + totalRun + "; PASSED = " + totalPassed + "; FAILED = " + totalFailed);
        System.out.println("********************************************");
    }
}

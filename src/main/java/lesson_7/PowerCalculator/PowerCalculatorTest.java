package lesson_7.PowerCalculator;

class PowerCalculatorTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static PowerCalculator powerCalculator = new PowerCalculator();

    public static void main(String[] args) {
        shouldRaiseToPowerTestNumberZero();
        shouldRaiseToPowerTestPowerZero();
        shouldRaiseToPowerTestPosNumberPowerOne();
        shouldRaiseToPowerTestNegNumberPowerOne();
        shouldRaiseToPowerTestPosNumberPosPower();
        shouldRaiseToPowerTestPosNumberNegPower();
        shouldRaiseToPowerTestNegNumberPosOddPower();
        shouldRaiseToPowerTestNegNumberPosEvenPower();
        shouldRaiseToPowerTestNegNumberNegOddPower();
        shouldRaiseToPowerTestNegNumberNegEvenPower();
        printFooter();
    }

    private static void shouldRaiseToPowerTestNumberZero() {
        totalRun++;
        checkResult(0,  powerCalculator.raiseToPower(0, 2),"shouldRaiseToPowerTestNumberZero");
    }

    private static void shouldRaiseToPowerTestPowerZero() {
        totalRun++;
        checkResult(1,  powerCalculator.raiseToPower(2, 0),"shouldRaiseToPowerTestPowerZero");
    }

    private static void shouldRaiseToPowerTestPosNumberPowerOne() {
        totalRun++;
        checkResult(2,  powerCalculator.raiseToPower(2, 1),"shouldRaiseToPowerTestPosNumberPowerOne");
    }

    private static void shouldRaiseToPowerTestNegNumberPowerOne() {
        totalRun++;
        checkResult(-2,  powerCalculator.raiseToPower(-2, 1),"shouldRaiseToPowerTestNegNumberPowerOne");
    }

    private static void shouldRaiseToPowerTestPosNumberPosPower() {
        totalRun++;
        checkResult(8,  powerCalculator.raiseToPower(2, 3),"shouldRaiseToPowerTestPosNumberPosPower");
    }

    private static void shouldRaiseToPowerTestPosNumberNegPower() {
        totalRun++;
        checkResult(0.125,  powerCalculator.raiseToPower(2, -3),"shouldRaiseToPowerTestPosNumberNegPower");
    }

    private static void shouldRaiseToPowerTestNegNumberPosOddPower() {
        totalRun++;
        checkResult(-8,  powerCalculator.raiseToPower(-2, 3),"shouldRaiseToPowerTestNegNumberPosOddPower");
    }

    private static void shouldRaiseToPowerTestNegNumberPosEvenPower() {
        totalRun++;
        checkResult(16,  powerCalculator.raiseToPower(-2, 4),"shouldRaiseToPowerTestNegNumberPosEvenPower");
    }

    private static void shouldRaiseToPowerTestNegNumberNegOddPower() {
        totalRun++;
        checkResult(-0.125,  powerCalculator.raiseToPower(-2, -3),"shouldRaiseToPowerTestNegNumberNegOddPower");
    }

    private static void shouldRaiseToPowerTestNegNumberNegEvenPower() {
        totalRun++;
        checkResult(0.0625,  powerCalculator.raiseToPower(-2, -4),"shouldRaiseToPowerTestNegNumberNegEvenPower");
    }

    private static void checkResult(double expectedResult, double actualResult, String testName) {
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
}

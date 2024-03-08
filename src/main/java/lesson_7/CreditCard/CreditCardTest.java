package lesson_7.CreditCard;

class CreditCardTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    public static void main(String[] args) {
        shouldCreateCreditCardTest();
        shouldBeAbleToChangeCreditLimitTest();
        shouldRejectOnInvalidPinForDepositTest();
        shouldRejectOnInvalidPinForWithdrawTest();
        shouldDepositAllAmountToBalanceIfNoCreditDebtTest();
        shouldDepositToCreditDebtFirstTest();
        shouldDepositToCreditDebtThenToBalanceTest();
        shouldWithdrawFromBalanceIfSufficientFundsTest();
        shouldWithdrawIfAmountBiggerThanBalanceButCreditLimitAllowsTest();
        shouldRejectWithdrawalIfAmountBiggerThanBalanceAndCreditLimitTest();
        printFooter();
    }

    private static void shouldCreateCreditCardTest() {
        totalRun++;
        CreditCard card = new CreditCard(12345, 0);
        boolean result = (card != null && card.getNumber() == 12345 && card.getPin() == 0  &&
                card.getBalance() == 0 && card.getCreditDebt() == 0 && card.getCreditLimit() == 0);
        String expected = "CreditCard{number=12345, pin=0, balance=0.0, creditLimit=0.0, creditDebt=0.0}";
        checkResult(result, expected, card.toString(),"shouldCreateCreditCardTest");
    }

    private static void shouldBeAbleToChangeCreditLimitTest() {
        totalRun++;
        CreditCard card = new CreditCard(12345, 0);
        card.setCreditLimit(100);
        checkResult(100, card.getCreditLimit(),"shouldBeAbleToChangeCreditLimitTest");
    }

    private static void shouldRejectOnInvalidPinForDepositTest() {
        totalRun++;
        CreditCard card = new CreditCard(12345, 1);
        checkResult(false, card.deposit(5, 100),"shouldRejectOnInvalidPinForDepositTest");
    }

    private static void shouldDepositAllAmountToBalanceIfNoCreditDebtTest() {
        totalRun++;
        CreditCard card = new CreditCard(12345, 0);
        OperationResult actual = processDeposit(card, 0, 100);
        OperationResult expected = new OperationResult(true, 100, 0, 0);
        checkResult(expected, actual,"shouldDepositAllAmountToBalanceIfNoCreditDebtTest");

    }

    private static void shouldDepositToCreditDebtFirstTest() {
        totalRun++;
        CreditCard card = new CreditCard(12345, 0);
        card.setCreditLimit(100);
        card.withdraw(0, 50);
        OperationResult actual = processDeposit(card, 0, 30);
        OperationResult expected = new OperationResult(true, 0, 20, 100);
        checkResult(expected, actual,"shouldDepositToCreditDebtFirstTest");

    }

    private static void shouldDepositToCreditDebtThenToBalanceTest() {
        totalRun++;
        CreditCard card = new CreditCard(12345, 0);
        card.setCreditLimit(100);
        card.withdraw(0, 50);
        OperationResult actual = processDeposit(card, 0, 60);
        OperationResult expected = new OperationResult(true, 10, 0, 100);
        checkResult(expected, actual,"shouldDepositToCreditDebtThenToBalanceTest");

    }

    private static void shouldRejectOnInvalidPinForWithdrawTest() {
        totalRun++;
        CreditCard card = new CreditCard(12345, 1);
        checkResult(false, card.withdraw(5, 100),"shouldRejectOnInvalidPinForWithdrawTest");
    }

    private static void shouldWithdrawFromBalanceIfSufficientFundsTest() {
        totalRun++;
        CreditCard card = new CreditCard(12345, 0);
        card.deposit(0, 100);
        OperationResult actual = processWithdraw(card, 0, 25);
        OperationResult expected = new OperationResult(true, 75, 0, 0);
        checkResult(expected, actual,"shouldWithdrawFromBalanceIfSufficientFundsTest");
    }

    private static void shouldWithdrawIfAmountBiggerThanBalanceButCreditLimitAllowsTest() {
        totalRun++;
        CreditCard card = new CreditCard(12345, 0);
        card.setCreditLimit(100);
        card.deposit(0, 10);
        OperationResult actual = processWithdraw(card, 0, 50);
        OperationResult expected = new OperationResult(true, 0, 40, 100);
        checkResult(expected, actual,"shouldWithdrawIfAmountBiggerThanBalanceButCreditLimitAllowsTest");
    }

    private static void shouldRejectWithdrawalIfAmountBiggerThanBalanceAndCreditLimitTest() {
        totalRun++;
        CreditCard card = new CreditCard(12345, 0);
        card.setCreditLimit(10);
        card.deposit(0, 10);
        OperationResult actual = processWithdraw(card, 0, 50);
        OperationResult expected = new OperationResult(false, 10, 0, 10);
        checkResult(expected, actual,"shouldRejectWithdrawalIfAmountBiggerThanBalanceAndCreditLimitTest");
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

    private static void checkResult(OperationResult expectedResult, OperationResult actualResult, String testName) {
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

    private static void checkResult(boolean expectedResult, boolean actualResult, String testName) {
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

    private static void checkResult(boolean succeed, String expectedResult, String actualResult, String testName) {
        if (succeed) {
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

    private static OperationResult processDeposit(CreditCard card, int pin, double amount) {
        if (card == null) {
            return null;
        }
        OperationResult result = new OperationResult();
        result.setSuccessful(card.deposit(pin, amount));
        result.setBalance(card.getBalance());
        result.setCreditDebt(card.getCreditDebt());
        result.setCreditLimit(card.getCreditLimit());
        return result;
    }

    private static OperationResult processWithdraw(CreditCard card, int pin, double amount) {
        if (card == null) {
            return null;
        }
        OperationResult result = new OperationResult();
        result.setSuccessful(card.withdraw(pin, amount));
        result.setBalance(card.getBalance());
        result.setCreditDebt(card.getCreditDebt());
        result.setCreditLimit(card.getCreditLimit());
        return result;
    }

}
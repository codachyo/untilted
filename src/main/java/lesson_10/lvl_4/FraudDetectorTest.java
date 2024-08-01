package lesson_10.lvl_4;

class FraudDetectorTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static FraudDetector fraudDetector = new FraudDetector();

    public static void main(String[] args) {
        isFraudTestPokemon();
        isFraudTestNotPokemon();
        isFraudTestAmountRuleBreach();
        isFraudTestAmountRuleOk();
        isFraudTestCity();
        isFraudTestCountry();
        isFraudTestCountryAndAmount();
        printFooter();
    }


    private static void isFraudTestPokemon() {
        totalRun++;
        Transaction transaction = new Transaction(new Trader("Pokemon", "City1", "Country1"), 0);
        checkResult(fraudDetector.isFraud(transaction),"isFraudTestPokemon");
    }

    private static void isFraudTestNotPokemon() {
        totalRun++;
        Transaction transaction = new Transaction(new Trader("Pokemon111", "City1", "Country1"), 0);
        checkResult(!fraudDetector.isFraud(transaction),"isFraudTestNotPokemon");
    }

    private static void isFraudTestAmountRuleBreach() {
        totalRun++;
        Transaction transaction = new Transaction(new Trader("Name2", "city", "Mambey"), 1000001);
        checkResult(fraudDetector.isFraud(transaction), "isFraudTestAmountRuleBreach");
    }

    private static void isFraudTestAmountRuleOk() {
        totalRun++;
        Transaction transaction = new Transaction(new Trader("Name2", "city", "Mambey"), 1000000);
        checkResult(!fraudDetector.isFraud(transaction), "isFraudTestAmountRuleOk");
    }

    private static void isFraudTestCity() {
        totalRun++;
        Transaction transaction = new Transaction(new Trader("Name1", "Sidney", "Country1"), 0);
        checkResult(fraudDetector.isFraud(transaction),"isFraudTestCity");
    }

    private static void isFraudTestCountry() {
        totalRun++;
        Transaction transaction = new Transaction(new Trader("Name1", "City1", "Ямайка"), 0);
        checkResult(fraudDetector.isFraud(transaction),"isFraudTestCountry");
    }

    private static void isFraudTestCountryAndAmount() {
        totalRun++;
        Transaction transaction = new Transaction(new Trader("Name1", "City1", "Germany"), 1001);
        checkResult(fraudDetector.isFraud(transaction),"isFraudTestCountryAndAmount");
    }

    private static void checkResult(boolean result, String testName) {
        if (result) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + !result);
            System.out.println("Actual:   " + result + TEXT_RESET);
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

package lesson_7.credit_card;

class CreditCard {
    private int number;
    private int pin;
    private double balance;
    private double creditLimit;
    private double creditDebt;

    public int getNumber() {
        return number;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getCreditDebt() {
        return creditDebt;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public CreditCard(int number, int pin) {
        this.number = number;
        this.pin = pin;
        this.balance = 0;
        this.creditLimit = 0;
        this.creditDebt = 0;
    }

    public boolean deposit(int pin, double amount) {
        if (this.pin != pin) {
            return false;
        }
        if (creditDebt > 0) {
            amount = decreaseCreditDebt(amount);
        }
        if (amount > 0) {
            balance += amount;
        }
        return true;
    }

    public boolean withdraw(int pin, double amount) {
        if (this.pin != pin) {
            return false;
        }
        if (!isWithdrawalAvailable(amount)) {
            return false;
        }
        if (balance > 0) {
            amount = decreaseBalance(amount);
            if (amount > 0) {
                creditDebt += amount;
            }
        } else {
            creditDebt += amount;
        }
        return true;
    }

    private boolean isWithdrawalAvailable(double amount) {
        double remainder = balance - amount;
        if (!(remainder < 0)) {
            return true;
        }
        double sum = remainder * (-1) + creditDebt;
        return !(sum > creditLimit);
    }

    private double decreaseBalance(double amount) {
        double remainder = 0;
        balance -= amount;
        if (balance < 0) {
            remainder = balance * (-1);
            balance = 0;
        }
        return remainder;
    }

    private double decreaseCreditDebt(double amount) {
        double remainder = 0;
        creditDebt -= amount;
        if (creditDebt < 0) {
            remainder = creditDebt * (-1);
            creditDebt = 0;
        }
        return remainder;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "number=" + number +
                ", pin=" + pin +
                ", balance=" + balance +
                ", creditLimit=" + creditLimit +
                ", creditDebt=" + creditDebt +
                '}';
    }
}

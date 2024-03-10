package lesson_7.credit_card;

class OperationResult {
    private boolean successful;
    private double balance;
    private double creditDebt;
    private double creditLimit;

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCreditDebt(double creditDebt) {
        this.creditDebt = creditDebt;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public OperationResult() {
    }

    public OperationResult(boolean successful, double balance, double creditDebt, double creditLimit) {
        this.successful = successful;
        this.balance = balance;
        this.creditDebt = creditDebt;
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationResult that = (OperationResult) o;
        return successful == that.successful && Double.compare(that.balance, balance) == 0 &&
                Double.compare(that.creditDebt, creditDebt) == 0 && Double.compare(that.creditLimit, creditLimit) == 0;
    }

    @Override
    public String toString() {
        return "OperationResult{" +
                "successful=" + successful +
                ", balance=" + balance +
                ", creditDebt=" + creditDebt +
                ", creditLimit=" + creditLimit +
                '}';
    }
}

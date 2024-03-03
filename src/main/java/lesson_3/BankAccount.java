package lesson_3;

public class BankAccount {
    String name;
    double money;
    int pin;

    public BankAccount(String name, double money, int pin) {
        this.name = name;
        this.money = money;
        this.pin = pin;
    }
    double getMoney(int pin, double amount) {
        if( this.pin == pin) {
            money = money-  amount;
            return amount;

        }
        return  0.0;
    }
}

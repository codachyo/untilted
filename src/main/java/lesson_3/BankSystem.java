package lesson_3;

public class BankSystem {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("Mark", 1000.0, 1111);
        double money = bankAccount.getMoney (1111, 500.0);
        System.out.println(money);
        System.out.println(bankAccount.money);
        }
    }


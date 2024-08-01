package lesson_10.lvl_1;

class SafeV2Demo {
    public static void main(String[] args) {
        SafeV2 safe = new SafeV2("qwerty", 1000);
        System.out.println("Initial amount = " + safe.getAmount());
        safe.putMoney("a", 2000);
        System.out.println("Amount after deposit with invalid password = " + safe.getAmount());
        safe.putMoney("qwerty", 4000);
        System.out.println("Amount after deposit with valid password = " + safe.getAmount());
        safe.getMoney("a", 1000);
        System.out.println("Amount after withdrawal with invalid password = " + safe.getAmount());
        safe.getMoney("qwerty", 2000);
        System.out.println("Amount after withdrawal with valid password = " + safe.getAmount());
    }
}

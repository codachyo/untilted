package lesson_10.lvl_1;

class SafeDemo {
public static void main(String[] args) {
    Safe safe = new Safe();
    System.out.println("Initial pin = " + safe.pin);
    System.out.println("Initial amount = " + safe.amount);
    safe.pin = 1111111111;
    safe.amount = 5000;
    System.out.println("Updated pin = " + safe.pin);
    System.out.println("Updated amount = " + safe.amount);
}
}

package lesson_3;

public class ObjectsMobilePhone {
    public static void main(String[] args) {
        MobilePhone samsung = new MobilePhone("S20", "Black", 500.20, "Android", 32);
        MobilePhone apple = new MobilePhone("X20", "Blue", 1500.20, "IOS", 12);
        System.out.println(samsung);
        apple.makeCall();
        apple.sendMessages();
        apple.receiveCall();

        System.out.println("");

        samsung.makeCall();
        samsung.sendMessages();
        samsung.sendMessages();
        samsung.receiveCall();

    }
}

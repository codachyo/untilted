package lesson_3;

public class DogDemo {
    public static void main(String[] args) {
        Dog sharik = new Dog("Sharik");
        Dog rex = new Dog("Rex");

        sharik.sleep();
        rex.sleep();

        System.out.println(sharik.age);
        System.out.println(rex.age);

        sharik.happyBirthday();
        sharik.happyBirthday();
        sharik.happyBirthday();
        sharik.happyBirthday();
        sharik.happyBirthday();
        sharik.happyBirthday();
        sharik.happyBirthday();
        sharik.happyBirthday();
        System.out.println(sharik.age);
        System.out.println(rex.age);
    }
}

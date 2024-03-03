package lesson_3;

public class Dog {
    String name;
    int age;
    boolean isHungry;
    Dog(String name) {
        this.name = name;
        this.age = 0;
        this.isHungry = false;

    }

    void sleep() {
        System.out.println("I'm sleeping");
    }

    void eat() {
        isHungry = false;
    }
    void happyBirthday(){
        age++;
    }
}

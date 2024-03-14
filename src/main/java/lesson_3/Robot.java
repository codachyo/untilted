package lesson_3;


class Robot {

    String name;

    public Robot() {

    }
    public Robot(String robotName) {
        this.name = robotName;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

    public void sayYourName() {
        if (name == null || name.isEmpty()) {
            System.out.println("My name is ROBO");
        } else {
            System.out.println("My name is " + name);
        }

    }
}
package lesson_3;


// Task_1, Task_2, Task_5, Task_15, Task_12, Task_13
class Robot {

    String name;

    //  Constructor without parameters
    public Robot() {

    }

    //  Constructor with parameter
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
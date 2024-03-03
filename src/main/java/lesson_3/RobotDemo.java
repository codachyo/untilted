package lesson_3;
class RobotDemo {

    public static void main(String[] args) {

        Robot robot = new Robot();
        robot.sayHello();
        robot.sayYourName();

        Robot robot1 = new Robot();
        robot1.sayHello();
        robot1.sayYourName();

        Robot robot2 = new Robot();
        robot2.sayHello();
        robot2.sayYourName();

        Robot robot3 = new Robot();
        robot3.sayHello();
        robot3.sayYourName();

        Robot robot4 = new Robot("Rider");
        robot4.sayHello();
        robot4.sayYourName();

        Robot robot5 = new Robot("John");
        robot5.sayHello();
        robot5.sayYourName();
    }
}
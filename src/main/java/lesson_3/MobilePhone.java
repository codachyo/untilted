package lesson_3;

public class MobilePhone {
String model;
String color;
double price;
String operationSystem;
int RAM;

MobilePhone(String model, String color, double price, String operationSystem, int RAM) {

    this.model = model;
    this.color = color;
    this.price = price;
    this.operationSystem = operationSystem;
    this.RAM = RAM;
}
 void makeCall() {
    System.out.println("I'm making call . . .");
}
 void receiveCall() {
    System.out.println("I'm receiving a call . . . ");
}
 void sendMessages(){
    System.out.println("Sending a messages. . .");
}
    }

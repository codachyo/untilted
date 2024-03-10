package lesson_4.homework;

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide a 2 numbers");
        int userInput1 = scanner.nextInt();
        int userInput2 = scanner.nextInt();

        if (userInput1 < userInput2) {
            System.out.println(userInput1);

        } else if (userInput2 < userInput1) {
            System.out.println(userInput2);

        } else {
            System.out.println("Number are equal");
        }
    }
}

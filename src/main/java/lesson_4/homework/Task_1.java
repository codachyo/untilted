package lesson_4.homework;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide a number: ");
        int userInput = scanner.nextInt();

        if (userInput < 0) {
            System.out.println("Provided number is negative");
        } else {
            System.out.println("Provided number is positive");

            scanner.close();
        }
    }
}

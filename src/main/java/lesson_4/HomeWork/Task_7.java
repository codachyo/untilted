package lesson_4.HomeWork;

import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide a 2 numbers");
        int userInput1 = scanner.nextInt();
        int userInput2 = scanner.nextInt();

        if (userInput1 == userInput2) {
            System.out.println("Number are equal");
        } else if (userInput1 != userInput2) {
            System.out.println("Number are different");
        } else {
            System.out.println("Ya gey");
        }
    }
}

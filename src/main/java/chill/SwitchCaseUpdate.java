package chill;

import java.util.Scanner;

public class SwitchCaseUpdate {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select menu item");

        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                System.out.println("kris <3");
                break;
            case 2:
                System.out.println("mila");
                break;
            case 3:
                System.out.println("sosiska");
                break;
            case 4:
                printAllNames();
                break;
            default:
                System.out.println("ti loh");
        }

    }

    public static void printAllNames() {
        String[] names = {"kris <3", "mila", "sosiska"};
        System.out.println("All names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}

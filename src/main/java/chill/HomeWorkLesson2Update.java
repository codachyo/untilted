package chill;

import java.util.Scanner;

    public class HomeWorkLesson2Update {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            String[] names = new String[5];

            String allNames = "";

            for (int i = 0; i < names.length; i++) {
                System.out.println("Say your name:");
                names[i] = scanner.nextLine();
                allNames += names[i] + " ";
                System.out.println("Your name is: " + names[i]);
            }

            System.out.print("Hello ");
            for (String name : names) {
                System.out.print(name + " ");
            }

            System.out.println("\nAll names: " + allNames);

            scanner.close();
        }
    }


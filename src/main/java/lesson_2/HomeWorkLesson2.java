package lesson_2;

import java.util.Scanner;

public class HomeWorkLesson2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Массив для хранения имен
        String[] names = new String[5555555];

        // Цикл для запроса имен у пользователя
        for (int i = 0; i < names.length; i++) {
            System.out.println("Say your name:");
            names[i] = scanner.nextLine();
            System.out.println("Your name is: " + names[i]);
        }

        // Вывод приветствия с именами, введёнными пользователем
        System.out.print("Hello ");
        for (String name : names) {
            System.out.print(name + " ");
            scanner.close();
        }
    }
}

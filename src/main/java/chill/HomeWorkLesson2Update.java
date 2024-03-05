package chill;

import java.util.Scanner;

    public class HomeWorkLesson2Update {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            // Массив для хранения имен
            String[] names = new String[5];

            // Переменная для хранения всех введенных имен
            String allNames = "";

            // Цикл для запроса имен у пользователя
            for (int i = 0; i < names.length; i++) {
                System.out.println("Say your name:");
                names[i] = scanner.nextLine();
                allNames += names[i] + " "; // Добавляем имя к строке всех имен
                System.out.println("Your name is: " + names[i]);
            }

            // Вывод приветствия с именами, введёнными пользователем
            System.out.print("Hello ");
            for (String name : names) {
                System.out.print(name + " ");
            }

            // Вывод всех введенных имен
            System.out.println("\nAll names: " + allNames);

            scanner.close();
        }
    }


package lesson_2;

import java.util.Scanner;

public class MyScanner {
    public static void main(String[] args) {
        // Создаем объект Scanner, связанный с System.in (стандартный поток ввода - консоль)
        Scanner scanner = new Scanner(System.in);

        // Считываем строку и выводим ее
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");

        // Считываем целое число и выводим его
        int age = scanner.nextInt();
        System.out.println("Введите ваш возраст:");
        System.out.println("Ваш возраст: " + age);

        // Закрываем Scanner, когда он больше не нужен, чтобы освободить ресурсы
        scanner.close();
    }
}

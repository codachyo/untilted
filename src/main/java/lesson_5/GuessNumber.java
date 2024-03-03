package lesson_5;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int guess = -1;

        System.out.println("Добро пожаловать в игру 'Угадай число'!");
        System.out.println("Я загадал число от 1 до 100. Попробуйте угадать его.");

        while (guess != numberToGuess) {
            System.out.print("Введите ваше предположение: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Мое число больше.");
            } else if (guess > numberToGuess) {
                System.out.println("Мое число меньше.");
            } else {
                System.out.println("Поздравляю! Вы угадали число " + numberToGuess + " за " + attempts + " попыток.");
            }
        }

        scanner.close();
    }
}

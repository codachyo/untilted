package lesson_4;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //(System.in - запрашивает ввод переменной

        System.out.println("Please select menu item");
        int userInput = scanner.nextInt();
        //scanner.nextInt - просит цифру

        switch (userInput) {
            case 1:
                System.out.println("kris <3");
                break;
                //break - останавливает выполнение
            case 2:
                System.out.println("mila");
                break;
            case 3:
                System.out.println("sosiska");
                break;
            default:
                //default - все, что не кейсы (в этом примере кейсы это 1,2,3)
                System.out.println("ti loh");
        }

    }
}

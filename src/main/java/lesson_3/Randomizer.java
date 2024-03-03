package lesson_3;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static void main(String[] args) {
        String word = getRandomWord();
        System.out.println(word);
    }

    public static String getRandomWord() {
        String[] words = {"писать", "не писать"};
        int randomIndex = ThreadLocalRandom.current().nextInt(words.length);
        return words[randomIndex];
    }
}

package lesson_7.WordService;

import java.util.Arrays;
class WordService {
    public String findMostFrequentWord(String text) {
        String marksFreeText = removePunctuationMarks(text);
        String[] split = removeAllEmptyStrings(splitString(marksFreeText));

        String[] notDuplicated = removeDuplicates(split);
        if (notDuplicated == null) {
            return "";
        }

        int count;
        int max = 0;
        String result = "";
        for (String s : notDuplicated) {
            count = stringAppearance(split, s);
            if (max < count) {
                max = count;
                result = s.toLowerCase();
            }
        }

        return result;
    }

    public String removePunctuationMarks(String str) {
        return str.replaceAll("[^a-zA-Zа-яА-Я]", " ");
    }

    public String[] splitString(String str) {
        if (str.isEmpty()) {
            return null;
        }
        return str.split(" ");
    }

    public String[] removeAllEmptyStrings(String[] arr) {
        if (arr == null) {
            return null;
        }

        String[] result = new String[arr.length];
        int amountOfValidStrings = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].isBlank()) {
                result[amountOfValidStrings++] = arr[i];
            }
        }

        return Arrays.copyOf(result, amountOfValidStrings);
    }

    public String[] removeDuplicates(String[] original) {
        if (original == null) {
            return null;
        }

        String[] copied = original.clone();

        for (int j = 0; j < copied.length - 1; j++) {
            if (copied[j].isBlank()) {
                continue;
            }
            for (int i = j + 1; i < copied.length - 1; i++) {
                if (copied[i].isBlank()) {
                    continue;
                }
                if (copied[j].equalsIgnoreCase(copied[i])) {
                    copied[i] = "";
                }
            }
        }

        return removeAllEmptyStrings(copied);
    }

    public int stringAppearance(String[] arr, String stringToSearch) {
        if (arr == null) {
            return 0;
        }

        int count = 0;

        for (String s : arr) {
            if (s.equalsIgnoreCase(stringToSearch)) {
                count++;
            }
        }

        return count;
    }
}

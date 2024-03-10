package lesson_7.palidrome;

class Palindrome {
    boolean isPalindrome(String text) {
        String str = (text.replaceAll("[^a-zA-Zа-яА-Я]", "")).toLowerCase();
        char[] textChars = str.toCharArray();
        char[] reverseTextChars = new char[textChars.length];

        for (int i = 0; i < textChars.length; i++) {
            reverseTextChars[i] = textChars[textChars.length - i - 1];
        }

        for (int i = 0; i < textChars.length; i++) {
            if (textChars[i] != reverseTextChars[i]) {
                return false;
            }
        }
        return true;
    }
}

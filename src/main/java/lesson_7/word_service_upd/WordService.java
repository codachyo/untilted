package lesson_7.word_service_upd;

class WordService {
    public String findMostFrequentWord(String text) {
        String[] textArray = text.split(" ");;
        int[] wordCountArray = countWordsAppearance(textArray);
        int index = gecMostFrequentWordIndex(wordCountArray);
        return textArray[index];
    }

    private int[] countWordsAppearance(String[] arr) {
        int count = 0;
        int[] countArray = new int[arr.length];
        for (int wordCount = 0; wordCount < arr.length; wordCount++) {
            for (String s : arr) {
                if (arr[wordCount].equals(s)) {
                    count++;
                }
            }
            countArray[wordCount] = count;
            count = 0;
        }
        return countArray;
    }

    private int gecMostFrequentWordIndex(int[] arr) {
        int max = 0;
        for (int count =0; count < arr.length; count++) {
            if (arr[count] > max) {
                max = count;
            }
        }
        return max;
    }
}

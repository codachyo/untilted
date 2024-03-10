package lesson_6.while_infinite_loop;

class WhileLoopContinue {
    public static void main(String[] args) {
        int i = 0;
        while(i < 5) {
            if (i == 3) {
                i++;
                continue;
            }
            System.out.println("Loop iteration " + (i + 1));
            i++;
        }
    }
}

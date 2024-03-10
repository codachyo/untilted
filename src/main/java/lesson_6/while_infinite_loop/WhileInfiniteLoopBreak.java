package lesson_6.while_infinite_loop;

class WhileInfiniteLoopBreak {

    public static void main(String[] args) {
        int i = 1;
        while(true) {
            if (i > 5) {
                break;
            }
            System.out.println("Loop iteration " + i);
            i++;
        }
    }
}

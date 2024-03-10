package lesson_6.tic_tac_toe;

class Move {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

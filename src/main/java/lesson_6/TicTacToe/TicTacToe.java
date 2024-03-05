package lesson_6.TicTacToe;

import java.util.Random;
import java.util.Scanner;

class TicTacToe {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }

    public void play() {
        Move move0, move1;
        int[][] field = createField();
        int playerComputer = getPlayerNumberForComputer();
        while (true) {
            System.out.println("* Player's 0 turn *");
            printFieldToConsole(field);
            if (playerComputer == 0) {
                move0 = getNextComputerMove(field, 0);
            } else {
                move0 = getNextMove(field);
            }
            field[move0.getX()][move0.getY()] = 0;
            printFieldToConsole(field);
            if (isWinPosition(field, 0)) {
                System.out.println("Player 0 WIN!");
                break;
            }
            if (isDrawPosition(field)) {
                System.out.println("DRAW!");
                break;
            }

            System.out.println("* Player's 1 turn *");
            printFieldToConsole(field);
            if (playerComputer == 1) {
                move1 = getNextComputerMove(field, 1);
            } else {
                move1 = getNextMove(field);
            }
            field[move1.getX()][move1.getY()] = 1;
            printFieldToConsole(field);
            if (isWinPosition(field, 1)) {
                System.out.println("Player 1 WIN!");
                break;
            }
            if (isDrawPosition(field)) {
                System.out.println("DRAW!");
                break;
            }
        }
    }

    public boolean isWinPositionForHorizontals(int[][] field, int playerToCheck) {
        boolean isWin = false;

        for (int i = 0; i < field.length; i++) {
            isWin = true;
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] != playerToCheck) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                break;
            }
        }
        return isWin;
    }

    public boolean isWinPositionForVerticals(int[][] field, int playerToCheck) {
        boolean isWin = false;

        for (int j = 0; j < field.length; j++) {
            isWin = true;
            for (int i = 0; i < field.length; i++) {
                if (field[i][j] != playerToCheck) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                break;
            }
        }
        return isWin;
    }

    public boolean isWinPositionForDiagonals(int[][] field, int playerToCheck) {
        return diagonalPositionFromTopToBottom(field, playerToCheck) ||
                diagonalPositionFromBottomToTop(field, playerToCheck);
    }

    private boolean diagonalPositionFromTopToBottom(int[][] field, int playerToCheck) {
        for (int i = 0; i < field.length; i++) {
            if (field[i][i] != playerToCheck) {
                return false;
            }
        }
        return true;
    }

    private boolean diagonalPositionFromBottomToTop(int[][] field, int playerToCheck) {
        for (int i = 0; i < field.length; i++) {
            if (field[i][field.length - i - 1] != playerToCheck) {
                return false;
            }
        }
        return true;
    }

    public boolean isWinPosition(int[][] field, int playerToCheck) {
        return (isWinPositionForHorizontals(field, playerToCheck) ||
                isWinPositionForVerticals(field, playerToCheck) ||
                isWinPositionForDiagonals(field, playerToCheck));
    }

    public boolean isDrawPosition(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] createField() {
        int[][] result = new int[3][3];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = -1;
            }
        }
        return result;
    }

    public Move getNextMove(int[][] field) {
        do {
            System.out.println("Your move coordinates");

            System.out.print("Please provide horizontal from 1 till 3: ");
            int x = scanner.nextInt();
            if (x < 1 || x > 3) {
                System.out.println("Wrong input, please try again!");
                continue;
            }

            System.out.print("Please provide vertical from 1 till 3: ");
            int y = scanner.nextInt();
            if (y < 1 || y > 3) {
                System.out.println("Wrong input, please try again!");
                continue;
            }

            if (!(field[x - 1][y - 1] == -1)) {
                System.out.println("Selected cell is not empty! Please try again.");
                continue;
            }

            return new Move(x - 1, y - 1);
        } while (true);
    }

    public void printFieldToConsole(int[][] field) {
        if (field.length == 0) {
            return;
        }
        System.out.println("--------");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] < 0) {
                    System.out.print(field[i][j] + " ");
                } else {
                    System.out.print(" " + field[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("--------");
    }

    public int getPlayerNumberForComputer() {

        System.out.println("Do you wish to play with computer?");
        System.out.println(" 0 - Player 0 is computer");
        System.out.println(" 1 - Player 1 is computer");
        System.out.println("-1 - Play without computer (default mode)");
        System.out.print("Your choice: ");
        int x = scanner.nextInt();
        return (x != 0 && x != 1 && x != -1) ? -1 : x;
    }

    public Move getNextComputerMove(int[][] field, int player) {
        Move move;

        move = checkComputerWinInOneTurn(field, player);
        if (move != null) {
            return move;
        }

        move = checkComputerLossInOneTurn(field, player);
        if (move != null) {
            return move;
        }

        return chooseRandomEmptyCell(field);
    }

    public Move checkComputerWinInOneTurn(int[][] field, int player) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == -1) {
                    field[i][j] = player;
                    if (isWinPosition(field, player)) {
                        field[i][j] = -1;
                        return new Move(i, j);
                    }
                    field[i][j] = -1;
                }
            }
        }
        return null;
    }

    public Move checkComputerLossInOneTurn(int[][] field, int player) {
        int opponent = (player == 0) ? 1 : 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == -1) {
                    field[i][j] = opponent;
                    if (isWinPosition(field, opponent)) {
                        field[i][j] = -1;
                        return new Move(i, j);
                    }
                    field[i][j] = -1;
                }
            }
        }
        return null;
    }

    public Move chooseRandomEmptyCell(int[][] field) {
        Random random = new Random();
        int x, y;

        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
            if (field[x][y] == -1) {
                return new Move(x, y);
            }
        } while (true);
    }
}

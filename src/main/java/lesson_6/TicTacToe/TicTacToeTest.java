package lesson_6.TicTacToe;

class TicTacToeTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static TicTacToe ticTacToe = new TicTacToe();

    public static void main(String[] args) {
        isWinPositionForHorizontalsTestLine1Player1();
        isWinPositionForHorizontalsTestLine2Player1();
        isWinPositionForHorizontalsTestLine3Player1();
        isWinPositionForHorizontalsTestNoWinPlayer1();
        isWinPositionForHorizontalsTestLine1Player2();
        isWinPositionForHorizontalsTestLine2Player2();
        isWinPositionForHorizontalsTestLine3Player2();
        isWinPositionForHorizontalsTestNoWinPlayer2();

        isWinPositionForVerticalsTestColumn1Player1();
        isWinPositionForVerticalsTestColumn2Player1();
        isWinPositionForVerticalsTestColumn3Player1();
        isWinPositionForVerticalsTestNoWinPlayer1();
        isWinPositionForVerticalsTestColumn1Player2();
        isWinPositionForVerticalsTestColumn2Player2();
        isWinPositionForVerticalsTestColumn3Player2();
        isWinPositionForVerticalsTestNoWinPlayer2();

        isWinPositionForDiagonalsTestDiagonal1Player1();
        isWinPositionForDiagonalsTestDiagonal2Player1();
        isWinPositionForDiagonalsTestNoWinPlayer1();
        isWinPositionForDiagonalsTestDiagonal1Player2();
        isWinPositionForDiagonalsTestDiagonal2Player2();
        isWinPositionForDiagonalsTestNoWinPlayer2();

        isWinPositionTestHorizontalPlayer1();
        isWinPositionTestVerticalPlayer1();
        isWinPositionTestDiagonalPlayer1();
        isWinPositionTestNoWinPlayer1();
        isWinPositionTestHorizontalPlayer2();
        isWinPositionTestVerticalPlayer2();
        isWinPositionTestDiagonalPlayer2();
        isWinPositionTestNoWinPlayer2();

        isDrawPositionTestWinPlayer1NoDraw();
        isDrawPositionTestWinPlayer2NoDraw();
        isDrawPositionTestEmptyCellsNoDraw();
        isDrawPositionTestDrawScenario();

        createFieldTestSucceed();

        printFooter();
    }

    private static void isWinPositionForHorizontalsTestLine1Player1() {
        totalRun++;
        int[][] inputArray = {{0, 0, 0},
                {1, 1, -1},
                {-1, -1, -1}};
        checkResult(true, ticTacToe.isWinPositionForHorizontals(inputArray, 0), "isWinPositionForHorizontalsTestLine1Player1");
    }

    private static void isWinPositionForHorizontalsTestLine2Player1() {
        totalRun++;
        int[][] inputArray = {{1, 1, -1},
                {0, 0, 0},
                {-1, -1, -1}};
        checkResult(true, ticTacToe.isWinPositionForHorizontals(inputArray, 0), "isWinPositionForHorizontalsTestLine2Player1");
    }

    private static void isWinPositionForHorizontalsTestLine3Player1() {
        totalRun++;
        int[][] inputArray = {{1, 1, -1},
                {-1, -1, -1},
                {0, 0, 0}};
        checkResult(true, ticTacToe.isWinPositionForHorizontals(inputArray, 0), "isWinPositionForHorizontalsTestLine3Player1");
    }

    private static void isWinPositionForHorizontalsTestNoWinPlayer1() {
        totalRun++;
        int[][] inputArray = {{1, 1, -1},
                {-1, 0, -1},
                {0, 0, -1}};
        checkResult(false, ticTacToe.isWinPositionForHorizontals(inputArray, 0), "isWinPositionForHorizontalsTestNoWinPlayer1");
    }

    private static void isWinPositionForHorizontalsTestLine1Player2() {
        totalRun++;
        int[][] inputArray = {{1, 1, 1},
                {0, 0, -1},
                {-1, 0, 0}};
        checkResult(true, ticTacToe.isWinPositionForHorizontals(inputArray, 1), "isWinPositionForHorizontalsTestLine1Player2");
    }

    private static void isWinPositionForHorizontalsTestLine2Player2() {
        totalRun++;
        int[][] inputArray = {{0, 0, -1},
                {1, 1, 1},
                {-1, 0, 0}};
        checkResult(true, ticTacToe.isWinPositionForHorizontals(inputArray, 1), "isWinPositionForHorizontalsTestLine2Player2");
    }

    private static void isWinPositionForHorizontalsTestLine3Player2() {
        totalRun++;
        int[][] inputArray = {{0, 0, -1},
                {-1, 0, 0},
                {1, 1, 1}};
        checkResult(true, ticTacToe.isWinPositionForHorizontals(inputArray, 1), "isWinPositionForHorizontalsTestLine3Player2");
    }

    private static void isWinPositionForHorizontalsTestNoWinPlayer2() {
        totalRun++;
        int[][] inputArray = {{1, 1, -1},
                {-1, 0, -1},
                {0, 0, -1}};
        checkResult(false, ticTacToe.isWinPositionForHorizontals(inputArray, 1), "isWinPositionForHorizontalsTestNoWinPlayer2");
    }

    private static void isWinPositionForVerticalsTestColumn1Player1() {
        totalRun++;
        int[][] inputArray = {{0, 1, -1},
                {0, 1, -1},
                {0, -1, -1}};
        checkResult(true, ticTacToe.isWinPositionForVerticals(inputArray, 0), "isWinPositionForVerticalsTestColumn1Player1");
    }

    private static void isWinPositionForVerticalsTestColumn2Player1() {
        totalRun++;
        int[][] inputArray = {{1, 0, -1},
                {1, 0, -1},
                {-1, 0, -1}};
        checkResult(true, ticTacToe.isWinPositionForVerticals(inputArray, 0), "isWinPositionForVerticalsTestColumn2Player1");
    }

    private static void isWinPositionForVerticalsTestColumn3Player1() {
        totalRun++;
        int[][] inputArray = {{1, 1, 0},
                {-1, -1, 0},
                {-1, -1, 0}};
        checkResult(true, ticTacToe.isWinPositionForVerticals(inputArray, 0), "isWinPositionForVerticalsTestColumn3Player1");
    }

    private static void isWinPositionForVerticalsTestNoWinPlayer1() {
        totalRun++;
        int[][] inputArray = {{1, 1, -1},
                {-1, 0, -1},
                {0, 0, -1}};
        checkResult(false, ticTacToe.isWinPositionForVerticals(inputArray, 0), "isWinPositionForVerticalsTestNoWinPlayer1");
    }

    private static void isWinPositionForVerticalsTestColumn1Player2() {
        totalRun++;
        int[][] inputArray = {{1, -1, 0},
                {1, 0, -1},
                {1, 0, 0}};
        checkResult(true, ticTacToe.isWinPositionForVerticals(inputArray, 1), "isWinPositionForVerticalsTestColumn1Player2");
    }

    private static void isWinPositionForVerticalsTestColumn2Player2() {
        totalRun++;
        int[][] inputArray = {{0, 1, -1},
                {0, 1, 0},
                {-1, 1, 0}};
        checkResult(true, ticTacToe.isWinPositionForVerticals(inputArray, 1), "isWinPositionForVerticalsTestColumn2Player2");
    }

    private static void isWinPositionForVerticalsTestColumn3Player2() {
        totalRun++;
        int[][] inputArray = {{0, 0, 1},
                {-1, 0, 1},
                {0, -1, 1}};
        checkResult(true, ticTacToe.isWinPositionForVerticals(inputArray, 1), "isWinPositionForVerticalsTestColumn3Player2");
    }

    private static void isWinPositionForVerticalsTestNoWinPlayer2() {
        totalRun++;
        int[][] inputArray = {{0, 1, -1},
                {-1, 1, -1},
                {0, 0, -1}};
        checkResult(false, ticTacToe.isWinPositionForVerticals(inputArray, 1), "isWinPositionForVerticalsTestNoWinPlayer2");
    }

    private static void isWinPositionForDiagonalsTestDiagonal1Player1() {
        totalRun++;
        int[][] inputArray = {{0, 1, -1},
                {1, 0, -1},
                {-1, -1, 0}};
        checkResult(true, ticTacToe.isWinPositionForDiagonals(inputArray, 0), "isWinPositionForDiagonalsTestDiagonal1Player1");
    }

    private static void isWinPositionForDiagonalsTestDiagonal2Player1() {
        totalRun++;
        int[][] inputArray = {{1, -1, 0},
                {1, 0, -1},
                {0, -1, -1}};
        checkResult(true, ticTacToe.isWinPositionForDiagonals(inputArray, 0), "isWinPositionForDiagonalsTestDiagonal2Player1");
    }

    private static void isWinPositionForDiagonalsTestNoWinPlayer1() {
        totalRun++;
        int[][] inputArray = {{1, 1, -1},
                {-1, 0, -1},
                {0, 0, -1}};
        checkResult(false, ticTacToe.isWinPositionForDiagonals(inputArray, 0), "isWinPositionForDiagonalsTestNoWinPlayer1");
    }

    private static void isWinPositionForDiagonalsTestDiagonal1Player2() {
        totalRun++;
        int[][] inputArray = {{1, -1, 0},
                {0, 1, -1},
                {0, 0, 1}};
        checkResult(true, ticTacToe.isWinPositionForDiagonals(inputArray, 1), "isWinPositionForDiagonalsTestDiagonal1Player2");
    }

    private static void isWinPositionForDiagonalsTestDiagonal2Player2() {
        totalRun++;
        int[][] inputArray = {{0, -1, 1},
                {0, 1, 0},
                {1, -1, 0}};
        checkResult(true, ticTacToe.isWinPositionForDiagonals(inputArray, 1), "isWinPositionForDiagonalsTestDiagonal2Player2");
    }

    private static void isWinPositionForDiagonalsTestNoWinPlayer2() {
        totalRun++;
        int[][] inputArray = {{0, -1, 1},
                {-1, 1, -1},
                {0, 0, -1}};
        checkResult(false, ticTacToe.isWinPositionForDiagonals(inputArray, 1), "isWinPositionForDiagonalsTestNoWinPlayer2");
    }

    private static void isWinPositionTestHorizontalPlayer1() {
        totalRun++;
        int[][] inputArray = {{0, 0, 0},
                {1, 1, -1},
                {-1, -1, -1}};
        checkResult(true, ticTacToe.isWinPosition(inputArray, 0), "isWinPositionTestHorizontalPlayer1");
    }

    private static void isWinPositionTestVerticalPlayer1() {
        totalRun++;
        int[][] inputArray = {{1, 0, -1},
                {1, 0, -1},
                {-1, 0, -1}};
        checkResult(true, ticTacToe.isWinPosition(inputArray, 0), "isWinPositionTestVerticalPlayer1");
    }

    private static void isWinPositionTestDiagonalPlayer1() {
        totalRun++;
        int[][] inputArray = {{0, -1, -1},
                {-1, 0, -1},
                {1, 1, 0}};
        checkResult(true, ticTacToe.isWinPosition(inputArray, 0), "isWinPositionTestDiagonalPlayer1");
    }

    private static void isWinPositionTestNoWinPlayer1() {
        totalRun++;
        int[][] inputArray = {{1, 1, -1},
                {-1, 0, -1},
                {0, 0, -1}};
        checkResult(false, ticTacToe.isWinPosition(inputArray, 0), "isWinPositionTestNoWinPlayer1");
    }

    private static void isWinPositionTestHorizontalPlayer2() {
        totalRun++;
        int[][] inputArray = {{1, 1, 1},
                {0, 0, -1},
                {-1, 0, 0}};
        checkResult(true, ticTacToe.isWinPosition(inputArray, 1), "isWinPositionTestHorizontalPlayer2");
    }

    private static void isWinPositionTestVerticalPlayer2() {
        totalRun++;
        int[][] inputArray = {{0, 1, -1},
                {0, 1, 0},
                {-1, 1, 0}};
        checkResult(true, ticTacToe.isWinPosition(inputArray, 1), "isWinPositionTestVerticalPlayer2");
    }

    private static void isWinPositionTestDiagonalPlayer2() {
        totalRun++;
        int[][] inputArray = {{0, 0, 1},
                {-1, 1, 0},
                {1, 0, -1}};
        checkResult(true, ticTacToe.isWinPosition(inputArray, 1), "isWinPositionTestDiagonalPlayer2");
    }

    private static void isWinPositionTestNoWinPlayer2() {
        totalRun++;
        int[][] inputArray = {{1, 1, -1},
                {-1, 0, -1},
                {0, 0, -1}};
        checkResult(false, ticTacToe.isWinPosition(inputArray, 1), "isWinPositionTestNoWinPlayer2");
    }

    private static void isDrawPositionTestWinPlayer1NoDraw() {
        totalRun++;
        int[][] inputArray = {{0, 1, 1},
                {1, 0, -1},
                {-1, 0, 0}};
        checkResult(false, ticTacToe.isDrawPosition(inputArray), "isDrawPositionTestWinPlayer1NoDraw");
    }

    private static void isDrawPositionTestWinPlayer2NoDraw() {
        totalRun++;
        int[][] inputArray = {{0, 1, -1},
                {0, 1, 0},
                {-1, 1, 0}};
        checkResult(false, ticTacToe.isDrawPosition(inputArray), "isDrawPositionTestWinPlayer2NoDraw");
    }

    private static void isDrawPositionTestEmptyCellsNoDraw() {
        totalRun++;
        int[][] inputArray = {{0, 0, 1},
                {1, 1, 0},
                {0, 1, -1}};
        checkResult(false, ticTacToe.isDrawPosition(inputArray), "isDrawPositionTestEmptyCellsNoDraw");
    }

    private static void isDrawPositionTestDrawScenario() {
        totalRun++;
        int[][] inputArray = {{1, 0, 1},
                {1, 0, 0},
                {0, 1, 0}};
        checkResult(true, ticTacToe.isDrawPosition(inputArray), "isDrawPositionTestDrawScenario");
    }

    private static void createFieldTestSucceed() {
        totalRun++;
        int[][] expectedResult = {{-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1}};
        checkResult(expectedResult, ticTacToe.createField(), "createFieldTestSucceed");
    }

    private static void checkResult(Boolean expectedResult, Boolean actualResult, String testName) {
        if (expectedResult == actualResult) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual:   " + actualResult + TEXT_RESET);
            totalFailed++;
        }
    }

    private static void checkResult(int[][] expectedResult, int[][] actualResult, String testName) {
        if (twoDimArraysAreEqual(expectedResult, actualResult)) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected:");
            printTwoDimArray(expectedResult);
            System.out.println("Actual:");
            printTwoDimArray(actualResult);
            System.out.println(TEXT_RESET);
            totalFailed++;
        }
    }

    private static void printFooter() {
        System.out.println("********************************************");
        if (totalFailed > 0) {
            System.out.println(TEXT_RED + "TOTAL: RUN = " + totalRun + "; PASSED = " + totalPassed +
                    "; FAILED = " + totalFailed + TEXT_RESET);
        } else {
            System.out.println(TEXT_GREEN + "TOTAL: RUN = " + totalRun + "; PASSED = " + totalPassed +
                    "; FAILED = " + totalFailed + TEXT_RESET);
        }
        System.out.println("********************************************");
    }

    private static boolean twoDimArraysAreEqual(int[][] array1, int[][] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        if (array1[0].length != array2[0].length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != array2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printTwoDimArray(int[][] array) {
        if (array.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print(" " + array[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
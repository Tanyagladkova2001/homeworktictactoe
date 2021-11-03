package com.company;

import java.util.Scanner;

public class homewor4tictactoe {
    public class taskDimensionalArray6 {
        public static final String empty = "   ", cross = " X ", zero = " O ";
        public static String actingPlayer;
        public static final int rows = 3, columns = 3;
        public static String grid[][] = new String[rows][columns];
        public static int statusOfTheGame;
        public static final int status_of_the_game_is_continue = 0, staus_of_the_game_is_draw = 1,
                staus_of_the_game_winner_is_X = 3, staus_of_the_game_winner_is_O = 4;
        public static Scanner in = new Scanner(System.in);


        public static void main(String[] args) {
            startOfTheGame();
            do {
                getPlayerInput();
                analizeGrid();
                enterGrid();
                if (statusOfTheGame == staus_of_the_game_winner_is_X) {
                    System.out.println("'X' is winner! Congratulations!");
                } else if (statusOfTheGame == staus_of_the_game_winner_is_O) {
                    System.out.println("'O' is winner! Congratulations!");
                } else if (statusOfTheGame == staus_of_the_game_is_draw) {
                    System.out.println("The game is ended with a draw! Try it again!");
                }
                actingPlayer = (actingPlayer.equals(cross) ? zero : cross);
            }
            while (statusOfTheGame == status_of_the_game_is_continue);

        }

        public static void startOfTheGame() {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    grid[row][column] = empty;
                }
            }
            actingPlayer = cross;
            enterGrid();
        }

        public static void getPlayerInput() {
            boolean enteringIsValid = false;
            do {
                System.out.println("The player ' " + actingPlayer + "enter row (1-3) and column (1-3) :through the space" +
                        "enter two numbers ");
                int row = in.nextInt() - 1;
                int column = in.nextInt() - 1;
                if (row >= 0 && row < rows && column >= 0 && column < columns && grid[row][column].equals(empty)) {
                    grid[row][column] = actingPlayer;
                    enteringIsValid = true;
                } else {
                    System.out.println("This space (" + (row + 1) + "," + (column + 1)
                            + ") can't be done. Try it again...");
                }
            } while (!enteringIsValid);
        }

        public static void analizeGrid() {
            String winner = findWinner();
            if (winner.equals(cross)) {
                statusOfTheGame = staus_of_the_game_winner_is_X;
            } else if (winner.equals(zero)) {
                statusOfTheGame = staus_of_the_game_winner_is_O;
            } else if (wheterAllCellsAreFilled()) {
                statusOfTheGame = staus_of_the_game_is_draw;
            } else {
                statusOfTheGame = status_of_the_game_is_continue;
            }
        }

        public static boolean wheterAllCellsAreFilled() {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if (grid[row][column].equals(empty)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static String findWinner() {
            int iNumberOfSimilar = 0;
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if (!grid[row][0].equals(empty) && grid[row][0].equals(grid[row][column])) {
                        iNumberOfSimilar++;
                    }
                }
                if (iNumberOfSimilar == 3) {
                    return grid[row][0];

                }
            }
            for (int column = 0; column < rows; column++) {
                iNumberOfSimilar = 0;
                for (int ryad = 0; ryad < rows; ryad++) {
                    if (!grid[0][column].equals(empty) && grid[0][column].equals(grid[ryad][column])) {
                        iNumberOfSimilar++;
                    }
                }
                if (iNumberOfSimilar == 3) {
                    return grid[0][column];
                }
            }
            if (!grid[0][0].equals(empty) && grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2])) {
                return grid[0][0];
            }

            if (!grid[0][2].equals(empty) && grid[1][1].equals(grid[0][2]) && grid[2][0].equals(grid[0][2])) {
                return grid[0][2];
            }

            return empty;
        }

        public static void enterGrid() {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    System.out.print(grid[row][column]);
                    if (column != columns - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (row != rows - 1) {
                    System.out.println("-----------");
                }
            }
            System.out.println();
        }

    }
}

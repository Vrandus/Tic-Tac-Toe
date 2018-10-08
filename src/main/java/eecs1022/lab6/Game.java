package eecs1022.lab6;

/**
 * Created by user on 8/16/18.
 */
public class Game {
    public Game(String player1, String player2, String startPlayer){
        p1x = player1;
        p2o = player2;
        currentPlayer = startPlayer;
    }
    String output;
    String p1x;
    String p2o;
    String currentPlayer;
    char[][] board = {
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'},
    };
    public void initGame(){
        output = "Game Started \n" + printBoard() + " \n" + currentPlayer + "'s turn";
    }
    public void turn(int row, int col) {
        if (isBoardFull() == false && checkForWin() == false){
            if (currentPlayer.equals("Player X")) {
                if(board[col-1][row-1] == '.') {
                    board[col-1][row-1] = 'x';
                    currentPlayer = "Player O";
                    output = "Current Game Status \n" + printBoard() +"\n Next " + currentPlayer;

                }
                else if(board[col-1][row-1] != '.') {
                    output += " \nError: slot @ (" +row + ", " +col +") already occupied.";
                }

            }
            if (currentPlayer.equals("Player O")) {
                if(board[col-1][row-1] == '.') {
                    board[col-1][row-1] = 'o';
                    currentPlayer = "Player X";
                    output = "Current Game Status \n" + printBoard() +"\n Next " + currentPlayer;

                }
                else if(board[col-1][row-1] != '.') {
                    output += "\nError: slot @ (" +row + ", " +col +") already occupied.";
                }
            }
        }
        else if (isBoardFull() == true || checkForWin() == true ) {
            output = "Current Game Status \n" + printBoard() +"\n Error: game is already over.";
        }
        if (checkForWin() == true) {
            if(currentPlayer.equals("Player O")) {
                output += "\nthe Game ends with " + p1x + " winning";
            }
            else if(currentPlayer.equals("Player X")) {
                output += "\nthe Game ends with " + p2o + " winning";
            }
        }
    }
    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }


    public boolean checkForWin() {

        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());

    }
    public String printBoard() {
        String outputBoard = "";
        for (int i = 0; i < 3; i++) {
            outputBoard += "           ";
            for (int j = 0; j < 3; j++) {
                outputBoard += board[i][j] + " ";
            }
            outputBoard += "\n";
        }
        return outputBoard;
    }




    // Loop through rows and see if any are winners.

    private boolean checkRowsForWin() {

        for (int i = 0; i < 3; i++) {

            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {

                return true;

            }

        }

        return false;

    }





    // Loop through columns and see if any are winners.

    private boolean checkColumnsForWin() {

        for (int i = 0; i < 3; i++) {

            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {

                return true;

            }

        }

        return false;

    }





    // Check the two diagonals to see if either is a win. Return true if either wins.

    private boolean checkDiagonalsForWin() {

        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));

    }





    // Check to see if all three values are the same (and not empty) indicating a win.

    private boolean checkRowCol(char c1, char c2, char c3) {

        return ((c1 != '.') && (c1 == c2) && (c2 == c3));

    }




    public String toString() {

        return output;

    }
}


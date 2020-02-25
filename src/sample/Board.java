package sample;

public class Board implements ObservableObserver, ObservableSubject{

    // 0: space; 1: "X"; -1: "O"

    public int[][] board = new int[3][3];

    public Board() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = 0;
            }
        }
    }
    public Board(Board board){
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                this.board[r][c] = board[r][c];
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public int getWinner(){
        int winner = 0;
        if (board[0][0] == board[0][1] && board[0][0] == board[0][2])
            winner = board[0][0];
        else if (board[1][0] == board[1][1] && board[1][0] == board[1][2])
            winner = board[1][0];
        else if (board[2][0] == board[2][1] && board[2][0] == board[2][2])
            winner = board[2][0];
        else if (board[0][0] == board[1][0] && board[0][0] == board[2][0])
            winner = board[0][0];
        else if (board[0][1] == board[1][1] && board[0][1] == board[2][1])
            winner = board[0][1];
        else if (board[0][2] == board[1][2] && board[0][2] == board[2][2])
            winner = board[0][2];
        else if (board[0][0] == board[1][1] && board[0][0] == board[2][2])
            winner = board[0][0];
        else if (board[2][0] == board[1][1] && board[2][0] == board[0][2])
            winner = board[2][0];

        return winner;
    }

    public boolean gameOver() {
        boolean over = true;
        if(getWinner() == 0)
            over = false;
        else{
            for(int r = 0; r < board.length; r++){
                for(int c = 0; c < board[c].length; c++){
                    if(board[r][c] == 0 || board[r][c] == 0);
                }
            }
            over = false;
        }
        return over;
    }

    public void MoveMarked(int x, int y, String player) {
        board[x][y] = changeStringtoInt(player);
    }

    public int changeStringtoInt(String player){
        if (player.compareTo("X") == 0){
            return 1;
        }
        else{
            return -1;
        }
    }
    public String changeInttoString(int player){
        if (player == 1){
            return "X";
        }
        else{
            return "O";
        }
    }

    public boolean isFree(int positionX, int positionY){
        if(board[positionX][positionY] == 'X') {
            System.out.println("TRUE");
            return true;
        }
        else{
            System.out.println("FALSE");
            return false;
            }
    }

    public void seeBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
               System.out.print("Board: " + board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    @Override
    public void update(int x, int y) {

    }

    @Override
    public void addObserver(ObservableObserver o) {

    }
    @Override
    public void removeObserver(ObservableObserver o) {

    }
    @Override
    public void notifyObserver(int x, int y) {

    }
}
package sample;
import java.util.Observable;


public class Human extends PlayerBehavior {

        TicTacToeBoard board;
        char otherPlayer;

    public Human(char symbol, TicTacToeBoard board) {

        super(symbol, board);
        if (this.symbol == 'X') {
            this.otherPlayer = 'O';

        } else
            this.otherPlayer = 'X';
    }

    @Override
    public void move() {

    }


}

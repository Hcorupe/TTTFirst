package sample;
import java.util.Observable;


public class User extends Player {

        Board board;
        String otherPlayer;

    public User(String symbol, Board board) {

        super(symbol, board);
        if (this.symbol == "X") {
            this.otherPlayer = "O";

        } else
            this.otherPlayer = "X";
    }

    @Override
    public void move() {

    }
}

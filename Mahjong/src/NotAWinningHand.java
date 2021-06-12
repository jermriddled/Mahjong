import java.util.ArrayList;

public class NotAWinningHand {

    ArrayList<Tile> hand = new ArrayList<>();

    public NotAWinningHand() {
        hand.add(new Tile(1, "Man"));
        hand.add(new Tile(2, "Man"));
        hand.add(new Tile(3, "Man"));
        hand.add(new Tile(5, "Man"));
        hand.add(new Tile(6, "Man"));
        hand.add(new Tile(7, "Man"));
        hand.add(new Tile(1, "Pin"));
        hand.add(new Tile(1, "Pin"));
        hand.add(new Tile(1, "Pin"));
        hand.add(new Tile(1, "Sou"));
        hand.add(new Tile(2, "Sou"));
        hand.add(new Tile(3, "Sou"));
        hand.add(new Tile(3, "Sou"));
        hand.add(new Tile(5, "Sou"));
    }

    public ArrayList<Tile> getHand() {
        return hand;
    }
}

import java.util.ArrayList;

public class WinningHand {

    ArrayList<Tile> hand = new ArrayList<>();

    public WinningHand() {
        hand.add(new Tile(1, "Man"));
        hand.add(new Tile(1, "Man"));
        hand.add(new Tile(2, "Man"));
        hand.add(new Tile(3, "Man"));
        hand.add(new Tile(4, "Man"));
        hand.add(new Tile(5, "Man"));
        hand.add(new Tile(6, "Man"));
        hand.add(new Tile(7, "Man"));
        hand.add(new Tile(1, "Sou"));
        hand.add(new Tile(1, "Sou"));
        hand.add(new Tile(1, "Sou"));
        hand.add(new Tile(4, "Pin"));
        hand.add(new Tile(5, "Pin"));
        hand.add(new Tile(6, "Pin"));
    }

    public ArrayList<Tile> getHand() {
        return hand;
    }
}

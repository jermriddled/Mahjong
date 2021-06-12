import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class HandUtils {

    private static final int TILE_TYPES = 34;
    private static ArrayList<Tile> masterTileSet = new ArrayList<>();
    private static ArrayList<Tile> thisTileSet = new ArrayList<>();
    private static ArrayList<Tile> hand;
    private static ArrayList<Tile> handTester;
    private static int draws;
    private static int[] checkMelds = new int[TILE_TYPES];
    private static int tenhous = 0;

    public static void main(String[] args) {
        buildTileSet();
        runTests(Integer.parseInt(args[0]));
    }

    // Populate the tile set - 4 each of: 1-9 Man, 1-9 Pin, 1-9 Sou, Green, Red, and White Dragons,
    // East, North, South, and West winds
    private static void buildTileSet() {
        for (int i=0; i<4; i++) {
            masterTileSet.add(new Tile(0, "Green"));
            masterTileSet.add(new Tile(0, "Red"));
            masterTileSet.add(new Tile(0, "White"));
            masterTileSet.add(new Tile(0, "East"));
            masterTileSet.add(new Tile(0, "North"));
            masterTileSet.add(new Tile(0, "South"));
            masterTileSet.add(new Tile(0, "West"));
            for (int j=9; j>0; j--) {
                Tile thisMan = new Tile(j, "Man");
                Tile thisPin = new Tile(j, "Pin");
                Tile thisSou = new Tile(j, "Sou");
                masterTileSet.add(thisMan);
                masterTileSet.add(thisPin);
                masterTileSet.add(thisSou);
            }
        }
    }

    private static void drawHand() {
        for (int i=0; i<14; i++) {
            Random rand = new Random();
            int randomInt = rand.nextInt(136);
            Tile tile = masterTileSet.get(randomInt);
            String suit = tile.getSuit();
            int val = tile.getVal();
            checkMelds[translateSuit(suit) + val - 1]++;
            hand.add(tile);
        }
    }

    private static int translateSuit(String suit) {
        if (suit.equals("Man")) return 0;
        if (suit.equals("Pin")) return 9;
        if (suit.equals("Sou")) return 18;
        if (suit.equals("Green")) return 28;
        if (suit.equals("Red")) return 29;
        if (suit.equals("White")) return 30;
        if (suit.equals("East")) return 31;
        if (suit.equals("North")) return 32;
        if (suit.equals("South")) return 33;
        if (suit.equals("West")) return 34;
        return 0;
    }

    private boolean isPair(Tile t1, Tile t2) {
        if (t1.getSuit().equals(t2.getSuit())) {
            return t1.getVal() == t2.getVal();
        }
        return false;
    }

    private static boolean isMahjong(int pairs, int melds, int kans) {
        if (pairs != 1 && pairs != 7) return false;
        else if (kans != 3 && pairs != 1) return false;
        else return melds == 4;
    }

    private static boolean suitsMatch (Tile t1, Tile t2) {
        return (t1.getSuit().equals(t2.getSuit()));
    }

    private static boolean isSequence (Tile t1, Tile t2, Tile t3) {
        if (!suitsMatch(t1, t2) || !suitsMatch(t2, t3)) return false;
        int t1Val = t1.getVal();
        int t2Val = t2.getVal();
        int t3Val = t3.getVal();
        return ((t2Val == t1Val + 1) && (t3Val == t2Val +1));
    }

    // Checks if the hand has failed the winning conditions
    private static boolean disqualified (int pair, int melds, int kans) {
        if (pair == 0 && melds == 0 && kans == 0) return true;
        else if (pair > 1 && (melds > 0 || kans > 0)) return true;
        return false;
    }

    // Check if hand is a winner
    public static boolean evaluateHand(ArrayList<Tile> hand) {
        int pair = 0;
        int melds = 0;
        int kans = 0;
        for (int i=0; i<hand.size(); i++) {
            if (i >0) {
                if (disqualified(pair, melds, kans)) return false;
            }
            Tile tile1 = hand.get(i);
            int tileFrequency = Collections.frequency(hand, tile1);
            if (tileFrequency > 1) {
                switch (tileFrequency) {
                    case 2 -> {
                        pair++;
                        hand.set(i, new Tile(0, "null"));
                        hand.set(i+1, new Tile(0, "null"));
                        i = i + 1;
                        continue;
                    }
                    case 3 -> {
                        melds++;
                        hand.set(i, new Tile(0, "null"));
                        hand.set(i+1, new Tile(0, "null"));
                        hand.set(i+2, new Tile(0, "null"));
                        i = i + 2;
                        continue;
                    }
                    case 4 -> {
                        kans++;
                        hand.set(i, new Tile(0, "null"));
                        hand.set(i+1, new Tile(0, "null"));
                        hand.set(i+2, new Tile(0, "null"));
                        hand.set(i+3, new Tile(0, "null"));
                        i = i + 3;
                        continue;
                    }
                }
            }
            if (i < hand.size() - 2) {
                Tile tile2 = hand.get(i+1);
                Tile tile3 = hand.get(i+2);
                if (isSequence(tile1, tile2, tile3)) {
                    melds++;
                    hand.set(i, new Tile(0, "null"));
                    hand.set(i+1, new Tile(0, "null"));
                    hand.set(i+2, new Tile(0, "null"));
                    i = i + 2;
                }
            }
        }

        return isMahjong(pair, melds, kans);

    }

    private static void runTests(int noOfTests) {

        for (int i=0; i<noOfTests; i++) {
            draws++;
            hand = new ArrayList<>();
            drawHand();
            Collections.sort(hand);
            handTester = new ArrayList<>(hand);
            if (evaluateHand(hand)) {
                System.out.print("[");
                System.out.print(handTester.stream().map(Tile::getValAndSuit)
                        .collect(Collectors.joining(", ")));
                System.out.print("]");
                System.out.println();
                tenhous++;
            }
        }
        System.out.println("Draws: " + draws);
        System.out.println("Tenhous: " + tenhous);
        System.out.println ("Percentage: " + (BigDecimal.valueOf(tenhous * 100).divide
                (BigDecimal.valueOf(draws))) + "%");
    }
}

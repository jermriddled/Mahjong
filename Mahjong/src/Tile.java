import java.util.Comparator;
import java.util.Objects;

public class Tile implements Comparable<Tile> {
    private final int VAL;
    private final String SUIT;
//    private final Tile NEXT;

    public Tile(int val, String suit) {
        this.VAL = val;
        this.SUIT = suit;
//        this.NEXT = next;
//        if (this.SUIT.equals("Man") || this.SUIT.equals("Pin") || this.SUIT.equals("Sou")) {
//            if (VAL != 9) NEXT
//        }
    }

    public int getVal() { return VAL; }

    public String getSuit() { return SUIT; }

    public String getValAndSuit() { return Integer.toString(VAL) + " " + SUIT; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return VAL == tile.VAL &&
                Objects.equals(SUIT, tile.SUIT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VAL, SUIT);
    }

    @Override
    public int compareTo(Tile o) {
        String t1Suit = this.getSuit();
        String t2Suit = o.getSuit();

        boolean t1IsWind = false;
        boolean t2IsWind = false;
        boolean t1IsDragon = false;
        boolean t2IsDragon = false;
        if (t1Suit.equals("East") || t1Suit.equals("North") || t1Suit.equals("South")
                || t1Suit.equals("West")) t1IsWind = true;
        if (t2Suit.equals("East") || t2Suit.equals("North") || t2Suit.equals("South")
                || t2Suit.equals("West")) t2IsWind = true;
        if (t1Suit.equals("Green") || t1Suit.equals("Red") || t1Suit.equals("White"))
            t1IsDragon = true;
        if (t2Suit.equals("Green") || t2Suit.equals("Red") || t2Suit.equals("White"))
            t2IsDragon = true;


        if (t1Suit.equals(t2Suit)) return this.getVal() - o.getVal();
        if (t1IsWind && t2IsWind) {
            if (t1Suit.equals("West")) return 1;
            else if (t1Suit.equals("South") && !t2Suit.equals("West")) return 1;
            else if (t1Suit.equals("North") && !t2Suit.equals("South")
                    && !t2Suit.equals("West")) return 1;
        }
        else if (!t1IsWind & !t2IsWind) {
            if (t1IsDragon && t2IsDragon) {
                if (t1Suit.equals("White")) return 1;
                else if (t1Suit.equals("Red") && !t2Suit.equals("White")) return 1;
            }
            else if (!t1IsDragon && !t2IsDragon) {
                if (t1Suit.equals("Sou")) return 1;
                else if (t1Suit.equals("Pin") && t2Suit.equals("Man")) return 1;
            }
            else if (t1IsDragon) return 1;
        }
        else if (t1IsWind) return 1;

        return -1;
    }
//    private static final int ONE_MAN = 1;
//    private static final int TWO_MAN = 2;
//    private static final int THREE_MAN = 3;
//    private static final int FOUR_MAN = 4;
//    private static final int FIVE_MAN = 5;
//    private static final int SIX_MAN = 6;
//    private static final int SEVEN_MAN = 7;
//    private static final int EIGHT_MAN = 8;
//    private static final int NINE_MAN = 9;
//    private static final int ONE_PIN = 10;
//    private static final int TWO_PIN = 11;
//    private static final int THREE_PIN = 12;
//    private static final int FOUR_PIN = 13;
//    private static final int FIVE_PIN = 14;
//    private static final int SIX_PIN = 15;
//    private static final int SEVEN_PIN = 16;
//    private static final int EIGHT_PIN = 17;
//    private static final int NINE_PIN = 18;
//    private static final int ONE_SOU = 19;
//    private static final int TWO_SOU = 20;
//    private static final int THREE_SOU = 21;
//    private static final int FOUR_SOU = 22;
//    private static final int FIVE_SOU = 23;
//    private static final int SIX_SOU = 24;
//    private static final int SEVEN_SOU = 25;
//    private static final int EIGHT_SOU = 26;
//    private static final int NINE_SOU = 27;
//    private static final int GREEN_DRAGON = 28;
//    private static final int RED_DRAGON = 29;
//    private static final int WHITE_DRAGON = 30;
//    private static final int EAST = 31;
//    private static final int SOUTH = 32;
//    private static final int WEST = 33;
//    private static final int NORTH = 34;
}


//import java.util.Comparator;
//
//public class Tile implements Comparator<Tile> {
//    private final int VAL;
//    private final String SUIT;
//
//    public Tile(int val, String suit) {
//        this.VAL = val;
//        this.SUIT = suit;
//    }
//
//    public int getVal() {
//        return VAL;
//    }
//
//    public String getSuit() {
//        return SUIT;
//    }
//
//    @Override
//    public int compare(Tile t1, Tile t2) {
//        String t1Suit = t1.getSuit();
//        String t2Suit = t2.getSuit();
//
//        boolean t1IsWind = false;
//        boolean t2IsWind = false;
//        boolean t1IsDragon = false;
//        boolean t2IsDragon = false;
//        if (t1Suit.equals("East") || t1Suit.equals("North") || t1Suit.equals("South")
//                || t1Suit.equals("West")) t1IsWind = true;
//        if (t2Suit.equals("East") || t2Suit.equals("North") || t2Suit.equals("South")
//                || t2Suit.equals("West")) t2IsWind = true;
//        if (t1Suit.equals("Green") || t1Suit.equals("Red") || t1Suit.equals("White"))
//            t1IsDragon = true;
//        if (t2Suit.equals("Green") || t2Suit.equals("Red") || t2Suit.equals("White"))
//            t2IsDragon = true;
//
//
//        if (t1Suit.equals(t2Suit)) return t1.getVal() - t2.getVal();
//
//        else if (t1IsWind && !t2IsWind) return 1;
//        else if (t1Suit.equals("West")) return 1;
//        else if (t1Suit.equals("South") && !t2Suit.equals("West")) return 1;
//        else if (t1Suit.equals("North") && !t2Suit.equals("South")
//                && !t2Suit.equals("West")) return 1;
//
//        else if (t1IsDragon && !t2IsWind) return 1;
////        else if (t1IsDragon && !t2IsDragon) return 1;
//        else if (t1Suit.equals("White")) return 1;
//        else if (t1Suit.equals("Red") && !t2Suit.equals("White")) return 1;
//        else if (t1Suit.equals("Green")) return 1;
//
//
//        else if (t1Suit.equals("Sou")) return 1;
////        if (t1Suit.equals("Man")) return -1;
//        else if (t1Suit.equals("Pin") && t2Suit.equals("Man")) return 1;
////        else if (t1Suit.equals("Pin") && t2Suit.equals("Sou")) return -1;
//
//        else return -1;
//
//    }
////    private static final int ONE_MAN = 1;
////    private static final int TWO_MAN = 2;
////    private static final int THREE_MAN = 3;
////    private static final int FOUR_MAN = 4;
////    private static final int FIVE_MAN = 5;
////    private static final int SIX_MAN = 6;
////    private static final int SEVEN_MAN = 7;
////    private static final int EIGHT_MAN = 8;
////    private static final int NINE_MAN = 9;
////    private static final int ONE_PIN = 10;
////    private static final int TWO_PIN = 11;
////    private static final int THREE_PIN = 12;
////    private static final int FOUR_PIN = 13;
////    private static final int FIVE_PIN = 14;
////    private static final int SIX_PIN = 15;
////    private static final int SEVEN_PIN = 16;
////    private static final int EIGHT_PIN = 17;
////    private static final int NINE_PIN = 18;
////    private static final int ONE_SOU = 19;
////    private static final int TWO_SOU = 20;
////    private static final int THREE_SOU = 21;
////    private static final int FOUR_SOU = 22;
////    private static final int FIVE_SOU = 23;
////    private static final int SIX_SOU = 24;
////    private static final int SEVEN_SOU = 25;
////    private static final int EIGHT_SOU = 26;
////    private static final int NINE_SOU = 27;
////    private static final int GREEN_DRAGON = 28;
////    private static final int RED_DRAGON = 29;
////    private static final int WHITE_DRAGON = 30;
////    private static final int EAST = 31;
////    private static final int SOUTH = 32;
////    private static final int WEST = 33;
////    private static final int NORTH = 34;
//}

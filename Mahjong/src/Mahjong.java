import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Mahjong {

    public static void main (String[] args) {

        // Populate the tile set - 4 each of: 1-9 Man, 1-9 Pin, 1-9 Sou, Green, Red, and White Dragons,
        // East, North, South, and West winds

//        Collections.shuffle(masterTileSet);
//        thisTileSet = masterTileSet;
//        for (Tile tile : masterTileSet) System.out.println(tile.getVal() + " " + tile.getSuit());



        // ********RUN PROGRAM**********************************************


        HandUtils.main(getUserInput());

        //*********RUN PROGRAM**************************************



//        WinningHand winningHand = new WinningHand();

        // ********** BUG TEST ****************

//        BuggedHand bug = new BuggedHand();
//        for (Tile tile : bug.getHand()) System.out.println(tile.getVal() + " " + tile.getSuit());
//        System.out.println(evaluateHand(bug.getHand()));

        // ********** BUG TEST ****************


//        for (Tile tile : hand) System.out.println(tile.getVal() + " " + tile.getSuit());
//        for (Tile tile : winningHand.getHand()) System.out.println(tile.getVal() + " " + tile.getSuit());
//        System.out.println(Arrays.toString(checkMelds));
//        System.out.println(evaluateHand(winningHand.getHand()));
    }

    private static String[] getUserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an integer: ");

        return new String[]{Integer.toString(scan.nextInt())};
    }

}



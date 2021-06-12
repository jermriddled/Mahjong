import java.util.ArrayList;

public class Test {

    public static void main (String[] args) {
//        Tile t1 = new Tile (1, "Man");
//        Tile t2 = new Tile (1, "Man");
//        System.out.println(t1.equals(t2));
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        System.out.println(l.get(2));
        l.remove(2);
        System.out.println(l.get(2));
        l.remove(9);
    }
}

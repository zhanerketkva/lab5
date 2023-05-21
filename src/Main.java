import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST();

        for (int i = 0; i < 12; i++) {
            bst.put(i, "Value " + i);
        }
        Iterable it = bst.iterator();
        for(Object el: it) {
            System.out.println(el);
        }
    }
}
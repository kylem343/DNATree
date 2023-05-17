/**
 * Class for handling The tree classes
 * 
 * @author kylem
 * @version 2/26/2023
 */
public class BSTree {

    /**
     * FlyWeight Node to be used as the placeholder for all empty nodes
     */
    public static final FlyNode FLYWEIGHT = FlyNode.getFly();

    /**
     * Root of the tree
     */
    private Node root;

    /**
     * Empty Tree Constructor
     */
    public BSTree() {
        root = BSTree.FLYWEIGHT;
    }


    /**
     * Inserts a sequence into the tree
     * 
     * @param seq
     *            to be inserted
     */
    public void insert(String seq) {
        if (seq != null) {
            root = root.insert(seq, 0);
        }
    }


    /**
     * Removes a sequence from the tree
     * 
     * @param seq
     *            to be removed
     */
    public void remove(String seq) {
        if (seq != null) {
            root = root.remove(seq);
        }
    }


    /**
     * Prints the tree
     */
    public void print() {
        System.out.println("tree dump:");
        root.print(0);
    }


    /**
     * Prints the tree with lengths following the sequences
     */
    public void printLength() {
        System.out.println("tree dump:");
        root.printLength(0);
    }


    /**
     * Prints the tree with stats following the sequences
     */
    public void printStats() {
        System.out.println("tree dump:");
        root.printStats(0);
    }


    /**
     * Searches for a sequence in the tree
     * 
     * @param seq
     *            to be found, if ends in "$" it must be an exact match
     */
    public void search(String seq) {
        // My stats[] will contain # nodes visited in the first index and found
        // strings will be in the following spaces
        String[] stats = { "0" };
        stats = root.search(seq, stats);

        System.out.println("# of nodes visited: " + stats[0]);

        // if length = 1 no sequences were found
        if (stats.length == 1) {
            System.out.println("no sequence found");
        }
        else {
            // prints out the sequences found
            for (int i = 1; i < stats.length; i++) {
                System.out.println("sequence: " + stats[i]);
            }
        }
    }

}

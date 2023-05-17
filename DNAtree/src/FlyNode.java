/**
 * Class that represents the FlyWeight node in the binary tree
 * 
 * @author kylem
 * @version 2/8/2023
 */
public class FlyNode implements Node {

    /**
     * Single FlyNode to be Used
     */
    private static FlyNode fly = new FlyNode();

    /**
     * Flynode Constructor
     */
    public FlyNode() {
    }


    /**
     * Gets the FlyNode to be used
     * 
     * @return fly node to be used as the FlyWeight
     */
    public static FlyNode getFly() {
        return fly;
    }


    /**
     * Inserts a sequence into the flyNode
     * 
     * @param seq
     *            to be inserted
     * @param lvl
     *            level of the sequence
     * @return new LeafNode with inserted value
     */
    public Node insert(String seq, int lvl) {
        LeafNode leaf = new LeafNode(seq);
        System.out.println("sequence " + seq + " inserted at level " + lvl);

        return leaf;
    }


    /**
     * Removes a sequence from the Node
     * 
     * @param seq
     *            to be removed
     * @return FlyWeight since nothing is stored in this node
     */
    public Node remove(String seq) {
        System.out.println("sequence " + seq + " does not exist");
        return this;
    }


    /**
     * Searches for a specified sequence
     * 
     * @param seq
     *            to be searched for
     * @param arr
     *            of values to keep track of sequences
     * @return updated array by count
     */
    public String[] search(String seq, String[] arr) {

        // Adds one to the nodes visited
        int count = Integer.parseInt(arr[0]);
        count++;
        arr[0] = Integer.toString(count);

        return arr;
    }


    /**
     * Prints the Node
     * 
     * @param level
     *            to keep track of indentations
     */
    public void print(int level) {
        String line = "";
        for (int i = 0; i < level; i++) {
            line += "  ";
        }
        line += "E";

        System.out.println(line);
    }


    /**
     * Prints the Node with lengths beside the sequences
     * 
     * @param level
     *            to keep track of indentations
     */
    public void printLength(int level) {
        this.print(level);
    }


    /**
     * Prints the Node with stats beside the sequences
     * 
     * @param level
     *            to keep track of indentations
     */
    public void printStats(int level) {
        this.print(level);
    }

}

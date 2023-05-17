import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Class that represents the leaf nodes to the binary tree
 * 
 * @author kylem
 * @version 2/8/2023
 */
public class LeafNode implements Node {

    /**
     * Sequence stored in the Node
     */
    private String data;

    /**
     * Constructor class for leaf node
     * 
     * @param seq
     *            to be stored in the leaf
     */
    public LeafNode(String seq) {
        this.data = seq;
    }


    /**
     * Inserts a sequence into the LeafNode
     * 
     * @param seq
     *            to be inserted
     * @param level
     *            level of the sequence
     * @return new IntNode with inserted value and current value
     */
    public Node insert(String seq, int level) {

        if (data.equals(seq)) {
            System.out.println("sequence " + seq + " already exists");
            return this;
        }

        IntNode internal = new IntNode(level, data);
        internal.insert(seq, level);

        return internal;

    }


    /**
     * Removes a sequence from the Node
     * 
     * @param seq
     *            to be removed
     * @return FlyWeight if properly removed, Current Node if not
     */
    public Node remove(String seq) {
        if (data.equals(seq)) {
            System.out.println("sequence " + seq + " removed");
            return BSTree.FLYWEIGHT;
        }
        else {
            System.out.println("sequence " + seq + " does not exist");
        }
        return this;
    }


    /**
     * Searches for a specified sequence
     * 
     * @param seq
     *            to be searched for
     * @param arr
     *            of values to keep track of sequences
     * @return updated array by count and sequence
     */
    public String[] search(String seq, String[] arr) {

        // Adds one to the nodes visited
        int count = Integer.parseInt(arr[0]);
        count++;
        arr[0] = Integer.toString(count);

        if (seq.charAt(seq.length() - 1) == '$') {
            if (data.equals(seq.substring(0, seq.length() - 1))) {
                String[] newArr = Arrays.copyOf(arr, 2);
                newArr[1] = data;
                return newArr;
            }
        }
        else if (data.startsWith(seq)) {

            String[] newArr = Arrays.copyOf(arr, arr.length + 1);
            newArr[newArr.length - 1] = data;
            return newArr;

        }
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
        line += data;

        System.out.println(line);
    }


    /**
     * Prints the Node with lengths beside the sequences
     * 
     * @param level
     *            to keep track of indentations
     */
    public void printLength(int level) {
        String line = "";
        for (int i = 0; i < level; i++) {
            line += "  ";
        }
        line += data;
        line += " " + data.length();

        System.out.println(line);
    }


    /**
     * Prints the Node with stats beside the sequences
     * 
     * @param level
     *            to keep track of indentations
     */
    public void printStats(int level) {

        String line = "";
        for (int i = 0; i < level; i++) {
            line += "  ";
        }
        line += data;
        line += " " + getStats();

        System.out.println(line);

    }


    /**
     * Finds the statistics for the letters to the node
     * 
     * @return a string of the statistics
     */
    public String getStats() {

        float total = (float)data.length();
        DecimalFormat dec = new DecimalFormat("#0.00");

        // Array to hold the counts for each letter: ACGT
        int[] stats = new int[4];

        for (int i = 0; i < data.length(); i++) {
            char letter = data.charAt(i);
            switch (letter) {
                case 'A':
                    stats[0]++;
                    break;
                case 'C':
                    stats[1]++;
                    break;
                case 'G':
                    stats[2]++;
                    break;
                case 'T':
                    stats[3]++;
                    break;
            }
        }
        float a = (stats[0] / total) * 100;
        float c = (stats[1] / total) * 100;
        float g = (stats[2] / total) * 100;
        float t = (stats[3] / total) * 100;

        String line = "A:" + dec.format(a);
        line += " C:" + dec.format(c);
        line += " G:" + dec.format(g);
        line += " T:" + dec.format(t);

        return line;
    }

}

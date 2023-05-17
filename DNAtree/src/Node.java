/**
 * Node interface for all of the base nodes
 * 
 * @author kylem
 * @version 2/20/2023
 */
public interface Node {

    /**
     * Inserts a sequence into the Node
     * 
     * @param seq
     *            to be inserted
     * @param lvl
     *            of the tree that sequence is added to
     * @return Node touched by insertion
     */
    public Node insert(String seq, int lvl);


    /**
     * Removes a sequence from the Node
     * 
     * @param seq
     *            to be removed
     * @return Node touched by removal
     */
    public Node remove(String seq);


    /**
     * Searches for a specified sequence
     * 
     * @param seq
     *            to be searched for
     * @param arr
     *            of values to keep track of sequences
     * @return updated arr if sequences are found
     */
    public String[] search(String seq, String[] arr);


    /**
     * Prints the tree with values
     * 
     * @param level
     *            to keep track of indentations
     */
    public void print(int level);


    /**
     * Prints the tree with lengths beside the sequences
     * 
     * @param level
     *            to keep track of indentations
     */
    public void printLength(int level);


    /**
     * Prints the tree with stats beside the sequences
     * 
     * @param level
     *            to keep track of indentations
     */
    public void printStats(int level);

}

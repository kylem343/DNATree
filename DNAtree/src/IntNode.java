/**
 * Represents the internal node to the binary tree
 * 
 * @author kylem
 * @version 2/8/2023
 */
public class IntNode implements Node {

    /**
     * Leaf A
     */
    private Node leafA;

    /**
     * Leaf C
     */
    private Node leafC;

    /**
     * Leaf G
     */
    private Node leafG;

    /**
     * Leaf T
     */
    private Node leafT;

    /**
     * Leaf $
     */
    private Node leafDolla;

    /**
     * Used to track the current depth of the node
     * Number indicates which letter in the sequence we are tracking
     */
    private int level;

    /**
     * Constructor to insert a sequence into the node
     * without the use of the insert method
     * 
     * @param depth
     *            of the Internal Node
     * @param seq
     *            to be initially inserted
     */
    public IntNode(int depth, String seq) {
        leafA = BSTree.FLYWEIGHT;
        leafC = BSTree.FLYWEIGHT;
        leafG = BSTree.FLYWEIGHT;
        leafT = BSTree.FLYWEIGHT;
        leafDolla = BSTree.FLYWEIGHT;

        level = depth;

        if (level == seq.length()) {
            leafDolla = new LeafNode(seq);
        }
        else {

            String letter = seq.substring(depth, depth + 1);

            switch (letter) {
                case "A":
                    leafA = new LeafNode(seq);
                    break;
                case "C":
                    leafC = new LeafNode(seq);
                    break;
                case "G":
                    leafG = new LeafNode(seq);
                    break;
                case "T":
                    leafT = new LeafNode(seq);
                    break;

            }
        }
    }


    /**
     * Inserts a sequence into it's proper leaf node
     * 
     * @param seq
     *            sequence to be inserted
     * @param lvl
     *            current lvl of the node
     * @return returns the current Node
     */
    public Node insert(String seq, int lvl) {

        if (level == seq.length()) {
            leafDolla = leafDolla.insert(seq, level + 1);
        }
        else {

            String letter = seq.substring(level, level + 1);

            switch (letter) {
                case "A":
                    leafA = leafA.insert(seq, level + 1);
                    break;
                case "C":
                    leafC = leafC.insert(seq, level + 1);
                    break;
                case "G":
                    leafG = leafG.insert(seq, level + 1);
                    break;
                case "T":
                    leafT = leafT.insert(seq, level + 1);
                    break;
            }
        }
        return this;
    }


    /**
     * Removes a sequence from the Node
     * 
     * @param seq
     *            to be removed
     * @return Current Node if 2+ children or an int Node is a child or LeafNode
     *         is a single LeafNode is left
     */
    public Node remove(String seq) {
        if (seq.length() == level) {
            leafDolla = leafDolla.remove(seq);
        }
        else {
            char let = seq.charAt(level);
            switch (let) {
                case 'A':
                    leafA = leafA.remove(seq);
                    break;
                case 'C':
                    leafC = leafC.remove(seq);
                    break;
                case 'G':
                    leafG = leafG.remove(seq);
                    break;
                case 'T':
                    leafT = leafT.remove(seq);
                    break;
            }
        }
        int idx = onlyChild();
        if (idx != -1) {
            // positive cases signify it must be a leafNode of index idx
            switch (idx) {
                case 0:
                    return leafA;
                case 1:
                    return leafC;
                case 2:
                    return leafG;
                case 3:
                    return leafT;
                case 4:
                    return leafDolla;
            }
        }
        // The last case would be -1 which means that there is more than one
        // children and therefore does not need to be changed
        return this;
    }


    /**
     * Searches for a specified sequence
     * 
     * @param seq
     *            to be searched for
     * @param arr
     *            of values to keep track of sequences
     * @return updated array to the sequences
     */
    public String[] search(String seq, String[] arr) {
        // Adds one to the nodes visited
        int count = Integer.parseInt(arr[0]);
        count++;
        arr[0] = Integer.toString(count);

        if (seq.length() - 1 == level && seq.charAt(seq.length() - 1) == '$') {
            return leafDolla.search(seq, arr);

        }
        else if (seq.length() > level) {
            char let = seq.charAt(level);
            switch (let) {
                case 'A':
                    return leafA.search(seq, arr);
                case 'C':
                    return leafC.search(seq, arr);
                case 'G':
                    return leafG.search(seq, arr);
                case 'T':
                    return leafT.search(seq, arr);
            }
        }
        else {
            arr = leafA.search(seq, arr);
            arr = leafC.search(seq, arr);
            arr = leafG.search(seq, arr);
            arr = leafT.search(seq, arr);
            arr = leafDolla.search(seq, arr);
        }

        return arr;
    }


    /**
     * Prints the Node
     * 
     * @param lvl
     *            to keep track of indentations
     */
    public void print(int lvl) {
        String line = "";
        for (int i = 0; i < lvl; i++) {
            line += "  ";
        }
        line += "I";

        System.out.println(line);

        leafA.print(lvl + 1);
        leafC.print(lvl + 1);
        leafG.print(lvl + 1);
        leafT.print(lvl + 1);
        leafDolla.print(lvl + 1);

    }


    /**
     * Prints the Node with lengths beside the sequences
     * 
     * @param lvl
     *            to keep track of indentations
     */
    public void printLength(int lvl) {
        String line = "";
        for (int i = 0; i < lvl; i++) {
            line += "  ";
        }
        line += "I";

        System.out.println(line);

        leafA.printLength(lvl + 1);
        leafC.printLength(lvl + 1);
        leafG.printLength(lvl + 1);
        leafT.printLength(lvl + 1);
        leafDolla.printLength(lvl + 1);
    }


    /**
     * Prints the Node with stats beside the sequences
     * 
     * @param lvl
     *            to keep track of indentations
     */
    public void printStats(int lvl) {
        String line = "";
        for (int i = 0; i < lvl; i++) {
            line += "  ";
        }
        line += "I";

        System.out.println(line);

        leafA.printStats(lvl + 1);
        leafC.printStats(lvl + 1);
        leafG.printStats(lvl + 1);
        leafT.printStats(lvl + 1);
        leafDolla.printStats(lvl + 1);
    }


    /**
     * Checks if there is a single child so we can adjust the tree on removal
     * 
     * @return -1 if no changes need to be made or the index of the child to be
     *         absorbed
     */
    private int onlyChild() {
        // We need 4 flyweights and 1 leaf node to return an index
        int flyCount = 0;
        int leafIdx = -1;

        // Checks if LeafA is a leaf or flyweight node
        if (leafA instanceof FlyNode) {
            flyCount++;
        }
        else if (leafA instanceof LeafNode) {
            leafIdx = 0;
        }

        // Checks if LeafC is a leaf or flyweight node
        if (leafC instanceof FlyNode) {
            flyCount++;
        }
        else if (leafC instanceof LeafNode) {
            leafIdx = 1;
        }

        // Checks if LeafG is a leaf or flyweight node
        if (leafG instanceof FlyNode) {
            flyCount++;
        }
        else if (leafG instanceof LeafNode) {
            leafIdx = 2;
        }

        // Checks if LeafT is a leaf or flyweight node
        if (leafT instanceof FlyNode) {
            flyCount++;
        }
        else if (leafT instanceof LeafNode) {
            leafIdx = 3;
        }

        // Checks if LeafC is a leaf or flyweight node
        if (leafDolla instanceof FlyNode) {
            flyCount++;
        }
        else {
            leafIdx = 4;
        }

        // If there are 4 fly-weights, then there must be only one child node
        // and
        // therefore the index of that leaf is returned. If there are more than
        // one leaf or IntNode then return -1
        if (flyCount == 4) {
            return leafIdx;
        }
        else {
            return -1;
        }

    }

}

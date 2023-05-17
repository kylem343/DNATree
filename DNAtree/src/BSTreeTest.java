import student.TestCase;

/**
 * Test class for the BSTree class
 * 
 * @author kylem
 * @version 3/2/2023
 */
public class BSTreeTest extends TestCase {

    /**
     * Testing trees
     */
    private BSTree tree;
    private BSTree tree2;

    /**
     * Set up for the tree's to be used
     */
    public void setUp() {
        tree = new BSTree();

        tree2 = new BSTree();
        tree2.insert("AAA");
        tree2.insert("GTA");
        systemOut().clearHistory();

    }


    /**
     * Tests the inser() method
     */
    public void testInsert() {

        tree.insert(null);
        tree.insert("AA");
        assertEquals("sequence AA inserted at level 0\n", systemOut()
            .getHistory());
        systemOut().clearHistory();
    }


    /**
     * Tests the remove() method
     */
    public void testRemove() {
        tree2.remove("AGA");
        assertEquals("sequence AGA does not exist\n", systemOut().getHistory());
        systemOut().clearHistory();

        tree2.remove("AAA");
        assertEquals("sequence AAA removed\n", systemOut().getHistory());
        systemOut().clearHistory();
    }


    /**
     * Tests the print() method
     */
    public void testPrint() {
        tree.print();
        assertEquals("tree dump:\nE\n", systemOut().getHistory());
        systemOut().clearHistory();

        tree2.print();
        assertEquals("tree dump:\nI\n  AAA\n  E\n  GTA\n  E\n  E\n", systemOut()
            .getHistory());
        systemOut().clearHistory();
    }


    /**
     * Tests the printLength() method
     */
    public void testPrintLength() {
        tree.printLength();
        assertEquals("tree dump:\nE\n", systemOut().getHistory());
        systemOut().clearHistory();

        tree2.printLength();
        assertEquals("tree dump:\nI\n  AAA 3\n  E\n  GTA 3\n  E\n  E\n",
            systemOut().getHistory());
        systemOut().clearHistory();
    }


    /**
     * Tests the printStats() method
     */
    public void testPrintStats() {
        tree.printStats();
        assertEquals("tree dump:\nE\n", systemOut().getHistory());
        systemOut().clearHistory();

        tree2.printStats();
        assertEquals("tree dump:\nI\n  AAA A:100.00 C:0.00 G:0.00"
            + " T:0.00\n  E\n  GTA A:33.33 "
            + "C:0.00 G:33.33 T:33.33\n  E\n  E\n", systemOut().getHistory());
        systemOut().clearHistory();
    }


    /**
     * Tests the search() method
     */
    public void testSearch() {
        tree2.search("CAA");
        assertEquals("# of nodes visited: 2\nno sequence found\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        tree2.search("AAA");
        assertEquals("# of nodes visited: 2\nsequence: AAA\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

    }

}

import student.TestCase;

/**
 * Test Class for the FlyNode
 * 
 * @author kylem
 * @version 3/1/2023
 */
public class FlyNodeTest extends TestCase {

    private FlyNode node;

    /**
     * Sets up the test node
     */
    public void setUp() {
        node = new FlyNode();
    }


    /**
     * Test method for the getFly() method
     */
    public void testGetFly() {
        assertTrue(FlyNode.getFly() instanceof FlyNode);
    }


    /**
     * Test method for the insert() method
     */
    public void testInsert() {
        Node temp = node.insert("AA", 0);
        assertTrue(temp instanceof LeafNode);
        assertEquals(systemOut().getHistory(),
            "sequence AA inserted at level 0\n");
        systemOut().clearHistory();

    }


    /**
     * Test method for the remove() method
     */
    public void testRemove() {
        Node temp = node.remove("AA");
        assertTrue(temp instanceof FlyNode);
        assertEquals(systemOut().getHistory(), "sequence AA does not exist\n");
        systemOut().clearHistory();
    }


    /**
     * Test method for the search() method
     */
    public void testSearch() {
        String[] arr = { "0" };
        String[] temp = node.search("AA", arr);

        assertEquals("1", temp[0]);
        assertEquals(1, temp.length);
    }


    /**
     * Test method for the print() method
     */
    public void testPrint() {
        node.print(2);
        assertEquals("    E\n", systemOut().getHistory());
        systemOut().clearHistory();

    }


    /**
     * Test method for the printLength() method
     */
    public void testPrintLength() {
        node.printLength(2);
        assertEquals("    E\n", systemOut().getHistory());
        systemOut().clearHistory();
    }


    /**
     * Test method for the printStats() method
     */
    public void testPrintStats() {
        node.printStats(2);
        assertEquals("    E\n", systemOut().getHistory());
        systemOut().clearHistory();
    }
}

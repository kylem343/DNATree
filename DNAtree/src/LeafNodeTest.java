import student.TestCase;

/**
 * TestClass for LeafNode
 * 
 * @author kylem
 * @version 3/1/2023
 */
public class LeafNodeTest extends TestCase {

    /**
     * Testing Variables
     */
    private LeafNode node;
    private LeafNode node2;

    /**
     * Sets up the node test variables
     */
    public void setUp() {
        node = new LeafNode("AA");
        node2 = new LeafNode("ACTGGGAA");
    }


    /**
     * tests the insert() method
     */
    public void testInsert() {

        node.insert("AA", 0);
        assertEquals(systemOut().getHistory(), "sequence AA already exists\n");

        Node temp = node.insert("AC", 0);
        assertTrue(temp instanceof IntNode);
    }


    /**
     * tests the remove() method
     */
    public void testRemove() {
        Node temp = node.remove("AB");
        assertEquals(systemOut().getHistory(), "sequence AB does not exist\n");
        assertTrue(temp instanceof LeafNode);

        systemOut().clearHistory();

        temp = node.remove("AA");
        assertEquals(systemOut().getHistory(), "sequence AA removed\n");
        assertTrue(temp instanceof FlyNode);
    }


    /**
     * tests the search() method
     */
    public void testSearch() {
        String[] arr = { "0" };
        String[] temp = node.search("A", arr);
        assertEquals("1", temp[0]);
        assertEquals("AA", temp[1]);
        assertEquals(2, temp.length);

        String[] arr2 = { "0" };
        String[] temp2 = node.search("A$", arr2);
        assertEquals("1", temp2[0]);
        assertEquals(1, temp2.length);

        String[] arr3 = { "0" };
        String[] temp3 = node.search("AA$", arr3);
        assertEquals("1", temp3[0]);
        assertEquals("AA", temp3[1]);
        assertEquals(2, temp3.length);

    }


    /**
     * tests the print() method
     */
    public void testPrint() {

        node.print(0);
        assertEquals(systemOut().getHistory(), "AA\n");

        systemOut().clearHistory();

        node.print(2);
        assertEquals(systemOut().getHistory(), "    AA\n");

    }


    /**
     * tests the printLength() method
     */
    public void testPrintLength() {
        node.printLength(0);
        assertEquals(systemOut().getHistory(), "AA 2\n");

        systemOut().clearHistory();

        node.printLength(2);
        assertEquals(systemOut().getHistory(), "    AA 2\n");
    }


    /**
     * tests the printStats() method
     */
    public void testPrintStats() {
        node.printStats(0);
        assertEquals(systemOut().getHistory(),
            "AA A:100.00 C:0.00 G:0.00 T:0.00\n");

        systemOut().clearHistory();

        node.printStats(2);
        assertEquals(systemOut().getHistory(),
            "    AA A:100.00 C:0.00 G:0.00 T:0.00\n");
    }


    /**
     * tests the getStats() method
     */
    public void testGetStats() {
        assertEquals("A:100.00 C:0.00 G:0.00 T:0.00", node.getStats());
        assertEquals("A:37.50 C:12.50 G:37.50 T:12.50", node2.getStats());
    }
}

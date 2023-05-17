import student.TestCase;

/**
 * Test Cases for the IntNode class
 * 
 * @author kylem
 * @version 3/1/2023
 */
public class IntNodeTest extends TestCase {

    /**
     * Testing Variables
     */
    private IntNode node;
    private IntNode node2;
    private IntNode node3;

    /**
     * Sets up the node test variables
     */
    public void setUp() {

        node = new IntNode(0, "GTA");

        node2 = new IntNode(3, "ACTG");
        node2 = new IntNode(3, "CTGA");
        node2 = new IntNode(3, "TACC");
        node2 = new IntNode(3, "GACT");

        node3 = new IntNode(1, "A");
    }


    /**
     * tests the insert() method
     */
    public void testInsert() {
        Node temp = node2.insert("ACC", 1);
        assertTrue(temp instanceof IntNode);

        temp = node3.insert("CCC", 0);
        assertTrue(temp instanceof IntNode);

        temp = node3.insert("GG", 0);
        assertTrue(temp instanceof IntNode);

        temp = node3.insert("TTT", 0);
        assertTrue(temp instanceof IntNode);

        temp = node3.insert("AAA", 0);
        assertTrue(temp instanceof IntNode);

    }


    /**
     * tests the remove() method
     */
    public void testRemove() {

        node = new IntNode(0, "GTA");
        node.insert("ACT", 0);
        assertTrue(node.remove("ACT") instanceof LeafNode);

        node = new IntNode(0, "GTA");
        node.insert("ACT", 0);
        assertTrue(node.remove("GTA") instanceof LeafNode);

        node = new IntNode(0, "TCA");
        node.insert("CAT", 0);
        assertTrue(node.remove("CAT") instanceof LeafNode);

        node = new IntNode(0, "CTA");
        node.insert("TCA", 0);
        assertTrue(node.remove("TCA") instanceof LeafNode);

        node = new IntNode(0, "GTA");
        node.insert("ACT", 0);
        node.insert("CAT", 0);
        assertTrue(node.remove("ACT") instanceof IntNode);

        node = new IntNode(3, "CTA");
        node.insert("TCAT", 0);
        assertTrue(node.remove("TCAT") instanceof LeafNode);

        node = new IntNode(3, "CTA");
        node.insert("TCAT", 0);
        assertTrue(node.remove("CTA") instanceof LeafNode);

    }


    /**
     * tests the search() method
     */
    public void testSearch() {

        node = new IntNode(1, "A");
        node.insert("AAA", 1);
        node.insert("ACT", 1);
        node.insert("AGT", 1);
        node.insert("ATC", 1);

        String[] arr = { "0" };
        String[] temp = node.search("A$", arr);
        assertEquals("2", temp[0]);
        assertEquals("A", temp[1]);
        assertEquals(2, temp.length);

        String[] arr2 = { "0" };
        String[] temp2 = node.search("AAA", arr2);
        assertEquals("2", temp2[0]);
        assertEquals("AAA", temp2[1]);
        assertEquals(2, temp2.length);

        String[] arr3 = { "0" };
        String[] temp3 = node.search("ACT", arr3);
        assertEquals("2", temp3[0]);
        assertEquals("ACT", temp3[1]);
        assertEquals(2, temp3.length);

        String[] arr4 = { "0" };
        String[] temp4 = node.search("AGT", arr4);
        assertEquals("2", temp4[0]);
        assertEquals("AGT", temp4[1]);
        assertEquals(2, temp4.length);

        String[] arr5 = { "0" };
        String[] temp5 = node.search("ATC", arr5);
        assertEquals("2", temp5[0]);
        assertEquals("ATC", temp5[1]);
        assertEquals(2, temp5.length);

        String[] arr6 = { "0" };
        String[] temp6 = node2.search("GA", arr6);
        assertEquals("6", temp6[0]);
        assertEquals("GACT", temp6[1]);
        assertEquals(2, temp6.length);
    }


    /**
     * tests the print() method
     */
    public void testPrint() {
        node.print(1);
        String ans = "  I\n    E\n    E\n    GTA\n    E\n    E\n";
        assertEquals(systemOut().getHistory(), ans);
        systemOut().clearHistory();
    }


    /**
     * tests the printLength() method
     */
    public void testPrintLength() {
        node.printLength(1);
        String ans = "  I\n    E\n    E\n    GTA 3\n    E\n    E\n";
        assertEquals(systemOut().getHistory(), ans);
        systemOut().clearHistory();

    }


    /**
     * tests the printStats() method
     */
    public void testPrintStats() {
        node.printStats(1);
        String ans = "  I\n    E\n    E\n    GTA A:33.33 "
            + "C:0.00 G:33.33 T:33.33\n    E\n    E\n";
        assertEquals(systemOut().getHistory(), ans);
        systemOut().clearHistory();
    }

}

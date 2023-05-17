import student.TestCase;

/**
 * Test Class for the DNATree class
 * 
 * @author kylem
 * @version 3/1/2023
 */
public class DNAtreeTest extends TestCase {

    /**
     * Tests the main method for DNATree
     */
    public void testMain() {
        String[] argz;

        argz = null;
        DNAtree.main(argz);
        assertEquals("", systemOut().getHistory());

        argz = new String[1];
        DNAtree.main(argz);
        assertEquals("", systemOut().getHistory());

        argz[0] = "SampleInput.txt";
        DNAtree.main(argz);
        assertEquals("sequence ACGT inserted at level 0\r\n"
            + "sequence AAAA inserted at level 2\r\n"
            + "sequence AA inserted at level 3\r\n"
            + "sequence AAACCCCGGTGAAAACGTA inserted at level 4\r\n"
            + "sequence ACTGGGAA inserted at level 3\r\n"
            + "sequence ACGT removed\r\n"
            + "sequence ACCTT inserted at level 3\r\n"
            + "sequence ACTTA inserted at level 4\r\n" + "tree dump:\r\n"
            + "I\r\n" + "  I\r\n" + "    I\r\n" + "      I\r\n"
            + "        AAAA\r\n" + "        AAACCCCGGTGAAAACGTA\r\n"
            + "        E\r\n" + "        E\r\n" + "        E\r\n"
            + "      E\r\n" + "      E\r\n" + "      E\r\n" + "      AA\r\n"
            + "    I\r\n" + "      E\r\n" + "      ACCTT\r\n" + "      E\r\n"
            + "      I\r\n" + "        E\r\n" + "        E\r\n"
            + "        ACTGGGAA\r\n" + "        ACTTA\r\n" + "        E\r\n"
            + "      E\r\n" + "    E\r\n" + "    E\r\n" + "    E\r\n"
            + "  E\r\n" + "  E\r\n" + "  E\r\n" + "  E\r\n"
            + "sequence TATA inserted at level 1\r\n"
            + "sequence TCG inserted at level 2\r\n" + "tree dump:\r\n"
            + "I\r\n" + "  I\r\n" + "    I\r\n" + "      I\r\n"
            + "        AAAA 4\r\n" + "        AAACCCCGGTGAAAACGTA 19\r\n"
            + "        E\r\n" + "        E\r\n" + "        E\r\n"
            + "      E\r\n" + "      E\r\n" + "      E\r\n" + "      AA 2\r\n"
            + "    I\r\n" + "      E\r\n" + "      ACCTT 5\r\n" + "      E\r\n"
            + "      I\r\n" + "        E\r\n" + "        E\r\n"
            + "        ACTGGGAA 8\r\n" + "        ACTTA 5\r\n" + "        E\r\n"
            + "      E\r\n" + "    E\r\n" + "    E\r\n" + "    E\r\n"
            + "  E\r\n" + "  E\r\n" + "  I\r\n" + "    TATA 4\r\n"
            + "    TCG 3\r\n" + "    E\r\n" + "    E\r\n" + "    E\r\n"
            + "  E\r\n" + "tree dump:\r\n" + "I\r\n" + "  I\r\n" + "    I\r\n"
            + "      I\r\n" + "        AAAA A:100.00 C:0.00 G:0.00 T:0.00\r\n"
            + "        AAACCCCGGTGAAAACGTA A:42.11 C:26.32 G:21.05 T:10.53\r\n"
            + "        E\r\n" + "        E\r\n" + "        E\r\n"
            + "      E\r\n" + "      E\r\n" + "      E\r\n"
            + "      AA A:100.00 C:0.00 G:0.00 T:0.00\r\n" + "    I\r\n"
            + "      E\r\n" + "      ACCTT A:20.00 C:40.00 G:0.00 T:40.00\r\n"
            + "      E\r\n" + "      I\r\n" + "        E\r\n" + "        E\r\n"
            + "        ACTGGGAA A:37.50 C:12.50 G:37.50 T:12.50\r\n"
            + "        ACTTA A:40.00 C:20.00 G:0.00 T:40.00\r\n"
            + "        E\r\n" + "      E\r\n" + "    E\r\n" + "    E\r\n"
            + "    E\r\n" + "  E\r\n" + "  E\r\n" + "  I\r\n"
            + "    TATA A:50.00 C:0.00 G:0.00 T:50.00\r\n"
            + "    TCG A:0.00 C:33.33 G:33.33 T:33.33\r\n" + "    E\r\n"
            + "    E\r\n" + "    E\r\n" + "  E\r\n"
            + "# of nodes visited: 5\r\n" + "sequence: AAAA\r\n"
            + "# of nodes visited: 13\r\n" + "sequence: AAAA\r\n"
            + "sequence: AAACCCCGGTGAAAACGTA\r\n" + "sequence: AA\r\n"
            + "# of nodes visited: 4\r\n" + "no sequence found\n", systemOut()
                .getHistory());
        systemOut().clearHistory();
    }


    /**
     * Tests the runCommands() method
     */
    public void testRunCommands() {

        String[] argz = new String[1];
        argz[0] = "SampleInput.txt";
        DNAtree.main(argz);
        assertEquals("sequence ACGT inserted at level 0\r\n"
            + "sequence AAAA inserted at level 2\r\n"
            + "sequence AA inserted at level 3\r\n"
            + "sequence AAACCCCGGTGAAAACGTA inserted at level 4\r\n"
            + "sequence ACTGGGAA inserted at level 3\r\n"
            + "sequence ACGT removed\r\n"
            + "sequence ACCTT inserted at level 3\r\n"
            + "sequence ACTTA inserted at level 4\r\n" + "tree dump:\r\n"
            + "I\r\n" + "  I\r\n" + "    I\r\n" + "      I\r\n"
            + "        AAAA\r\n" + "        AAACCCCGGTGAAAACGTA\r\n"
            + "        E\r\n" + "        E\r\n" + "        E\r\n"
            + "      E\r\n" + "      E\r\n" + "      E\r\n" + "      AA\r\n"
            + "    I\r\n" + "      E\r\n" + "      ACCTT\r\n" + "      E\r\n"
            + "      I\r\n" + "        E\r\n" + "        E\r\n"
            + "        ACTGGGAA\r\n" + "        ACTTA\r\n" + "        E\r\n"
            + "      E\r\n" + "    E\r\n" + "    E\r\n" + "    E\r\n"
            + "  E\r\n" + "  E\r\n" + "  E\r\n" + "  E\r\n"
            + "sequence TATA inserted at level 1\r\n"
            + "sequence TCG inserted at level 2\r\n" + "tree dump:\r\n"
            + "I\r\n" + "  I\r\n" + "    I\r\n" + "      I\r\n"
            + "        AAAA 4\r\n" + "        AAACCCCGGTGAAAACGTA 19\r\n"
            + "        E\r\n" + "        E\r\n" + "        E\r\n"
            + "      E\r\n" + "      E\r\n" + "      E\r\n" + "      AA 2\r\n"
            + "    I\r\n" + "      E\r\n" + "      ACCTT 5\r\n" + "      E\r\n"
            + "      I\r\n" + "        E\r\n" + "        E\r\n"
            + "        ACTGGGAA 8\r\n" + "        ACTTA 5\r\n" + "        E\r\n"
            + "      E\r\n" + "    E\r\n" + "    E\r\n" + "    E\r\n"
            + "  E\r\n" + "  E\r\n" + "  I\r\n" + "    TATA 4\r\n"
            + "    TCG 3\r\n" + "    E\r\n" + "    E\r\n" + "    E\r\n"
            + "  E\r\n" + "tree dump:\r\n" + "I\r\n" + "  I\r\n" + "    I\r\n"
            + "      I\r\n" + "        AAAA A:100.00 C:0.00 G:0.00 T:0.00\r\n"
            + "        AAACCCCGGTGAAAACGTA A:42.11 C:26.32 G:21.05 T:10.53\r\n"
            + "        E\r\n" + "        E\r\n" + "        E\r\n"
            + "      E\r\n" + "      E\r\n" + "      E\r\n"
            + "      AA A:100.00 C:0.00 G:0.00 T:0.00\r\n" + "    I\r\n"
            + "      E\r\n" + "      ACCTT A:20.00 C:40.00 G:0.00 T:40.00\r\n"
            + "      E\r\n" + "      I\r\n" + "        E\r\n" + "        E\r\n"
            + "        ACTGGGAA A:37.50 C:12.50 G:37.50 T:12.50\r\n"
            + "        ACTTA A:40.00 C:20.00 G:0.00 T:40.00\r\n"
            + "        E\r\n" + "      E\r\n" + "    E\r\n" + "    E\r\n"
            + "    E\r\n" + "  E\r\n" + "  E\r\n" + "  I\r\n"
            + "    TATA A:50.00 C:0.00 G:0.00 T:50.00\r\n"
            + "    TCG A:0.00 C:33.33 G:33.33 T:33.33\r\n" + "    E\r\n"
            + "    E\r\n" + "    E\r\n" + "  E\r\n"
            + "# of nodes visited: 5\r\n" + "sequence: AAAA\r\n"
            + "# of nodes visited: 13\r\n" + "sequence: AAAA\r\n"
            + "sequence: AAACCCCGGTGAAAACGTA\r\n" + "sequence: AA\r\n"
            + "# of nodes visited: 4\r\n" + "no sequence found\n", systemOut()
                .getHistory());
        systemOut().clearHistory();

    }

}

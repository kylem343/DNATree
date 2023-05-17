import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

// On my honor:
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project
// with anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
/**
 * Main class to host the DNAtree
 * 
 * @author kylem
 * @version 2/8/2023
 */
public class DNAtree {

    /**
     * Tree to be manipulated
     */
    private static BSTree tree;

    /**
     * Main method for the project
     * 
     * @param args
     *            file name of text file to be read
     * @throws IOException
     */
    public static void main(String[] args) {

        tree = new BSTree();

        // Checks that there is an arg
        if (args == null) {
            return;
        }

        // Checks that there is only one argument <input-file>
        if (args.length != 1) {
            return;
        }

        // Checks that the argument is not null
        if (args[0] == null) {
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        // Basic Scanner checking
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String fileLine = sc.nextLine();
                // makes sure not to pass in a blank line
                if (!fileLine.isBlank()) {
                    // Main meat of the code
                    runCommands(fileLine);

                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    /**
     * Runs the commands from the TextFile
     * 
     * @param line
     *            command to be run
     */
    public static void runCommands(String line) {

        if (line == null) {
            throw new NullPointerException("Must be a String line");
        }
        String[] arguments = line.split("\\s+");

        int firstIdx = 0;
        if (arguments[firstIdx].isBlank()) {
            firstIdx++;
        }

        switch (arguments[firstIdx]) {
            case "insert":
                tree.insert(arguments[firstIdx + 1]);
                break;
            case "remove":
                tree.remove(arguments[firstIdx + 1]);
                break;
            case "print":
                // If no other argument then it must be regular "print" method
                if (arguments.length == firstIdx + 1) {
                    tree.print();
                }
                else if (arguments[firstIdx + 1].equals("lengths")) {
                    tree.printLength();
                }
                else if (arguments[firstIdx + 1].equals("stats")) {
                    tree.printStats();
                }
                break;
            case "search":
                tree.search(arguments[firstIdx + 1]);
                break;
        }

    }

}

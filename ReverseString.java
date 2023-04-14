import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
* Reads a file and calculates mean median and mode.
*
* @author  Mr. Riscalas
* @version 1.0
* @since   2023-04-13
*/

public final class ReverseString {
    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private ReverseString() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the stringReverse method.
     *
     * @param inputString //inputString
     * @return inputString
     *
     */
    public static String reverse(String inputString) {
        if (inputString.isEmpty()) {
            return inputString;
        }
        return reverse(inputString.substring(1)) + inputString.charAt(0);
    }

    /**
     * This is the main method.
     *
     * @param args //unused
     *
     */

    public static void main(final String[] args) {
        // Set the input and output file paths
        final String inputFilePath = "input.txt";
        final String outputFilePath = "output.txt";

        // Read input from file using Scanner
        try (Scanner scanner = new Scanner(new File(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {
            // Read each line from the input file and reverse it using recursion
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                final String reversedLine = reverse(line);

                // Write the reversed line to the output file
                writer.write("Reversed line: " + reversedLine + "\n");
            }
        } catch (FileNotFoundException error) {
            System.err.println("File not found: " + error.getMessage());
        } catch (IOException error) {
            System.err.println("Error writing to file: " + error.getMessage());
        }
    }
}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class that utilizes the MorseCode class, to create a list that holds objects of type MorseCode, to print the aforementioned list,
 * or use that list to translate Strings to Morse Code.
 */
public class MorseCodeConvert {

    /**
     * An ArrayList that holds objects of type MorseCode.
     */
    private final ArrayList<MorseCode> listCodes = new ArrayList<>();

    /**
     * Non-Default Constructor for MorseCodeConvert Class.
     * When an instance of this class is created, the constructor uses the file, if found, to populate listCodes with
     * @param fileName A String that contains the name of a file to be read.
     */
    public MorseCodeConvert(String fileName) {

        try (Scanner sc = new Scanner(new FileInputStream(fileName))) {

            while (sc.hasNext()) {

                try {
                    String[] str = sc.nextLine().split("\t");    //Splits the lines where the MorseCodes are in based on a tab space.
                    if (str.length == 2) {                             //If the string generated isn't of length 2, it is not added in listCodes.
                        MorseCode mrsCd = new MorseCode(str[0].charAt(0), str[1]);
                        listCodes.add(mrsCd);
                    } else {
                        throw new Exception("Invalid line: " + str[0]);   //This is shown on the command line in case the string is not of length 2.
                    }

                } catch (Exception mce) {

                    System.err.println(mce.toString());
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open file: " + Paths.get(fileName));    //Displays an error if the file you're trying to access is not found.
        }
    }

    /**
     * Iteratively prints a list of the contents of listCodes
     */
    public void printEncodingList() {
        for (MorseCode listEntry : listCodes) {
            System.out.printf("%s%s%s%s%s\n", "('", listEntry.getCharacter(), "', ", listEntry.getEncoding(), ")");
        }
    }

    /**
     * Finds and returns the MorseCode object that lists the character we are looking to turn into Morse Code
     * @param input The character we want to turn into Morse Code
     * @return The MorseCode object in listCodes that holds the character we are looking for. If the character is not in the list
     * then it must be a whitespace in which case we return "\b" to erase the extra whitespace that would be caused by returning an empty string.
     * @throws MorseCriteriaException It can throw this only if someone were to change what the function returns after the for-loop and it does not meet the criteria set when instantiating MorseCode().
     */
    public MorseCode find(char input) throws MorseCriteriaException {

        for (MorseCode listEntry : listCodes) {
            if (listEntry.getCharacter() == input)
                return listEntry;

        }

        return new MorseCode(' ',"\b");    //Returns a backspace symbol that erases the whitespace added after every encoding.
    }                                                      //This counters an issue with the code where there would be a double whitespace if I simply returned an empty string.

    /**
     * Translates a string into Morse Code.
     * @param inputString A String to be translated into Morse Code.
     */
    public void encodeString(String inputString) {

        try {
            if (inputString == null) inputString = "";    //Makes sure our String != null so that we don't get an indexOutOfBoundException.

            for (int i = 0; i < inputString.length(); i++) {
                char inputChar = inputString.toUpperCase().charAt(i);    //Converts our the character at index "i" into uppercase because morse code doesn't have a lower case.
                //if(find(inputChar).getEncoding() == "") continue;               //Skipping MorseCode of this type fixes an issue where I would get a double white.
                System.out.printf("%s%s", find(inputChar).getEncoding()," ");    //Prints the Morse Code string equivalent of inputChar.
            }
            System.out.print("\n");

        } catch (Exception e) {
            System.err.println(e.toString());
        }


    }

    /**
     * Access a  user-specified file in the current directory.
     * @param fileName The file to be accessed.
     * @throws FileNotFoundException This is thrown if the file cannot be found in the current directory.
     */
    public void encodeFile(String fileName) throws FileNotFoundException {

        try (Scanner sc = new Scanner(new FileInputStream(fileName))) {

            while (sc.hasNextLine()) {
                encodeString(sc.nextLine());

            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("Failed to open file: " + Paths.get(fileName));

        } catch (Exception e) {
            System.err.println(e.toString());

        }

    }

}

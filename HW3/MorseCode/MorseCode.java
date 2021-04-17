/**
 * A custom exception to be thrown when the proper Morse Code criteria are not met.
 */
class MorseCriteriaException extends Exception {
    public MorseCriteriaException(String msg){

        super(msg);
    }
}

/**
 * A class that stores a character and its equivalent Morse Code encoding sequence consisting of dashes(-) and dots(.) .
 * @author Orestis Stefanis
 */
public class MorseCode {

    /**
     * A character that is a number, letter, or symbol with a Morse Code representation.
     */
    private char character;
    /**
     * A String that stores a Morse Code representation of a character.
     */
    private String encoding;

    /**
     * Non-Default Constructor for MorseCode class.
     * @param character A char between ASIC values of  (32 <= character <= 90) associated with the Morse Code encoding.
     * @param encoding The Morse Code encoding, which cannot be a String that is null or less than length = 1, associated to a character.
     * @throws MorseCriteriaException If the conditions about the ASIC values or the encoding string are not met
     */
    public MorseCode(char character, String encoding) throws MorseCriteriaException {

        if (character > 90 || character <= 31) {

            throw new MorseCriteriaException("The character << " + character + " >> is not a supported Morse character");

        }else if (encoding == null && encoding.length() <1) {

            throw new MorseCriteriaException("The character << " + character + " >> is not a supported Morse character");

        } else {

            setCharacter(character);
            setEncoding(encoding);
        }
    }

    /**
     *
     * @param character The letter/symbol/number equivalent of the Morse Code encoding.
     */
    private void setCharacter(char character) {

        this.character = character;
    }

    /**
     *
     * @param encoding The Morse Code encoding equivalent to the associated character.
     */
    private void setEncoding(String encoding) {

        this.encoding = encoding;
    }

    /**
     *
     * @return The character stored into the MorseCode object.
     */
    public char getCharacter() {

        return this.character;
    }

    /**
     *
     * @return The encoding stored into the MorseCode object.
     */
    public String getEncoding() {

        return this.encoding;
    }
}

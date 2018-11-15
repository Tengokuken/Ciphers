package cipher;

/**
 * Encode and decode strings using the Vigenere Cipher.
 * 
 * @author Johnson Zhong
 *
 */
public class VigenereCipher extends Cipher {

  /**
   * Default constructor.
   */
  public VigenereCipher() {
    super("", "", "", "");
  }

  public VigenereCipher(String type, String shift, String plainText,
      String encodedText) {
    super(type, shift, plainText, encodedText);
  }

  @Override
  public void encode() {
    String text = "";
    int shiftLoc = 0;
    // Loop through the input string
    for (int i = 0; i < this.plainText.length(); i++) {
      // Skip the char if it is a space.
      if (this.plainText.charAt(i) != ' ') {
        // Check if the shift word reached the end of the string
        if (shiftLoc == ((String) this.shift).length())
          shiftLoc = 1;
        else
          shiftLoc++;
        int shiftChar = -1;
        // Get the numerical value of the character
        for (int j = 0; j < letters.length && (shiftChar == -1); j++) {
          // If the current character in the shift is a space, don't shift
          if ((((String) this.shift).charAt(shiftLoc - 1)) == ' ')
            shiftChar = 0;
          else if (letters[j] == (((String) this.shift).charAt(shiftLoc - 1)))
            // The plaintext will shift this much.
            // Add one becuase array starts counting at 0.
            shiftChar = j + 1;
        }
        // Convert the corresponding letter in <input> to its integer form using
        // <letters>
        int convertedChar = -1;
        // Get the integer form of the current letter
        for (int j = 0; j < letters.length && (convertedChar == -1); j++) {
          if (letters[j] == this.plainText.charAt(i))
            convertedChar = j;
        }
        convertedChar = (convertedChar + shiftChar) % 26;
        char encodedChar = letters[convertedChar];
        // Add the encoded character to a new string.
        text += encodedChar;
      } else
        // Add a space if a space character was found
        text += " ";
    }
    this.encodedText = text;
  }

  @Override
  public void decode() {
    String text = "";
    int shiftLoc = 0;
    // Loop through the input string
    for (int i = 0; i < this.encodedText.length(); i++) {
      // Skip the char if it is a space.
      if (this.encodedText.charAt(i) != ' ') {
        int shiftAmount = -1;
        // Check if the shift word reached the end of the string
        if (shiftLoc == ((String) this.shift).length())
          shiftLoc = 1;
        else
          shiftLoc++;
        // Get the numerical value of the character
        for (int j = 0; j < letters.length && (shiftAmount == -1); j++) {
          // If the current character in the shift is a space, don't shift
          if ((((String) this.shift).charAt(shiftLoc - 1)) == ' ')
            shiftAmount = 0;
          else if (letters[j] == ((String) this.shift).charAt(shiftLoc - 1))
            // Add one, since counting starts at 0
            shiftAmount = j + 1;
        }
        // Convert each letter in <input> to its integer form
        int convertedChar = -1;
        for (int k = 0; k < letters.length && (convertedChar == -1); k++) {
          if (letters[k] == this.encodedText.charAt(i))
            convertedChar = k;
        }
        // Subtract <shiftAmount> frome the <convertedChar>
        convertedChar = convertedChar - shiftAmount;
        // Check the sign of <convertedChar> is negative
        if (convertedChar < 0) {
          // Go backward from the end of the alphabet
          convertedChar = letters.length + convertedChar;
        }
        // and convert it back to a char
        char encodedChar = letters[convertedChar];
        // Add the encoded character to a new string.
        text += encodedChar;
      } else
        // Add the space
        text += " ";
    }
    this.plainText = text;
  }
}

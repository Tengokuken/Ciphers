package cipher;

/**
 * Encode and decode strings using the Caesar Cipher.
 * 
 * @author Johnson Zhong
 *
 */
public class CaesarCipher extends Cipher {
  /**
   * Default constructor.
   */
  public CaesarCipher() {
    super("", 0, "", "");
  }

  /**
   * Constructor for Caesar Cipher
   * 
   * @param type Type of ciphering
   * @param shift Shift value for the cipher
   * @param plainText Plaintext string
   * @param encodedText Encoded text string
   */
  public CaesarCipher(String type, int shift, String plainText,
      String encodedText) {
    super(type, shift, plainText, encodedText);
  }

  @Override
  public void encode() {
    String text = "";
    // Loop through the input string
    for (int i = 0; i < this.plainText.length(); i++) {
      // Skip the char if it is a space.
      if (this.plainText.charAt(i) != ' ') {
        // Convert each letter in <input> to its integer form using <letters>
        int convertedChar = -1;
        // Get the integer form of the current letter
        for (int j = 0; j < letters.length && (convertedChar == -1); j++) {
          if (letters[j] == this.plainText.charAt(i))
            convertedChar = j;
        }
        // Add <shift> to the <convertedChar> and convert it back to the
        // corresponding letter
        convertedChar =
            (convertedChar + Integer.parseInt((String) this.shift)) % 26;
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
    // Loop through the input string
    for (int i = 0; i < this.encodedText.length(); i++) {
      // Skip the char if it is a space.
      if (this.encodedText.charAt(i) != ' ') {
        // Convert each letter in <input> to its integer form
        int convertedChar = -1;
        for (int k = 0; k < letters.length && (convertedChar == -1); k++) {
          if (letters[k] == this.encodedText.charAt(i))
            convertedChar = k;
        }
        // Subtract <shift> from the <convertedChar> to get a number between
        // 0 and 25 inclusive.
        convertedChar =
            (convertedChar - Integer.parseInt((String) this.shift)) % 26;
        // Check the sign of <convertedChar> is negative
        if (convertedChar < 0) {
          // Go backward from the end of the alphabet
          convertedChar = letters.length + convertedChar;
        }
        // and convert it back to a char
        char decodedChar = letters[convertedChar];
        // Add the encoded character to a new string.
        text += decodedChar;
      } else
        // Add a space if a space character was found
        text += " ";
    }
    this.plainText = text;
  }
}

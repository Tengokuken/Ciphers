package cipher;

//TODO: Javadocs, clean up code
public class VigenereCipher extends Cipher {
  
  /**
   * Default constructor for Vigenere Cipher
   */
  public VigenereCipher() {
    super("", "", "", "");
  }
  
  public VigenereCipher(String type, String shift, String plainText, String encodedText) {
    super(type, shift, plainText, encodedText);
  }

  @Override
  public void encode() {
    String text = "";
    // Loop through the input string
    for (int i = 0; i < this.plainText.length(); i++) {
      int shiftLoc = i;
      int shiftChar = -1;
      // Get the numerical value of the character
      for (int j = 0; j < letters.length && (shiftChar == -1); j++) {
        if (letters[j] == (((String) this.shift).charAt(shiftLoc)))
          shiftChar = j;
      }
      // Convert each letter in <input> to its integer form using <letters>
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
    }
    this.encodedText = text;
  }

  @Override
  public void decode() {
    String text = "";
    // Loop through the input string
    for (int i = 0; i < this.encodedText.length(); i++) {
      int shiftAmount = -1;
      int shiftLoc = i;
      // Get the numerical value of the character
      for (int j = 0; j < letters.length && (shiftAmount == -1); j++) {
        if (letters[j] == ((String) this.shift).charAt(shiftLoc))
          shiftAmount = j;
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
    }
    this.plainText = text;
    
  }
}

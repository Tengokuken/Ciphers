package cipher;

/**
 * Encode and decode strings using the Caesar Cipher.
 * 
 * @author Johnson Zhong
 *
 */
public class CaesarCipher extends Cipher {
  /**
   * Input string
   */
  private String plainText;
  private String encodedText;
  private int shift;

  /**
   * Constructor for Caesar Cipher
   * 
   * @param plainText   Plaintext string
   * @param encodedText Encoded text string
   * @param shift       Shift value for the cipher
   */
  //TODO: Make a builder for the constructor, since it has optional params
  public CaesarCipher(String plainText, String encodedText, int shift) {
    this.plainText = plainText;
    this.encodedText = encodedText;
    this.shift = shift;
  }

  @Override
  public void encode() {
    String text = "";
    // Loop through the input string
    for (int i = 0; i < this.plainText.length(); i++) {
      // Convert each letter in <input> to its integer form
      int convertedChar = (int) (this.plainText.charAt(i));
      // Add <shift> to the <convertedChar> and convert it back to a char
      char encodedChar = (char) ((convertedChar + this.shift) % 26);
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
      // Convert each letter in <input> to its integer form
      int convertedChar = (int) (this.encodedText.charAt(i));
      // Add <shift> to the <convertedChar> and convert it back to a char
      char encodedChar = (char) ((convertedChar - this.shift) % 26);
      // Add the encoded character to a new string.
      text += encodedChar;
    }
    this.plainText = text;
  }

  public void setplainText(String plainText) {
    this.plainText = plainText;
  }
  
  public void setEncodedText(String encodedText) {
    this.encodedText = encodedText;
  }
  
  public String getPlainText() {
    return this.plainText;
  }
  
  public String getEncodedText() {
    return this.encodedText;
  }

  public void setShift(int shift) {
    this.shift = shift;
  }
}

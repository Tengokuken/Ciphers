package cipher;

/**
 * An abstract class that provides the backbone for ciphers.
 * 
 * @author Johnson Zhong
 *
 */
public abstract class Cipher {
  protected String plainText;
  protected String encodedText;
  protected static final char[] letters =
      {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
          'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

  public Cipher(String plainText, String encodedText) {
    this.plainText = plainText;
    this.encodedText = encodedText;
  }

  /**
   * Encodes plaintext into code
   */
  public abstract void encode();

  /**
   * Decodes code into plaintext
   */
  public abstract void decode();

  public void setplainText(String plainText) {
    this.plainText = plainText;
  }

  public void setEncodedText(String encodedText) {
    this.encodedText = encodedText;
  }

  /**
   * Returns the plaintext
   * 
   * @return Plaintext of the cipher
   */
  public String getPlainText() {
    return this.plainText;
  }

  /**
   * Returns the encoded text
   * 
   * @return Encoded text from the cipher
   */
  public String getEncodedText() {
    return this.encodedText;
  }

}

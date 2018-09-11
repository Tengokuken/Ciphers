package cipher;

/**
 * An abstract class that provides the backbone for ciphers.
 * 
 * @author Johnson Zhong
 *
 */
public abstract class Cipher {
  /**
   * Type of transformation that the cipher applies. Ie, encoding or decoding.
   */
  protected String type;
  /**
   * The current stored plaintext string of the cipher.
   */
  protected String plainText;
  /**
   * The current stored encoded string of the cipher.
   */
  protected String encodedText;
  /**
   * The shift used when encoding or decoding.
   */
  protected Object shift;
  /**
   * List of the letters used to encode or decode by the cipher in order.
   */
  protected static final char[] letters =
      {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
          'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

  /**
   * Constructor of the Cipher object.
   * 
   * @param type Type of ciphering done.
   * @param shift Shift that the cipher uses.
   * @param plainText Plaintext of the cipher.
   * @param encodedText Encoded text of the cipher.
   */
  public Cipher(String type, Object shift, String plainText,
      String encodedText) {
    this.type = type;
    this.shift = shift;
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

  /**
   * Set the cipher's type.
   * 
   * @param type String containing the cipher's type.
   */
  public void setCipherType(String type) {
    this.type = type;
  }

  /**
   * Set the shift of the cipher.
   * 
   * @param shift Shift used by the cipher.
   */
  public void setShift(Object shift) {
    this.shift = shift;
  }

  /**
   * Set the plaintext string of the cipher.
   * 
   * @param plainText Plaintext to store.
   */
  public void setPlainText(String plainText) {
    this.plainText = plainText;
  }

  /**
   * Set the encoded string of the cipher.
   * 
   * @param encodedText Encoded string to store.
   */
  public void setEncodedText(String encodedText) {
    this.encodedText = encodedText;
  }

  /**
   * Returns the plaintext stored in the cipher.
   * 
   * @return Plaintext of the cipher
   */
  public String getPlainText() {
    return this.plainText;
  }

  /**
   * Returns the encoded string stored in the cipher.
   * 
   * @return Encoded text from the cipher
   */
  public String getEncodedText() {
    return this.encodedText;
  }

  /**
   * Returns the type of ciphering that this cipher will do (encode or decode)
   * 
   * @return Type of the cipher
   */
  public String getCipherType() {
    return this.type;
  }
}

package cipher;

/**
 * An abstract class that provides the backbone for ciphers.
 * 
 * @author Johnson Zhong
 *
 */
public abstract class Cipher {
  protected String type;
  protected String plainText;
  protected String encodedText;
  protected Object shift;
  protected static final char[] letters =
      {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
          'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

  //TODO: Make a builder for the constructor, since it has optional params
  public Cipher(String type, Object shift, String plainText, String encodedText) {
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
  
  public void setCipherType(String type) {
    this.type = type;
  }
  
  public void setShift(Object shift) {
    this.shift = shift;
  }

  public void setPlainText(String plainText) {
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
  
  /**
   * Returns the type of ciphering that this cipher will do (encode or decode)
   * 
   * @return Type of the cipher
   */
  public String getCipherType() {
    return this.type;
  }

}

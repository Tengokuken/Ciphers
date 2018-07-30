package cipher;

/**
 * An abstract class that provides the backbone for ciphers.
 * 
 * @author Johnson Zhong
 *
 */
public abstract class Cipher {
  /**
   * Encodes plaintext into code
   */
  public abstract void encode();

  /**
   * Decodes code into plaintext
   */
  public abstract void decode();

  /**
   * Returns the plaintext
   * @return Plaintext of the cipher
   */
  public abstract String getPlainText();

  /**
   * Returns the encoded text
   * @return Encoded text from the cipher
   */
  public abstract String getEncodedText();
}

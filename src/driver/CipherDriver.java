package driver;

import cipher.*;

/**
 * Driver for the ciphers.
 * 
 * @author Johnson Zhong
 *
 */
public class CipherDriver {

  /**
   * Runs the cipher driver.
   * 
   * @param args[] command line parameters
   */
  public static void main(String[] args) {
    // TODO: error-checking
    CipherTable.initializeCiphers();
    StdIn stdIn = new StdIn();
    // Contains [cipher, type, shift, text]
    String[] input = stdIn.getInput();
    // Check if the cipher was already created
    if (ExistingCiphers.getCipher(input[0]) == null) {
      Object desiredCipher = CipherTable.getCipher(input[0]);
      if (desiredCipher != null) {
        // save the cipher
        ExistingCiphers.addCipher(input[0], desiredCipher);
        CipherDriver.runCipher(input);
      } else {
        // It no exist so do error
      }
    } else {
      // Run the cipher
      CipherDriver.runCipher(input);
    }
  }

  /**
   * Sets the input parameters into the fields of the desired cipher and runs
   * the cipher.
   * 
   * @param input The input parameters for the cipher.
   */
  public static void runCipher(String[] input) {
    String cipher = input[0];
    String type = input[1];
    String shift = input[2];
    String text = input[3];
    Cipher cipherInUse = (Cipher) ExistingCiphers.getCipher(cipher);
    // Update the cipher fields
    cipherInUse.setCipherType(type);
    cipherInUse.setShift(shift);
    // Check if we are encoding or decoding
    if (type.equals("encode")) {
      cipherInUse.setPlainText(text);
      cipherInUse.encode();
      StdOut.displayTextOnScreen(
          "Your encoded text: " + cipherInUse.getEncodedText());
    } else if (type.equals("decode")) {
      cipherInUse.setEncodedText(text);
      cipherInUse.decode();
      StdOut.displayTextOnScreen(
          "Your decoded text: " + cipherInUse.getPlainText());
    }
  }
}

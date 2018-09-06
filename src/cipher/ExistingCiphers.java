package cipher;

import java.util.Hashtable;

/**
 * A class that stores all the currently existing ciphers.
 * 
 * @author Johnson Zhong
 *
 */
public class ExistingCiphers {
  /**
   * Contains the existing ciphers.
   */
  public static Hashtable<String, Object> existingTable =
      new Hashtable<String, Object>();

  /**
   * Add a cipher object to the table
   * 
   * @param cipher String representation of the cipher
   * @param instance An instance of the cipher
   */
  public static void addCipher(String cipher, Object instance) {
    existingTable.put(cipher, instance);
  }

  /**
   * Parses the user input to determine which cipher should be called.
   * 
   * @param cipher the cipher to be returned
   * @return Object if a valid cipher is provided
   */
  public static Object getCipher(String cipher) {
    // Get the class that is being called by the input
    return existingTable.get(cipher);
  }
}

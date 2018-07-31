package cipher;
import java.util.Hashtable;

public class CipherTable {
  public static Hashtable<String, String> cipherTable = new 
      Hashtable<String, String>();

  /**
   * Initializes the cipher table
   */
  public static void initializeCiphers() 
  {
    cipherTable.put("caesar", "CaesarCipher");
    cipherTable.put("vigenere", "VigenereCipher");
  }
  
  /**
   * Parses the user input to determine which cipher should be called.
   * 
   * @param inCipher the cipher to be returned
   * @return cipherInstance if a valid inCommand is provided
   */
  public static Object getCipher(String inCipher) {
    // Get the class that is being called by the input
    Object cipherInstance;
    try {
        String className = cipherTable.get(inCipher);
        Class cipherClass = Class.forName("cipher." + className);

        try {
          cipherInstance = (Object)cipherClass.newInstance();
        } 
        catch (InstantiationException e) {
          return null;
        } 
        catch (IllegalAccessException e) {
          return null;
        }
    } 
    catch (ClassNotFoundException e) {
        return null;
    }
    
    // Return an instance of the class
    return cipherInstance;
  }
}

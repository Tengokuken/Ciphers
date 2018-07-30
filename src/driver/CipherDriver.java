package driver;

import java.util.Scanner;
import cipher.*;

public class CipherDriver {

  public static void main(String[] args) {
    // TODO: Singleton design, error-checking
    CipherTable.initializeCiphers();
    String cipher, type;
    int shift;
    Scanner in = new Scanner(System.in);
    System.out.print("Select your cipher: ");
    cipher = in.nextLine();
    cipher = cipher.trim();
    /*
     * // Check if the cipher was already created if
     * (ExistingCiphers.getCipher(input) == null) { // Determine the specified
     * cipher Object desiredCipher = CipherTable.getCipher(input); // If the
     * desired command doesn't exist if (desiredCipher != null) { // Save the
     * object ExistingCiphers.addCipher(input, desiredCipher); // Execute the
     * command } else { System.out.println("No"); } }
     */

    System.out.print("How much do you want to shift your input? ");
    shift = Integer.parseInt(in.nextLine());
    CaesarCipher caesar = new CaesarCipher("", "", shift);
    // TODO: Check if shift is a number
    System.out.print("Do you want to encode or decode? ");
    type = in.nextLine();
    if (type.equals("encode")) {
      System.out.print("Enter your text to encode: ");
      String text = in.nextLine();
      caesar.setplainText(text);
      caesar.encode();
      System.out.println("Your encoded text: " + caesar.getEncodedText());
    } else if (type.equals("decode")) {
      System.out.print("Enter your text to decode: ");
      String text = in.nextLine();
      caesar.setEncodedText(text);
      caesar.decode();
      System.out.println("Your decoded text: " + caesar.getPlainText());
    } else {
      // Give an error
    }
  }

}

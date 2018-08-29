package driver;

import java.util.Scanner;
import cipher.*;

public class CipherDriver {

  public static void main(String[] args) {
    // TODO: Singleton design, error-checking
    CipherTable.initializeCiphers();
    String cipher, type;
    // int shift;
    String shift;
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
    // Create the Vigenere cipher with default parameters
    VigenereCipher vigenere = new VigenereCipher("", "", "");
    // Create the Caesar cipher with default parameters
    //CaesarCipher caesar = new CaesarCipher("", "", 0);
    System.out.print("How much do you want to shift your input? ");
    //shift = Integer.parseInt(in.nextLine());
    shift = in.nextLine();
    // TODO: Check if shift is a number
    // TODO: Change this so shift comes after this. Requires big refactoring
    System.out.print("Do you want to encode or decode? ");
    type = in.nextLine();
    if (type.equals("encode")) {
      /*
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
     */
      System.out.print("Enter your text to encode: ");
      String text = in.nextLine();
      vigenere.setplainText(text);
      vigenere.encode();
      System.out.println("Your encoded text: " + vigenere.getEncodedText());
    } else if (type.equals("decode")) {
      System.out.print("Enter your text to decode: ");
      String text = in.nextLine();
      /*
      caesar.setEncodedText(text);
      caesar.decode();
      System.out.println("Your decoded text: " + caesar.getPlainText());
      */
      vigenere.setEncodedText(text);
      vigenere.decode();
      System.out.println("Your decoded text: " + vigenere.getPlainText());
    } else {
      // Give an error
    }
  }

}

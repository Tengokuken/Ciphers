package driver;

import java.util.Scanner;
import cipher.CipherTable;

/**
 * Class that receives input for ciphers.
 * 
 * @author Johnson Zhong
 *
 */
public class StdIn {

  /**
   * Gets the file name from standard input.
   * 
   * @return fileContents The contents of the text file.
   */
  public String[] getInput() {
    // Get the input from the user and store them.
    String[] cipherDetails = new String[4];
    String input;
    int counter = 0;
    String text;
    boolean validInput = true;
    Scanner in = new Scanner(System.in);
    while(counter < 4) {
      // Check what input we are collecting
      switch(counter) {
        case 0:
          text = "Select your cipher: ";
          break;
        case 1:
          text = "Do you want to encode or decode: ";
          break;
        case 2:
          text = "How much do you want shift your input: ";
          break;
        case 3:
          if (cipherDetails[1].equals("encode"))
            text = "Enter your text to encode: ";
          else if (cipherDetails[1].equals("decode"))
            text = "Enter your text to decode: ";
          else
            text = "lol";
          break;
        default:
          text = "Lol you shouldn't be here";
          break;
      }
      // Display the text to the user
      StdOut.displayTextOnScreen(text);
      cipherDetails[counter] = in.nextLine().trim();
      // Check if the input is valid
      validInput = CheckInput.validateField(cipherDetails, counter);
      if (validInput) {
        // Collect their input and increment the counter
        counter++;
      } else {
        // Return an error, make them do the thing again
        StdOut.displayTextOnScreen("Your input was invalid. Please try again.");
      }
    }
    return cipherDetails;
  }
  private static class CheckInput {
    public static boolean validateField(String[] input, int stage) {
      boolean result = true;
      switch (stage) {
        // Check if the cipher exists in the table of valid ciphers
        case 0:
          if (CipherTable.getCipher(input[stage]) == null)
            result = false;
          break;
        // Check if the cipher type is valid
        case 1:
          if (!(input[stage].equals("encode") || input[stage].equals("Encode")
              || input[stage].equals("decode") || input[stage].equals("Decode")))
            result = false;
          break;
        // Check the shift
        case 2:
          // Check the cipher. Caesar ciphers use nunber bastly ed shifts,
          // everything else uses a cipher string.
          if (input[0].equals("caesar") || input[0].equals("Caesar")) {
            // Check that the type contains only numbers
            if (!(input[stage].matches("[0-9]+")))
              result = false;
          } else {
            // Chexk that the type contains only letters
            if (!(input[stage].matches("[A-Za-z ]+")))
              result = false;
          }
        break;
        // Check the text.
        case 3:
          // Check that the input consists of strictly alphabets 
          if (!(input[stage].matches("[A-Za-z ]+")))
            result = false;
      }
      return result;
    }
  }
}

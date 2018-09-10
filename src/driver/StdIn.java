package driver;

import java.util.Scanner;

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
    // TODO: Error checking, if you get invalid fields it does weird stuff
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
      input = in.nextLine().trim();
      // Check if the input is valid
      validInput = CheckInput.validateField(input, counter);
      if (validInput) {
        // Collect their input and increment the counter
        cipherDetails[counter] = input;
        counter++;
      } else {
        // Return an error, make them do the thing again
      }
    }
    return cipherDetails;
  }
  private static class CheckInput {
    public static boolean validateField(String input, int stage) {
      return true;
    }
  }
}

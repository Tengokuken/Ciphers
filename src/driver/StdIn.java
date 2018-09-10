package driver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Class that receives input.
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
    String cipher, type, shift, text;
    Scanner in = new Scanner(System.in);
    StdOut.displayTextOnScreen("Select your cipher: ");
    cipher = in.nextLine().trim();
    StdOut.displayTextOnScreen("Do you want to encode or decode: ");
    type = in.nextLine().trim();
    StdOut.displayTextOnScreen("How do you want to shift your input? ");
    shift = in.nextLine().trim();
    if (type.equals("encode")) {
      StdOut.displayTextOnScreen("Enter your text to encode: ");
      text = in.nextLine().trim();
    } else if (type.equals("decode")) {
      StdOut.displayTextOnScreen("Enter your text to decode: ");
      text = in.nextLine().trim();
    } else {
      text = "";
      // TODO: Something else
    }
    String[] input = new String[] {cipher, type, shift, text};
    return input;
  }
}

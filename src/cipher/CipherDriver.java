package cipher;

import java.util.Scanner;

public class CipherDriver {

  public static void main(String[] args) {
    // TODO: Singleton design, error-checking
    String type;
    CaesarCipher cipher = new CaesarCipher("", "", 0);
    Scanner in = new Scanner(System.in);
    System.out.println("Do you want to encode or decode? ");
    type = in.nextLine();
    if (type.equals("encode")) {
    } else if (type.equals("decode")) {
      
    } else {
      // Give error
    }
  }
}

package cipher;

public class VigenereCipher extends Cipher{

  private String shift;
  
  public VigenereCipher(String plainText, String encodedText, String shift) {
    super(plainText, encodedText);
    this.shift = shift;
    // TODO Auto-generated constructor stub
  }

  @Override
  public void encode() {
    // TODO Auto-generated method stub
  }

  @Override
  public void decode() {
    // TODO Auto-generated method stub
    
  }
  public void setShift(String shift) {
    this.shift = shift;
  }
}

package test;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import cipher.CaesarCipher;

/**
 * Test case suite for CaesarCipher.
 * 
 * @author Johnson Zhong
 *
 */
public class CaesarCipherTest {
  /**
   * Instance of CaesarCipher
   */
  private CaesarCipher ccObj;
  /**
   * Compares results
   */
  private String expected, actual;
  /**
   * Checks if an exception was raised during testing
   */
  private boolean error;

  /**
   * Set up variables for testing
   */
  @Before
  public void SetUp() {
    ccObj = new CaesarCipher();
    expected = actual = "";
    error = false;
  }

  /**
   * Clean up variables after testing
   */
  @After
  public void CleanUp() {
    ccObj = null;
    error = false;
  }

  /**
   * Test standard encoding
   */
  @Test
  public void testStandardEncode() {
    ccObj.setCipherType("encode");
    ccObj.setShift("3");
    ccObj.setPlainText("dog");
    ccObj.encode();
    expected = "grj";
    actual = ccObj.getEncodedText();
    assertEquals(expected, actual);
  }

  /**
   * Test encoding when shift causes a letter to wrap back
   */
  @Test
  public void testEncodeOverflowShift() {
    ccObj.setCipherType("encode");
    ccObj.setShift("5");
    ccObj.setPlainText("xyz");
    ccObj.encode();
    expected = "cde";
    actual = ccObj.getEncodedText();
    assertEquals(expected, actual);
  }

  /**
   * Test encoding with a shift greater than 26
   */
  @Test
  public void testEncodeBigShift() {
    ccObj.setCipherType("encode");
    ccObj.setShift("29");
    ccObj.setPlainText("dog");
    ccObj.encode();
    expected = "grj";
    actual = ccObj.getEncodedText();
    assertEquals(expected, actual);
  }
  
  /**
   * Test standard decode
   */
  @Test
  public void testStandardDecode() {
    ccObj.setCipherType("decode");
    ccObj.setShift("3");
    ccObj.setEncodedText("gde");
    ccObj.decode();
    expected = "dab";
    actual = ccObj.getPlainText();
    assertEquals(expected, actual);
  }
  
  /**
   * Test decoding when shift causes a letter to wrap back
   */
  @Test
  public void testDecodeOverflowShift() {
    ccObj.setCipherType("decode");
    ccObj.setShift("7");
    ccObj.setEncodedText("abc");
    ccObj.decode();
    expected = "tuv";
    actual = ccObj.getPlainText();
    assertEquals(expected, actual);
  }

  /**
   * Test encoding with a shift greater than 26
   */
  @Test
  public void testDecodeBigShift() {
    ccObj.setCipherType("decode");
    ccObj.setShift("29");
    ccObj.setEncodedText("dog");
    ccObj.decode();
    expected = "ald";
    actual = ccObj.getPlainText();
    assertEquals(expected, actual);
  }
}

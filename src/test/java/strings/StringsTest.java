package strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringsTest {

  public Strings strings;

  @BeforeEach
     	public void setup() {
    strings = new Strings();
  }

  @Test
  public void testCompareTo() {
    // See comment on the method under test about problems using compareTo()
    assertTrue(
        strings.useCompareTo("word", "world") < 0); // Negative since 4th character d comes before l
    assertTrue(strings.useCompareTo("six", "Zero") > 0); // Positive since Unicode s comes after Z
    assertTrue(strings.useCompareTo("six", "six") == 0);
  }

  /**
   * When comparing against a string literal, put the literal first. Then, even if the
   * string variable is null,  it will still work correctly.
   */
  @Test
  public void testEquals() {
    String str = "Hello";
    assertTrue("Hello".equals(str));
    str = "hi";
    assertFalse("Hello".equals(str));
  }

  @Test
  public void conversionBetweenStringsAndNumbers() {
    assertEquals("42", Integer.toString(42));
    assertEquals(42, Integer.parseInt("42"));
    assertEquals("3.14", Double.toString(3.14));
    assertEquals(3.14, Double.parseDouble("3.14"), 0.1);
  }

  @Test
  public void formattedStrings() {
    System.out.printf("%8.2f", 1000.0 / 3.0); // Field width of 8, 2 digits precision

    // Create a formatted string without printing it
    String msg = strings.formatString("Hi, %s, next year you'll be %d.\n", "Helen", 42);
    assertEquals("Hi, Helen, next year you'll be 42.\n", msg);
  }

  @Test
  public void join() {
    String[] months = {"Jan", "Feb", "Mar"};
    assertEquals("Jan|Feb|Mar", strings.join("|", months));
  }

  @Test
  public void split() {
    String[] months = {"Jan", "Feb", "Mar"};
    String regexDelimiter =
        "\\|"; // Note Java splits based on regex, so escape pipe so it isn't interpreted as an OR
    assertArrayEquals(months, strings.split(regexDelimiter, "Jan|Feb|Mar"));
  }

  @Test
  public void stringBuilder() {
    String[] months = {"Jan", "|", "Feb", "|", "Mar"};
    assertEquals("Jan|Feb|Mar", strings.stringBuilder(months));
  }

}

package strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringsTest {

  private Strings strings;

  @BeforeEach
  void setup() {
    strings = new Strings();
  }

  @Test
  void testCompareTo() {
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
  void testEquals() {
    String str = "Hello";
    assertTrue("Hello".equals(str));
    str = "hi";
    assertFalse("Hello".equals(str));
  }

  @Test
  void conversionBetweenStringsAndNumbers() {
    assertEquals("42", Integer.toString(42));
    assertEquals(42, Integer.parseInt("42"));
    assertEquals("1.23", Double.toString(1.23));
    assertEquals(1.23, Double.parseDouble("1.23"), 0.1);
  }

  @Test
  void formattedStrings() {
    System.out.printf("%8.2f", 1000.0 / 3.0); // Field width of 8, 2 digits precision

    // Create a formatted string without printing it
    String msg = strings.formatString("Hi, %s, next year you'll be %d.\n", "Helen", 42);
    assertEquals("Hi, Helen, next year you'll be 42.\n", msg);
  }

  @Test
  void join() {
    String[] months = {"Jan", "Feb", "Mar"};
    assertEquals("Jan|Feb|Mar", strings.join("|", months));
  }

  @Test
  void split() {
    String[] months = {"Jan", "Feb", "Mar"};
    String regexDelimiter =
        "\\|"; // Note Java splits based on regex, so escape pipe so it isn't interpreted as an OR
    assertArrayEquals(months, strings.split(regexDelimiter, "Jan|Feb|Mar"));
  }

  @Test
  void stringBuilder() {
    String[] months = {"Jan", "|", "Feb", "|", "Mar"};
    assertEquals("Jan|Feb|Mar", strings.stringBuilder(months));
  }

  @Test
  void unicodeCharacter() {
    // We can get this from going to https://unicode-table.com/en/
    // and finding that the copyright symbol is in row 'A' and column '9'
    String copyright2020 = strings.returnUnicodeCopyrightSymbol();
    assertEquals("\u00A9 2020", copyright2020);
  }

}

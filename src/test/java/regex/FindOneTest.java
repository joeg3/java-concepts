package regex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class FindOneTest {

  // For regex, a character denotes itself unless its one of the reserved characters: . * + ? { | ( ) [ \ ^ $

  @Test
  void testReplaceCharacter() {
    String str = "Moo";
    String newStr = str.replaceAll("M", "B");
    assertEquals("Boo", newStr);
  }

  @Test
  void periodMatchesAnyCharacter() {
    String str = "Moo";
    String newStr = str.replaceAll(".", "B");
    assertEquals("BBB", newStr);
  }

  @Test
  void characterClasses() {
    // The \w character class matches a single one of characters: A-Z,a-z,0-9,_
    // Since we want to match on more than one character, we use the + quantifier to match on one or more
    String str1 = "Rochester, MN";
    String str2 = "Lakeville, MN";
    assertTrue(str1.matches("\\w+, MN"));
    assertTrue(str2.matches("\\w+, MN"));

    // The \s character class matches all whitespace
    String str3 = "Replace all spaces with underscores.";
    assertEquals("Replace_all_spaces_with_underscores.", str3.replaceAll("\\s", "_"));
  }

  @Test
  void patternAndMatcherClasses() {
    String str1 = "TX, MN, CA, MN, WI, MT";

    // Use the Pattern class
    String regex = ".*MN.*";
    assertTrue(Pattern.matches(regex, str1));

    // Compile the regex if used many times
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(str1);
    assertTrue(matcher.matches());
  }

  @Test
  void caratMatchesStartOfLine() {
    String str = "MooBaaMooOink";

    // Only replace first occurrence of "Moo" because of ^
    String newStr = str.replaceAll("^Moo", "Cluck");
    assertEquals("CluckBaaMooOink", newStr);

    // No replacement, "Baa" not at beginning of string
    newStr = str.replaceAll("^Baa", "Cluck");
    assertEquals("MooBaaMooOink", newStr);
  }

  @Test
  void dollarMatchesEndOfLine() {
    String str = "MooOinkBaaOink";

    // Only replace last occurrence of "Oink" because of $
    String newStr = str.replaceAll("Oink$", "Cluck");
    assertEquals("MooOinkBaaCluck", newStr);

    // No replacement, "Baa" not at beginning of string
    newStr = str.replaceAll("Baa$", "Cluck");
    assertEquals("MooOinkBaaOink", newStr);
  }

  @Test
  void squareBracketsMatchAllOccurrences() {
    String str = "abcdefghijk";

    // Match and replace on any character from character class [adi]
    String newStr = str.replaceAll("[adi]", "x");
    assertEquals("xbcxefghxjk", newStr);

    // Match and replace on first character class [adi] followed by second [e]
    newStr = str.replaceAll("[adi][e]", "x");
    // Only one character matches any of [adi] followed by one of [e], note both d and e match are are replaced by x
    assertEquals("abcxfghijk", newStr);

    // Uppercase first letter
    newStr = "joe,Joe,joe".replaceAll("[Jj]oe", "Joe");
    assertEquals("Joe,Joe,Joe", newStr);

    newStr = str.replaceAll("[^bg]", "x");
    // The carat within a character class negates the pattern so for b and g it doesn't replace
    assertEquals("xbxxxxgxxxx", newStr);

    newStr = str.replaceAll("[ac-fh-k]", "x");
    // Same thing by specifying a range of characters to match
    assertEquals("xbxxxxgxxxx", newStr);

    newStr = "abcDefghiJk".replaceAll("(?i)[ac-fh-k]", "x");
    // Use (?i) to ignore case for ascii. For Unicode, use (?iu)
    assertEquals("xbxxxxgxxxx", newStr);

    newStr = "abcDefghiJk12345".replaceAll("[0-9]", "x");
    // Replace all digits using a character class
    assertEquals("abcDefghiJkxxxxx", newStr);

    newStr = "abcDefghiJk12345".replaceAll("\\d", "x");
    // Can also use slash d character class (we have to escape the backslash)
    assertEquals("abcDefghiJkxxxxx", newStr);

    newStr = "ab%cD12345".replaceAll("\\D", "x");
    // \D replaces all non digits
    assertEquals("xxxxx12345", newStr);

    newStr = "a_bc@123".replaceAll("\\w", "x");
    // Replace all upper and lower case characters, digits, and underscore with uppercase \w
    assertEquals("xxxx@xxx", newStr);
  }

  @Test
  void booleanMatchesMethod() {
    String str = "MooBaaOink";
    assertFalse(str.matches("^Moo")); // matches() expects entire string to match
    assertTrue(str.matches("^MooBaaOink"));
    assertTrue(str.matches("MooBaaOink"));
  }

  @Test
  void whitespace() {
    String str = "The quick brown \t fox\n";
    String newStr = str.replaceAll("\\s", "");
    assertEquals("Thequickbrownfox", newStr);

    // Can also just replace specific whitespace characters
    newStr = str.replaceAll("\t", "");
    assertEquals("The quick brown  fox\n", newStr);

    // Replace all non-whitespace characters
    newStr = str.replaceAll("\\S", "");
    assertEquals("   \t \n", newStr);

    // Match on word boundary, useful for replacing some type of tag
    newStr = str.replaceAll("\\b", "x");
    assertEquals("xThex xquickx xbrownx \t xfoxx\n", newStr);
  }

  @Test
  void quantifiers() {
    String str = "abcdeeefg";

    // The number in curly braces is the number of the preceding character that must occur for a match
    String newStr = str.replaceAll("e{3}", "e");
    assertEquals("abcdefg", newStr);

    // Matches if between 2-5 e's
    newStr = str.replaceAll("e{2,5}", "e");
    assertEquals("abcdefg", newStr);

    // Use + to match on one or more of preceding character
    newStr = str.replaceAll("e+", "x");
    assertEquals("abcdxfg", newStr);

    // Use * to match on zero or more of preceding character
    newStr = str.replaceAll("^abcx*", "!");
    assertEquals("!deeefg", newStr);

    // Match on d, followed by one or more e, followed by zero or more z's
    newStr = str.replaceAll("de+z*", "x");
    assertEquals("abcxfg", newStr);
  }

  @Test
  void logicalOperators() {
    // AND
    // We are already using implicit AND operator
    // "abc" means "a" and "b" and "c", or "a" followed by "b" followed by "c"

    // OR
    // Use square brackets [Jj]oe is "J" or "j"
    // Or use | character
    assertEquals("Larry", "Harry".replaceAll("[Hh]arry", "Larry"));
    assertEquals("Larry", "Harry".replaceAll("[H|h]arry", "Larry"));

    // NOT
    // [^abc] matches all characters except a, b, c
    // Can also use !
    String tTest = "tstvtkt"; // Find all t's not followed by v
    String tNotVRegEx =
        "t[^v]"; // The [^v] consumes a character, so it won't match last t, see look ahead example to not consume character
    Pattern tNotVPattern = Pattern.compile(tNotVRegEx);
    Matcher tNotVMatcher = tNotVPattern.matcher(tTest);

    int count = 0;
    while (tNotVMatcher.find()) {
      count++;
      System.out.println(
          "Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
    }
    assertEquals(2, count);
  }

    @Test
    void lookAheadOperator() {
      String tTest = "tstvtkt"; // Find all t's not followed by v
      String tNotVRegEx = "t(?!v)"; // The (?!v) doesn't consume a character, just looks ahead to check !v, so will match last t
      // String tNotVRegEx = "t(?=v)"; // Positive lookahead, use = sign to match t followed by v, and not include v in match
      Pattern tNotVPattern = Pattern.compile(tNotVRegEx);
      Matcher tNotVMatcher = tNotVPattern.matcher(tTest);

      int count = 0;
      while(tNotVMatcher.find()) {
        count++;
        System.out.println("Occurrence " + count  + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
      }
      assertEquals(3, count);
  }
}

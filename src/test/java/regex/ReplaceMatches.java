package regex;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class ReplaceMatches {

  @Test
  void replaceRegExMatches() {
    String str1 = "TX, MN, CA, MN, WI, MT";
    Pattern pattern = Pattern.compile("\\s*,\\s*");
    Matcher matcher = pattern.matcher(str1);
    String states = matcher.replaceAll("|");
    assertEquals("TX|MN|CA|MN|WI|MT", states);
  }

  @Test
  void splitWithStringReplaceAllMethod() {
    String str1 = "TX, MN, CA, MN, WI, MT";
    String states = str1.replaceAll("\\s*,\\s*", "|");
    assertEquals("TX|MN|CA|MN|WI|MT", states);
  }
}

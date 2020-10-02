package regex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FindAllTest {
  static String htmlText;

  @BeforeAll
  static void setup() {
    StringBuilder html = new StringBuilder("<h1> Heading </h1>");
    html.append("<h2>Second heading</h2>");
    html.append("<p>Second heading paragraph</p>");
    html.append("<p>Second heading paragraph</p>");
    html.append("<h2>Another heading</h2>");
    html.append("<p>Second heading paragraph</p>");
    htmlText = html.toString();
  }

  @Test
  void findAllMatches() {
    String str1 = "TX, MN, CA, MN, WI, MT";
    String regex = "M\\w+";
    Pattern pattern = Pattern.compile(regex);
    List<String> matches = pattern.matcher(str1).results().map(MatchResult::group).collect(
        Collectors.toList());
    assertEquals(3, matches.size()); // Three states start with 'M'
    assertEquals("MN", matches.get(0));
    assertEquals("MN", matches.get(1));
    assertEquals("MT", matches.get(2));
  }

  @Test
  void useMatcher() {
    // Here we are just matching, not replacing
    // Use Pattern class for more reusable patterns
    String h2Pattern = ".*<h2>.*"; // Need to have .* before and after, otherwise looks for whole string to be <h2>
    Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE); // Second arg is optional, and it could be in pattern itself
    Matcher matcher = pattern.matcher(htmlText);
    assertTrue(matcher.matches());
  }

  @Test
  void getMatchCountWithLoop() {
    String h2Pattern = "<h2>"; // Here we just want to match part of text, so remove .*
    Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(htmlText);
    matcher.matches();

    matcher.reset(); // A Matcher only matches once. It won't match in code below unless it's reset
    int count = 0;
    while(matcher.find()) {
      count++;
      System.out.println("Occurence: " + count + " : " + matcher.start() + " to " + matcher.end()); // Print start/end indexes of match
    }
    assertEquals(2, count);
  }

  @Test
  void getMatchWithGroup() {
    String h2GroupPattern = "(<h2>)"; // Add parens to regex to group
    Pattern gropuPattern = Pattern.compile(h2GroupPattern, Pattern.CASE_INSENSITIVE);
    Matcher groupMatcher = gropuPattern.matcher(htmlText);

    while(groupMatcher.find()) {
      // .group(0) is entire character sequence
      // .group(1) is our (<h2>) pattern
      System.out.println("Occurence: " + groupMatcher.group(1));
    }
  }

  @Test
  void matchAndQuantifiers() {
    String h2GroupPattern = "(<h2>.*</h2>)"; // * is a greedy quantifier, matches outermost h2's
    Pattern gropuPattern = Pattern.compile(h2GroupPattern, Pattern.CASE_INSENSITIVE);
    Matcher groupMatcher = gropuPattern.matcher(htmlText);

    int count = 0;
    while(groupMatcher.find()) {
      count++;
    }
    assertEquals(1, count);

    h2GroupPattern = "(<h2>.*?</h2>)"; // ? makes it a lazy quantifier, and matches on first </h2> occurrence
    gropuPattern = Pattern.compile(h2GroupPattern, Pattern.CASE_INSENSITIVE);
    groupMatcher = gropuPattern.matcher(htmlText);

    count = 0;
    while(groupMatcher.find()) {
      count++;
      System.out.println("Occurence: " + groupMatcher.group(1));
    }
    assertEquals(2, count);
  }

  @Test
  void extractTextBetweenTags() {
    String h2GroupPattern = "(<h2>)(.*?)(</h2>)"; // We have 3 groups denoted by parens
    Pattern gropuPattern = Pattern.compile(h2GroupPattern, Pattern.CASE_INSENSITIVE);
    Matcher groupMatcher = gropuPattern.matcher(htmlText);

    int count = 0;
    while(groupMatcher.find()) {
      count++;
      System.out.println("Occurence text between <h2> tags: " + groupMatcher.group(2)); // 0th group is entire string, and 2nd is second one is our pattern
    }
    assertEquals(2, count);
  }

}

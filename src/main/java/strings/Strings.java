package strings;

public class Strings {

  /**
   * This uses the compareTo() method which compares based on the Unicode values
   * of characters, which is not always in order for human readers. For language
   * specific sorting rules, use Collator.
   */
  public int useCompareTo(String str1, String str2) {
    return str1.compareTo(str2);
  }

  /**
   * Often, string formatting is used with System.out.printf() to send formatted string
   * to std out.  Here is an example of using String.format() to save the formatted string.
   */
  public String formatString(String str, String name, int age) {
    return String.format(str, name, age);
  }

  public String join(String delimiter, String... strings) {
    return String.join(delimiter, strings);
  }

  public String[] split(String delimiter, String str) {
    return str.split(delimiter);
  }

  public String stringBuilder(String... strings) {
    StringBuilder builder = new StringBuilder();
    for (String s : strings) {
      builder.append(s);
    }

    return builder.toString();
  }
}

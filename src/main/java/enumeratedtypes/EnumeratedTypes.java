package enumeratedtypes;

public class EnumeratedTypes {

  // Here is a typical example of using an enumerated type for related constants
  public enum Weekday { MON, TUE, WED, THU, FRI, SAT, SUN };

  // You can add constructors, methods and fields to an enumerated type:
  public enum Size {
    // Here, "S" is the argument passed to the constructor for SMALL
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;

    // Constructor of an enumeration must be private. You can omit private modifier, but would get an error if declared public or protected
    Size(String abbreviation) {
      this.abbreviation = abbreviation;
    }

    public String getAbbreviation() { return abbreviation; }
  }

  // You can add methods to each
}

package enumeratedtypes;

import static enumeratedtypes.EnumeratedTypes.Weekday;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class EnumeratedTypesTest {

  @Test
  void checkEquality() {
    Weekday wed = Weekday.WED;
    Weekday nextWed = Weekday.WED;
    Weekday fri = Weekday.FRI;

    // Each instance of an enumeration is unique, but we can check their values
    assertTrue(wed == nextWed); // Use ==
    assertTrue(wed.equals(nextWed)); // Use .equals()
    assertFalse(wed == fri);
  }

  @Test
  void getStringOfEnum() {
    String tue = Weekday.TUE.toString();
    assertEquals("TUE", tue);

    // name() does the same
    String sat = Weekday.SAT.name();
    assertEquals("SAT", sat);
  }

  @Test
  void getEnumFromString() {
    Weekday wed = Weekday.valueOf("WED");
    assertEquals(Weekday.WED, wed);
  }

  @Test
  void throwExcpetionIfNoEnumForGivenName() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> Weekday.valueOf("Typo"), "Throw exception if no value for given name");
    assertEquals("No enum constant enumeratedtypes.EnumeratedTypes.Weekday.Typo", e.getMessage());
  }

  @Test
  void getArrayOfEnumInstances() {
    Weekday[] weekdays = Weekday.values();
    assertEquals(7, weekdays.length);
    assertEquals(Weekday.THU, weekdays[3]);
    assertEquals("THU", weekdays[3].toString());
  }

  @Test
  void getArrayOfEnumValues() {
    List<String> weekdays = Stream.of(Weekday.values()).map(Weekday::name).collect(Collectors.toList());
    assertEquals(7, weekdays.size());
    assertEquals("THU", weekdays.get(3));
  }

  @Test
  void iterateThroughEnum() {
    for (Weekday w : Weekday.values()) { } // do something
  }

  @Test
  void getPositionOfEnumInstance() {
    assertEquals(4, Weekday.FRI.ordinal());
  }

  @Test
  void callEnumMethod() {
    assertEquals("XL", EnumeratedTypes.Size.EXTRA_LARGE.getAbbreviation());
  }
}

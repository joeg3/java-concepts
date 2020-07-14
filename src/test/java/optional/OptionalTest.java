package optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class OptionalTest {

  @Test
  void produceAlternativeIfValueNotPresent() {
    // Value present
    String foo = "foo";
    Optional<String> s = Optional.of(foo);
    assertEquals("foo", s.orElse(""));

    // Value not present
    foo = null;
    Optional<String> f = Optional.ofNullable(foo); // Use ofNullable() if we expect null values
    assertEquals("", f.orElse(""));

    // Invoke code to get default
    foo = null;
    Optional<String> g = Optional.ofNullable(foo);
    assertEquals("my default", f.orElseGet(() -> "my " + "default"));

    // You can also use orElseThrow() to throw an exception if no value
  }

  @Test
  void consumeValueOnlyIfPresent() {

    // The ifPresent() method accepts a function. If the optional value exists, it is passed
    // to that function, otherwise nothing happens
    String foo = "foo";
    Optional<String> str = Optional.of(foo);
    List<String> list = new ArrayList<>();
    str.ifPresent((v -> list.add(v)));
    assertEquals(1, list.size());
    // or
    str.ifPresent(list::add);
    assertEquals(2, list.size());

    // Do nothing if not present
    foo = null;
    Optional<String> nullStr = Optional.ofNullable(foo);
    nullStr.ifPresent(list::add);
    assertEquals(2, list.size());

    // Take one action if Optional has a value and another if it doesn't
    nullStr.ifPresentOrElse(
        v -> list.add(v),
        () -> list.add("no value")
    );
    assertEquals(3, list.size());
  }
}

package oo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InstanceOfTest {

  // Example of instanceof keyword
  @Test
  void instanceOfTest() {
    String str = "hi";
    assertTrue(str instanceof String);
    assertTrue(str instanceof Object);
  }

  @Test
  void instanceOfNullTest() {
    String nullStr = null;
    assertFalse(nullStr instanceof String); // instanceof is null safe

  }
}

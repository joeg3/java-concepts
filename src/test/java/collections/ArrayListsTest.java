package collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ArrayListsTest {

  @Test
  void arrayListCreation() {

    // Right side uses diamond syntax, <String> is inferred from left side
    List<String> states = new ArrayList<>();
    assertEquals(0, states.size());

    // No initializer for array lists, but you can pass in a list
    List<String> cities = new ArrayList<>(List.of("Paris", "London"));
    assertEquals(2, cities.size());
  }

  @Test
  void arrayListAddAndDelete() {

    List<String> states = new ArrayList<>();
    states.add("MN");
    states.add("CA");
    assertEquals("CA", states.get(1));
    states.set(1, "WI"); // set() replaces what was there
    assertEquals("WI", states.get(1));
    assertEquals(2, states.size());

    states.add(1, "CA"); // add() inserts value at position and moves rest of list down one
    assertEquals("CA", states.get(1));
    assertEquals("WI", states.get(2));
    assertEquals(3, states.size());

    states.remove(1);
    assertEquals(2, states.size());
    assertEquals("WI", states.get(1)); // elements after deleted element move back one

    // No initializer for array lists, but you can pass in a list
    List<String> cities = new ArrayList<>(List.of("Paris", "London"));
    assertEquals(2, cities.size());
  }

  @Test
  void arrayListPrimitiveTypes() {

    // Can't create ArrayList<int> so use Integer wrapper class
    List<Integer> ints = new ArrayList<>();
    ints.add(33);  // Can add a primitive type
    assertEquals(Integer.valueOf(33), ints.get(0)); // Converts to primitive type


    // No initializer for array lists, but you can pass in a list
    List<String> cities = new ArrayList<>(List.of("Paris", "London"));
    assertEquals(2, cities.size());
  }

}
package collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class ViewTests {

  @Test
  void createSmallSet() {
    // Using Set.of() yields a Set that is immutable.
    Set<Integer> numbers = Set.of(1, 2, 3);
    assertEquals(3, numbers.size());
    //numbers.add(4); // Would throw UnsupportedOperationException

    // Constructing set with constructor makes set mutable
    numbers = new HashSet<>(Set.of(1, 2, 3));
    assertEquals(3, numbers.size());
    numbers.add(4);
    assertEquals(4, numbers.size());
  }

  @Test
  void createSmallMap() {
    // Using Map.of() yields a Map that is immutable.
    // Elements, keys, or values may not be null
    Map<String, Integer> numbers = Map.of("Isabel", 1, "Matthew", 2);
    assertEquals(2, numbers.size());
    //numbers.add("Andrew", 3); // Would throw UnsupportedOperationException

    // Constructing map with constructor makes set mutable
    numbers = new HashMap<>(Map.of("Isabel", 1, "Matthew", 2));
    assertEquals(2, numbers.size());
    numbers.put("Andrew", 3);
    assertEquals(3, numbers.size());
  }

  @Test
  void ranges() {
    List<Integer> ints = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8,9));
    List<Integer> middle = ints.subList(2,6); // Access elements with index 2 through 5
    assertEquals(4, middle.size());
    middle.set(0, 42); // Mutation of sublist affects the original
    assertEquals(42, ints.get(2));
  }

  @Test
  void unmodifiableViews() {
    // Handy and efficient way to share a list you don't want changed
    // Better than copying values to new list. Can also use this for maps and sets
    List<Integer> ints = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8,9));
    List<Integer> unmodifiableList = Collections.unmodifiableList(ints);
  }

}

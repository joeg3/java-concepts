package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Sets don't remember what order elements were added. HashSets are a bit
 * more efficient. Use a TreeSet to traverse the set in sorted order.
 *
 * You must override the equals() method if using your own objects in a set
 * so that the set will know if it already has that element
 */
public class SetTests {
  private Map<String, County> state;
  private Set<County> counties;

  @BeforeEach
  void beforeEachTest() {
    state = new HashMap<>();
    counties = new HashSet<>();
  }

  @Test
  void showIteration() {
    County temp = new County("Dakota", 450000);
    temp.addCity(new City("Lakeville"));
    temp.addCity(new City("Burnsville"));
    temp.addCity(new City("Apple Valley"));
    state.put("Dakota", temp);
    counties.add(temp);

    temp = new County("Hennepin", 1600000);
    state.put("Hennepin", temp);
    counties.add(temp);

    temp = new County("Ramsey", 950000);
    state.put("Ramsey", temp);
    counties.add(temp);

    System.out.println("************************ State");
    for (County county : counties) {
      System.out.println("\t" + county.getName());
    }

    County c = state.get("Dakota");
    for (City city : c.getCities()) {
      System.out.println("\t" + city.getName());
    }
  }

  @Test
  void useHashSetToHoldUniqueList() {
    Set<String> disallowedPasswords = new HashSet<>();
    disallowedPasswords.add("1234");
    disallowedPasswords.add("qwerty");
    disallowedPasswords.add("passw0rd");

    String myPassword = "qwerty";
    if (disallowedPasswords.contains(myPassword)) {
      // Instruct user to pick different password
    }
  }

  @Test
  void useTreeSetForSortedOrder() {
    // The element type of the set must implement the Comparable interface, or you need to supply a Comparator in the constructor
    Set<String> states = new TreeSet<>();
    states.add("MN");
    states.add("CA");
    states.add("WI");

    // States will be in order
    for (String state : states) {
      //System.out.println("\t" + state);
    }
  }
}

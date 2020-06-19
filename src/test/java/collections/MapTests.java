package collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * In general, use a HashMap. If you need to visit the keys in sorted order, use a TreeMap
 */
public class MapTests {
  Map<String, Integer> teamsAndWins;

  @BeforeEach
  void beforeEachMethod() {

    // Hash Maps are not in sorted order. Use TreeMap if you need to sort
    // Use LinkedHashMap if you want the order to match the order the entries were added
    teamsAndWins = new HashMap<>();
    teamsAndWins.put("Twins", 34);
    teamsAndWins.put("Dodgers", 32);
    teamsAndWins.put("Royals", 30);
  }

  @Test
  void putAndGetHashMap() {
    assertNull(teamsAndWins.put("Reds", 3)); // .put() returns previous entry. Since first time, returns null
    assertEquals(34, teamsAndWins.get("Twins")); // get the value
    assertEquals(34, teamsAndWins.put("Twins", 35)); // returns 34, the previous value for this entry
    assertNull(teamsAndWins.get("Brewers")); // .get() returns null if key isn't present
    assertEquals(0, teamsAndWins.getOrDefault("Brewers", 0)); // if no value for key, return default
    assertTrue(teamsAndWins.containsKey("Dodgers")); // Check if "Dodgers" key already in map

  }

  @Test
  void removeFromMap() {
    assertEquals(34, teamsAndWins.remove("Twins")); // Remove and returns the old value
    assertFalse(teamsAndWins.remove("Dodgers", 31)); // For this method signature, value has to match in order to remove
    assertTrue(teamsAndWins.remove("Dodgers", 32));  // Here they match
    assertNull(teamsAndWins.remove("Cardinals"));  // Returns null if key doesn't exist
  }

  @Test
  void replaceValue() {
    assertEquals(30, teamsAndWins.replace("Royals", 29)); // Replace value, and return old one
    assertEquals(29, teamsAndWins.get("Royals"));
    assertFalse(teamsAndWins.replace("Royals", 23, 22)); // Old value param of 23 doesn't match current value
  }

  @Test
  void createCopyOfHashMap() {
    // Changes to copyOfTeamsAndWins won't change teamsAndWins
    Map<String, Integer> copyOfTeamsAndWins = new HashMap<>(teamsAndWins);;
  }

  @Test
  void loopThroughHashMap() {
    // Loop through keys
    for (String key : teamsAndWins.keySet()) {
      teamsAndWins.get(key);
    }

    // Loop through keys and values
    for(Map.Entry<String, Integer> entry : teamsAndWins.entrySet()) {
      String team = entry.getKey();
      Integer wins = entry.getValue();
    }

    // Loop through keys and values with forEach() method
    teamsAndWins.forEach((k, v) -> {
      // process k, v
    });
  }
}

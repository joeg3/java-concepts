package collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ArraysTest {

  @Test
  void arrayCopyWrongWay() {
    String[] states = {"WI", "CA", "MN"};
    String[] copiedStates = states;
    assertEquals(states[1], copiedStates[1]);

    // Since states and copiedStates point to same array in memory,
    // changing one changes the other, which is probably not the intention
    copiedStates[1] = "HI";
    assertEquals("HI", copiedStates[1]);
    assertEquals("HI", states[1]);
  }

  @Test
  void arrayCopyRightWay() {
    String[] states = {"WI", "CA", "MN"};
    String[] copiedStates = Arrays.copyOf(states, states.length);
    assertEquals(states[1], copiedStates[1]);

    // Now states and copied states are two different arrays in memory
    copiedStates[1] = "HI";
    assertEquals("HI", copiedStates[1]);
    assertEquals("CA", states[1]);
  }
}
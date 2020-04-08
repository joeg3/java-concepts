package collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListsTest {

    @Test
    public void arrayListCreation() {

        // Right side uses diamond syntax, <String> is inferred from left side
        ArrayList<String> states = new ArrayList<>();
        assertEquals(0, states.size());

        // No initializer for array lists, but you can pass in a list
        ArrayList<String> cities = new ArrayList<>(List.of("Paris", "London"));
        assertEquals(2, cities.size());
    }

    @Test
    public void arrayListAddAndDelete() {

        ArrayList<String> states = new ArrayList<>();
        states.add("MN");
        states.add("CA");
        assertEquals("CA", states.get(1));
        states.set(1, "WI");
        assertEquals("WI", states.get(1));
        assertEquals(2, states.size());
        states.remove(1);
        assertEquals(1, states.size());

        // No initializer for array lists, but you can pass in a list
        ArrayList<String> cities = new ArrayList<>(List.of("Paris", "London"));
        assertEquals(2, cities.size());
    }

    @Test
    public void arrayListPrimitiveTypes() {

        // Can't create ArrayList<int> so use Integer wrapper class
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(33);  // Can add a primitive type
        assertEquals(Integer.valueOf(33), ints.get(0)); // Converts to primitive type


        // No initializer for array lists, but you can pass in a list
        ArrayList<String> cities = new ArrayList<>(List.of("Paris", "London"));
        assertEquals(2, cities.size());
    }

}
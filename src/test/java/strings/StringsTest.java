package strings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StringsTest {
	
	public Strings strings;
	
	@Before
	public void setup() {
		strings = new Strings();
	}

	@Test
	public void testCompareTo() {
		// See comment on the method under test about problems using compareTo()
		assertTrue(strings.useCompareTo("word", "world") < 0); // Negative since 4th character d comes before l
		assertTrue(strings.useCompareTo("six", "Zero") > 0); // Positive since Unicode s comes after Z
		assertTrue(strings.useCompareTo("six", "six") == 0);
	}
	
	/**
	 * When comparing against a string literal, put the literal first. Then, even if the
	 * string variable is null, it will still work correctly.
	 */
	@Test
	public void testEquals() {
		String str = "Hello";
		assertTrue("Hello".equals(str));
		str = "hi";
		assertFalse("Hello".equals(str));
	}
	
	@Test
	public void conversionBetweenStringsAndNumbers() {
		assertEquals("42", Integer.toString(42));
		assertEquals(42, Integer.parseInt("42"));
		assertEquals("3.14", Double.toString(3.14));
		assertEquals(3.14, Double.parseDouble("3.14"), 0.1);
	}

}

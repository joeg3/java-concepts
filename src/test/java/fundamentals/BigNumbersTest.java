package fundamentals;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class BigNumbersTest {
	
    public BigNumbers bn;
	
	@Before
	public void setup() {
		bn = new BigNumbers();
	}

	@Test
	public void useBigInteger() {
		BigInteger bi = bn.useBigInteger();
		assertEquals(0, bi.compareTo(new BigInteger("30000000000000000000")));
	}
	
	@Test
	public void useBigDecimal() {
		BigDecimal bd = bn.useBigDecimal();
		assertEquals(0, bd.compareTo(new BigDecimal("0.9")));
	}

}
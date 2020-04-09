package fundamentals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigNumbersTest {
	
    public BigNumbers bn;
	
	@BeforeEach
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

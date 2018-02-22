package fundamentals;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumbers {
	
	public BigInteger useBigInteger() {
		BigInteger i = BigInteger.valueOf(3000000000000000000L);
		return i.multiply(BigInteger.valueOf(10)); // This would be out of range for a long
	}
	
	public BigDecimal useBigDecimal() {
		// Using a double to do floating point subtraction of 2.0 - 1.1 is 0.899999999.
		// Using BigDecimal gives an exact 0.9
		return BigDecimal.valueOf(2, 0).subtract(BigDecimal.valueOf(11, 1));
	}

}

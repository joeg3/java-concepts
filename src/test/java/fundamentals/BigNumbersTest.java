package fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BigNumbersTest {

  private BigNumbers bn;

  @BeforeEach
  void setup() {
    bn = new BigNumbers();
  }

  @Test
  void useBigInteger() {
    BigInteger bi = bn.useBigInteger();
    assertEquals(0, bi.compareTo(new BigInteger("30000000000000000000")));
  }

  @Test
  void useBigDecimal() {
    BigDecimal bd = bn.useBigDecimal();
    assertEquals(0, bd.compareTo(new BigDecimal("0.9")));
  }

}

package fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParamsTest {
  private Params params;

  @BeforeEach
  void setup() {
    params = new Params();
  }

  @Test
  void multipleParams() {
    assertEquals(21, params.sum(1,2,3,4,5,6));
    int[] nums = {1,2,3,4,5,6};
    assertEquals(21, params.sum(nums)); // Can pass in an array
  }

  @Test
  void singleAndMultipleParams() {
    assertEquals(32, params.addToNum(11,1,2,3,4,5,6));
  }
}

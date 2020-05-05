package fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VariablesTest {
  private Variables variables;

  @BeforeEach
  void setup() {
    variables = new Variables();
  }

  @Test
  void declareVariableInMethod() {
    assertEquals(1, variables.declareVariableInMethod());
  }

  @Test
  void declareFinalVariable() {
    assertEquals(29, variables.declareFinalVariable(2016));
    assertEquals(28, variables.declareFinalVariable(2017));
  }

}

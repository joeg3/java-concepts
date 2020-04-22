package fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VariablesTest {
  public Variables variables;

  @BeforeEach
  public void setup() {
    variables = new Variables();
  }

  @Test
  public void declareVariableInMethod() {
    assertEquals(1, variables.declareVariableInMethod());
  }

  @Test
  public void declareFinalVariable() {
    assertEquals(29, variables.declareFinalVariable(2016));
    assertEquals(28, variables.declareFinalVariable(2017));
  }

}

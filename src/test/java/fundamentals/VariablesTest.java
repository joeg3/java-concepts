package fundamentals;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VariablesTest {
	
	public Variables variables;
	
	@Before
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

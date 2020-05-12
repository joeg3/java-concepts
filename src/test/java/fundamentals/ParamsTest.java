package fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
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

  /**
   * The method obtains a copy of the object reference, so myList being passed in and the
   * list parameter in the method are pointing to the same object, so object gets mutated.
   */
  @Test
  void objectPassedAsParamGetsMutated() {
    ArrayList<String> myList = new ArrayList<>();
    assertEquals(0, myList.size());
    params.addStringToArrayList(myList);
    assertEquals(1, myList.size());
  }

  /**
   * For primitive types, the value is copied. So here, the value of myNum is copied to the
   * number parameter of addThreeToInt(). When number is increased, it doesn't change myNum.
   */
  @Test
  void primitivePassedAsParamNotUpdated() {
    int myNum = 2;
    params.addThreeToInt(myNum);
    assertEquals(2, myNum);
  }

  /**
   * The method obtains a copy of the object reference, so myList being passed in and the
   * list parameter in the method are pointing to the same object. The method then assigns
   * list to a different ArrayList, and myList still points to original.
   */
  @Test
  void objectPassedAsParamCantChangeReference() {
    ArrayList<String> myList = new ArrayList<>();
    assertEquals(0, myList.size());
    params.tryToAssignToDifferentList(myList);
    assertEquals(0, myList.size());
  }
}

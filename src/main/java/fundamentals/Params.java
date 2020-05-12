package fundamentals;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Params {

  /**
   * @param numbers - Is actually an array of type int
   */
  public int sum(int... numbers) {
    int sum = 0;
    for(int num : numbers) {
      sum += num;
    }
    return sum;
  }

  /**
   * @param numbers - Varaible parameter must be last one
   */
  public int addToNum(int total, int... numbers) {
    for(int num : numbers) {
      total += num;
    }
    return total;
  }

  public void addStringToArrayList(ArrayList<String> list) {
    list.add("Added Element");
  }

  public void addThreeToInt(int number) {
    number += 3;
    //System.out.println("addThreeToInt() Number = " + number);
  }

  public void tryToAssignToDifferentList(ArrayList<String> list) {
    list = new ArrayList<>(List.of("Paris", "London"));
  }
}

package fundamentals;

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
}

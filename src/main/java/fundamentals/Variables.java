package fundamentals;

public class Variables {
  final int DAYS_PER_WEEK = 7;

  public int declareVariableInMethod() {
    int x;
    // x++;  // This will cause an error, uses uninitialized variable
    x = 0;   // Initialize first, either in declaration, or like this line (before it's used)
    x++;     // then use it
    return x;
  }

  public int declareFinalVariable(int year) {
    final int DAYS_IN_FEBRUARY;

    // You can initialize a final variable later, as long as it is initialized exactly once
    // before it is used for the first time.

    if (year % 4 == 0) {
      DAYS_IN_FEBRUARY = 29;
    } else {
      DAYS_IN_FEBRUARY = 28;
    }

    return DAYS_IN_FEBRUARY;
  }
}

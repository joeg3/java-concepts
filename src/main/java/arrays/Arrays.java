package arrays;

public class Arrays {

  public int[] arrayLiteral() {
    int[] numbers = { 1, 2, 3 };
    return numbers;
  }

  public void printingArrays() {
    // Arrays inherit the toString() method from Object, but don't return a friendly format.
    int[] myNums = {1, 2, 3, 4};

    // So instead of this:
    myNums.toString(); // Prints something like "[I@1a44e8...

    // Do this:
    java.util.Arrays.toString(myNums); // prints "[1, 2, 3, 4]"
    // For multidimensional arrays, use Arrays.deepToString()
  }
}

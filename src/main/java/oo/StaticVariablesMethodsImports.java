package oo;

// Import all classes from a package. Wildcards can only import classes. You can use it for multiple packages
import java.util.*;

// Import all static methods of the Math class. You can use those methods without the class prefix
import static java.lang.Math.*;

// Can also import single static method or variable
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;

public class StaticVariablesMethodsImports {
  public static final int MY_STATIC_CONSTANT; // The static keyword means one per class
  public static int myStaticVariable = 0; // Mutable static variables are rare
  private int myInstanceVariable = 0; // One per object

  // This is run when class is first loaded
  static {
    MY_STATIC_CONSTANT = 0;
  }

  // Call this way: StaticVariablesAndMethods.addToConstant(7);
  public static int addToConstant(int num) {
    return num + MY_STATIC_CONSTANT;
  }
}

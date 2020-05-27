package oo.inheritance;

import org.junit.jupiter.api.Test;

public class AbstractTests {

  @Test
  void instantiateSubclassOfAbstractClass() {

    // You cannot instantiate an abstract class, but you can use a variable with
    // the type of an abstract class and assign it to the concrete subclass
    Person person = new Student("Jim", 123);
  }
}

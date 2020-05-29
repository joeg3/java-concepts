package exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;

public class ExceptionTests {

  @Test
  void uncheckedExceptions() {
    // Exceptions that are subclasses of RuntimeException are not checked during compilation
    // They are called Unchecked Exceptions. The RuntimeException class is a subclass of the Exception class

    // Integer.parseInt() throws an exception if the string argument isn't a number. But since it's an unchecked
    // exception, we don't have to have a try/catch block around it
    int x = Integer.parseInt("5");

    // Here we pass in a value that will throw an exception
    Exception e = assertThrows(NumberFormatException.class, () -> Integer.parseInt("Typo"));
  }

  @Test
  void checkedExceptions() {
    // Checked exceptions that are subclasses of Exception are checked during compilation
    // They are called Checked Exceptions

    // Since Class.forName throws a checked exception, we have to either catch it, or the method it is in has to throw it
    try {
      Class.forName("Integer");
    } catch (ClassNotFoundException e) {

    }
  }
}

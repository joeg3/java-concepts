package oo.interfaces;

public interface InterfaceMethods {

  // You can have static, default, and private methods in an interface with a concrete implementation

  // Static
  // Factory methods are a common use of static methods in an interface
  // This method returns an instance of a class that implements the IntSequence interface. The caller doesn't
  // care which implementing class. Call it like this:
  // IntSequence digits = IntSequence.digitsOf(1234);
  static IntSequence digitsOf(int n) {
    return new DigitSequence(n);
  }

  // Default
  // You can supply a default implementation for any interface method. You must tag it with the default modifier
  // A class implementing the interface can choose to use default or override hasNext()
  default boolean hasNext() { return true; } // By default, sequences are infinite

  // If implementing two interfaces with default hasNext() methods, you will get a compile error.
  // Either override and implement your own, or delegate to one of the conflicting methods:
  // public boolean hasNext() { return IntSequence.super.hasNext(); }

  // Private
  // A private method must be static or an instance method, but cannot be default
  // Since private, these are usually helper methods
  private void doSomething() {}
}

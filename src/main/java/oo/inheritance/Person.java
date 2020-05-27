package oo.inheritance;

// Class and method use abstract keyword
// Unlike an interface, abstract classes can have instance variables and constructors
// For an interface, the variables must be public static final
// But you cannot construct an instance of an abstract class
public abstract class Person {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  // Keyword final - subclass cannot extend this method
  // Abstract class can have non-abstract methods
  public final String getName() {
    return name;
  }

  // Keyword abstract - subclass must either implement this method or itself be abstract
  public abstract int getId();

}

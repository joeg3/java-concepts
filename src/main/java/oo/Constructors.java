package oo;

import java.util.ArrayList;

public class Constructors {
  // If instance variables are not set in constructor, they are set to default values
  // of zero for numbers, false for boolean, null for objects.
  // Instance variables and initialization blocks are initialized in order they appear,
  // before the constructor is run
  // Remember that local variable in a method must always be initialized.
  private String name; // Dangerous, risking a null pointer exception
  private int age; // Initialized to zero
  private String zip = "55445"; // This gets set after object is allocated, but before constructor is run

  // Must be initialized by the end of each constructor. If primitive, cannot be modified
  // If mutable, reference cannot change, but you can mutate the object
  // Note this is a final instance variable, not the more common final static variable.
  private final ArrayList<String> cities;


  // You can include an initialization block
  {
    if (age == 0) { age += 10; } // Doesn't make sense, just for illustration
  }

  /**
   * A class with no constructors is automatically given a no-arg constructor
   * If class has constructors with params, then there isn't a no-arg constructor
   * unless explicitly in code
   */
  public Constructors() {
    // You can overload constructors and have them call another one
    this("Default", 0, "00000");
  }

  public Constructors(String name, int age, String zip) {
    this.name = name;
    this.age = age;
    this.zip = zip;
    this.cities = new ArrayList<>();
  }

  // Some classes have factory methods that call private constructors like this one
  // The LocalDate class is an example
  // private Constructors() { }

  public void addCity(String city) {
    cities.add(city);
  }
}

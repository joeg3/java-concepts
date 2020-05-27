package oo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PolymorphismTest {

  @Test
  void demonstratePolymorphism() {
    // We can keep our code general and not specify which subclass we are using
    // A method could have a Movie parameter instead of a method for each subclass type
    Movie movie = new Terminator("Terminator");
    assertEquals("Robot from future comes to earth", movie.plot()); // Assigned to movie, but references Terminator object
    movie = new Titanic("Titanic");
    assertEquals("Undefined", movie.plot()); // Titanic doesn't override plot(), so uses plot() from superclass
  }
}

package oo.interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IntSequenceDemoTest {

  @Test
  void runSequenceOfSquares() {
    SquareSequence squares = new SquareSequence(); // Here we set squares to the class
    double avg = IntSequenceDemo.average(squares, 100);
    System.out.println("Average of first 100 squares: " + avg);
    assertEquals(3383.5, avg);
  }

  @Test
  void runSequenceOfDigits() {
    // Here IntSequence refers to an object of some class that implements the IntSequence interface
    // Think of IntSequence interface as the supertype of the DigitSquence class
    IntSequence digits = new DigitSequence(1729); // Here we set digits to the interface type
    while (digits.hasNext()) System.out.print(digits.next() + " ");
    System.out.println();

    digits = new DigitSequence(1729);
    double avg = IntSequenceDemo.average(digits, 100);
    // Will only look at the first four sequence values
    System.out.println("Average of the digits: " + avg);
    assertEquals(4.75, avg);

    // To call a method that is of the class but not the interface, you need to do a cast
    // You may want to make sure the object is of the right type by using instanceof
    if (digits instanceof DigitSequence) {
      DigitSequence digitSequence = (DigitSequence) digits;
      digitSequence.rest();
    }

  }

}

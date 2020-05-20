package oo.interfaces;

public class SquareSequence implements IntSequence {
  private int i;

  // Implementing class must declare the methods of the interface as public
  public boolean hasNext() { // infinite number of squares
    return true;
  }

  public int next() {
    i++;
    return i * i;
  }
}

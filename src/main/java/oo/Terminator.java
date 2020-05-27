package oo;

public class Terminator extends Movie {
  public Terminator(String name) {
    super(name);
  }

  @Override
  public String plot() {
    return "Robot from future comes to earth";
  }
}

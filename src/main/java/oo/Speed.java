package oo;

public class Speed extends Movie {
  public Speed(String name) {
    super(name);
  }

  @Override
  public String plot() {
    return "Bus blows up if it slows down";
  }
}
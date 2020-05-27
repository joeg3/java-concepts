package oo;

public class Movie {
  private String name;

  public Movie(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Movie setName(String name) {
    this.name = name;
    return this;
  }

  public String plot() {
    return "Undefined";
  }

}


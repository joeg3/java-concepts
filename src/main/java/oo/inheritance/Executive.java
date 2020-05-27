package oo.inheritance;

// This class is final - cannot be overridden
public final class Executive extends Manager {

  public Executive(String name, int salary, int bonus) {
    super(name, salary, bonus);
  }
}

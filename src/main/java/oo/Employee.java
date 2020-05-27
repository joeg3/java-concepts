package oo;

public class Employee {
  private String name;
  private int salary;
  private int bonus;

  public Employee(String name) {
    this(name, 0, 0);
  }

  public Employee(String name, int salary, int bonus) {
    this.name = name;
    this.salary = salary;
    this.bonus = bonus;
  }

  public String getPrintable() {
    return "Employee: " + name + ", salary: " + salary + ", bonus: " + bonus + ", compensation: " + (salary + bonus);
  }

  // This method is final, cannot be overridden by subclasses
  public final String getName() {
    return name;
  }

  public Employee setName(String name) {
    this.name = name;
    return this;
  }

  public int getSalary() {
    return salary;
  }

  public Employee setSalary(int salary) {
    this.salary = salary;
    return this;
  }

  public int getBonus() {
    return bonus;
  }

  public Employee setBonus(int bonus) {
    this.bonus = bonus;
    return this;
  }
}

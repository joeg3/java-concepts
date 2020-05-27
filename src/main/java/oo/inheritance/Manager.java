package oo.inheritance;

import oo.Employee;

public class Manager extends Employee {
  private int commission;

  public Manager(String name, int salary, int bonus) {
    super(name, salary, bonus); // Call the constructor in Employee
    commission = 0;
  }

  @Override
  public int getSalary() { // Overrides superclass method
    // Subclass cannot access private instance variables of superclass, so we use public getSalary()
    return super.getSalary() + commission;
  }

  public int getCommission() {
    return commission;
  }

  public Manager setCommission(int commission) {
    this.commission = commission;
    return this;
  }


}

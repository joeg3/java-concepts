package collections;

public class Worker implements Comparable<Worker> {
  private String name;
  private int salary;
  private int bonus;

  public Worker(String name) {
    this(name, 0, 0);
  }

  public Worker(String name, int salary, int bonus) {
    this.name = name;
    this.salary = salary;
    this.bonus = bonus;
  }

  @Override
  public int compareTo(Worker worker) {
    return (this.getSalary() + this.getBonus()) - (worker.getSalary() + worker.getBonus());
  }

  public String getPrintable() {
    return "Worker: " + name + ", salary: " + salary + ", bonus: " + bonus + ", compensation: " + (salary + bonus);
  }

  // This method is final, cannot be overridden by subclasses
  public final String getName() {
    return name;
  }

  public Worker setName(String name) {
    this.name = name;
    return this;
  }

  public int getSalary() {
    return salary;
  }

  public Worker setSalary(int salary) {
    this.salary = salary;
    return this;
  }

  public int getBonus() {
    return bonus;
  }

  public Worker setBonus(int bonus) {
    this.bonus = bonus;
    return this;
  }
}

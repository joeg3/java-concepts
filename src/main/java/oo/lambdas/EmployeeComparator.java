package oo.lambdas;

import java.util.Comparator;
import oo.Employee;

public class EmployeeComparator implements Comparator<Employee> {

  @Override
  public int compare(Employee e1, Employee e2) {
    return (e1.getSalary() + e1.getBonus()) - (e2.getSalary() + e2.getBonus());
  }
}

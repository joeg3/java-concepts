package oo.inheritance;

import oo.Employee;
import org.junit.jupiter.api.Test;

public class InheritanceTests {

  @Test
  void assigningSubclassToSuperclass() {
    Manager dan = new Manager("Dan", 66000, 0);
    Employee emp = dan; // Ok to assign to superclass variable

    // Even though the type of emp is Employee, the getSalary() of Manager is invoked.
    // The JVM looks at the actual class of the object, not the type of the variable
    // This allows you to write code for all employees regardless of subtype
    emp.getSalary();
  }

  @Test
  void casting() {
    Employee emp = new Manager("Jim", 9876, 0);

    // emp.setCommission(); // Can't invoke subclass methods

    // Instead, check beforehand
    if ( emp instanceof Manager) {
      Manager m = (Manager) emp;
      m.setCommission(222);
    }
  }
}

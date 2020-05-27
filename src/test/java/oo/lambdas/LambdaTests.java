package oo.lambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;
import oo.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A lambda is a block of code you can pass around. You can supply a lambda expression
 * wherever an object of an interface with a single abstract methdo is expected. Such an
 * interface is called a functional interface. A lambda is a block of code
 * along with the specification of any variables that must be passed to the code.
 * In the below example, the lambda is one line, so no curly braces or return statement
 * are needed. If more than one line, include curly braces and return statement.
 * If lambda has no parameters, supply empty parenthesis. If the parameter types can be
 * inferred, you can omit them, but still keep the parameters (below, we were able to infer
 * the Employee types, so we just had to pass in e1 adn e2. You never have to specify the
 * return type, the compiler checks that it matches the expected type.
 */
public class LambdaTests {
  List<Employee> employees;

  @BeforeEach
  void setup() {
    Employee sally = new Employee("Sally", 80000, 0);
    Employee jim = new Employee("Jim", 50000, 1200);
    Employee julie = new Employee("Julie", 100000, 10000);
    Employee fred = new Employee("Fred", 40000, 12000);

    employees = Arrays.asList(sally, jim, julie, fred);
  }

  @Test
  void sortUsingStandardClassThatImplementsComparatorInterface() {

    System.out.println("UNSORTED EMPLOYEES");
    printEmployees(employees);

    // Here we created another class for the comparator
    Collections.sort(employees, new EmployeeComparator());
    System.out.println("SORTED EMPLOYEES");
    printEmployees(employees);
    assertEquals("Jim", employees.get(0).getName());
    assertEquals("Fred", employees.get(1).getName());
    assertEquals("Sally", employees.get(2).getName());
    assertEquals("Julie", employees.get(3).getName());

    // Since Java 8, the List interface supports the sort method directly, so don't need to use Collections.sort()
    employees.sort(new EmployeeComparator());
  }

  @Test
  void sortUsingLambdaAssignedToComparator() {

    System.out.println("UNSORTED EMPLOYEES");
    printEmployees(employees);

    // Here we created a comparator using a lambda instead of
    // implementing the Comparator interface with a class
    // The compiler assumes e1 and e2 are Employee types because they are assigned
    // to an Employee comparator. You don't specify the result type of a lambda expression.
    // The compiler infers it from the context where (in this case) a result type of int is expected
    // because that's the return type of the lone method in the interface we are implementing
    Comparator<Employee> comp = (e1, e2) ->
      (e1.getSalary() + e1.getBonus()) - (e2.getSalary() + e2.getBonus());


    Collections.sort(employees, comp);
    System.out.println("SORTED EMPLOYEES");
    printEmployees(employees);
    assertEquals("Jim", employees.get(0).getName());
    assertEquals("Fred", employees.get(1).getName());
    assertEquals("Sally", employees.get(2).getName());
    assertEquals("Julie", employees.get(3).getName());

    // Since Java 8, the List interface supports the sort method directly, so don't need to use Collections.sort()
    employees.sort(comp);
  }

  @Test
  void sortUsingInlineLambdaComparator() {

    System.out.println("UNSORTED EMPLOYEES");
    printEmployees(employees);

    // Here we created a comparator using a lambda instead of
    // implementing the Comparator interface in a class
    Collections.sort(employees, (e1, e2) ->
        (e1.getSalary() + e1.getBonus()) - (e2.getSalary() + e2.getBonus()));
    System.out.println("SORTED EMPLOYEES");
    printEmployees(employees);
    assertEquals("Jim", employees.get(0).getName());
    assertEquals("Fred", employees.get(1).getName());
    assertEquals("Sally", employees.get(2).getName());
    assertEquals("Julie", employees.get(3).getName());

    // Since Java 8, the List interface supports the sort method directly, so don't need to use Collections.sort()
    employees.sort((e1, e2) ->
        (e1.getSalary() + e1.getBonus()) - (e2.getSalary() + e2.getBonus()));
  }

  /**
   * The Iterable interface has a forEach(Consumer<? super T> action) method
   * that you can pass lambdas into.   This interface is perfect for just iterating over
   * a list and processing each item. Basically the Iterator calls the Consumer's accept() method
   * for each item in the list. The accept method evaluates the lambda expression passed by the
   * forEach method using the passed object as the argument to the lambda. The accept method
   * doesn't return anything. Generics are used to infer the type of the parameter.
   */
  @Test
  void compareUsingConsumerFunctionalinterface() {

    // Here we use forEach, which expects a Consumer functional interface
    System.out.println("EMPLOYEES > 55000");
    employees.forEach(employee -> {
      if ((employee.getSalary() + employee.getBonus()) > 55000) {
        printEmployee(employee);
      }
    });

    for(Employee employee : employees) {

    }
  }

  /**
   * Here we use the Predicate functional interface that has the test method that returns
   * boolean. We could have made a method to print employees bonus over a certain threshold.
   * But with lambdas, we can pass in code for less than the threshold, or even things other
   * than bonus, such as salary. We just have to pass in code that matches the functional
   * interface - in this case, Predicate
   */
  @Test
  void compareUsingPredicateFunctionalInterface() {
    printEmployeesByCompensation(employees, "Employees bonus >= 10000", employee -> employee.getBonus() >= 10000);
    printEmployeesByCompensation(employees, "Employees bonus < 10000", employee -> employee.getBonus() < 10000);
    printEmployeesByCompensation(employees, "Employees salary < 50000", employee -> employee.getSalary() < 50000);

    // You can also do this by anonymous class if you don't want to use lambdas. Usually you would use lambdas,
    // and this is here as an example if reading code that uses anonymous classes
    printEmployeesByCompensation(employees, "Employees salary > 90000", new Predicate<Employee>() {
      @Override
      public boolean test(Employee employee) {
        return employee.getSalary() > 90000;
      }
    });
  }

  private void printEmployeesByCompensation(List<Employee> employees, String header, Predicate<Employee> compensationCondition) {
    System.out.println(header);
    for(Employee employee : employees) {
      if (compensationCondition.test(employee)) {
        printEmployee(employee);
      }
    }
  }

  @Test
  void chainPredicatesTogether() {
    // Instead of using a predicate with generics, if using integers, etc, use the predicate for the specific type
    IntPredicate intpGt15 = i -> i > 15;
    assertTrue(intpGt15.test(44));

    // We can chain predicates
    IntPredicate intpLt100 = i -> i < 100;
    assertTrue(intpGt15.and(intpLt100).test(50));
    assertFalse(intpGt15.and(intpLt100).test(8));
  }

  @Test
  void useFunctionFunctionalInterface() {

    // For the generic <Employee, Integer>, Employee is the argument type, and Integer is the return type
    // The Function functional interface is handy in many situations because it takes a value and returns a value
    Function<Employee, Integer> getCompensation = (Employee employee) -> {
      return employee.getSalary() + employee.getBonus();
    };
    assertEquals(110000, getCompensation.apply(employees.get(2)));

    Function<Employee, Integer> getTaxes = (Employee employee) -> {
      return (employee.getSalary() + employee.getBonus()) / 10;
    };
    assertEquals(11000, getTaxes.apply(employees.get(2)));

    // We can create a method runCalc() below that we can pass any calculation to
    assertEquals(110000, runCalc(getCompensation, employees.get(2)));
    assertEquals(11000, runCalc(getTaxes, employees.get(2)));
  }

  private Integer runCalc(Function<Employee, Integer> calcFunc, Employee employee) {
    return calcFunc.apply(employee);
  }

  @Test
  void comparatorMethods() {
    // Chain comparators with thenComparing() to break ties
    employees.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getBonus));
  }

  @Test
  void lambdaVariableScope() {
    // Can't declare a local variable e1 the same name as local variable in lambda
    // But see repeatMessage() below where you can access variables from an enclosing scope
    //Employee e1;
    employees.sort((e1, e2) ->
        (e1.getSalary() + e1.getBonus()) - (e2.getSalary() + e2.getBonus()));
  }

  public static void repeatMessage(String text, int count) {
    // A lambda can access variables text and count from the enclosing scope
    Runnable r = () -> {
      for(int i = 0; i < count; i++) {
        System.out.println(text);
      }
    };
    new Thread(r).start();
  }

  @Test
  void useMethodReferences() {
    // If there is a method that does the same action as the code you want to pass on to some
    // other code, pass that method. This uses the :: operator. There are three variations:
    // 1) Class::instanceMethod
    // 2) Class::staticMethod
    // 3) object::instanceMethod

    // Class::instanceMethod
    List<String>  states = new ArrayList<>(Arrays. asList("MN", "CA", "WI"));
    states.forEach(x -> System.out.println(x)); // Instead of lambda
    states.forEach(System.out::println); // Use method reference

    // Class::staticMethod
    List<String>  cities = new ArrayList<>(Arrays. asList("Mpls", null, "LA", null, "NY"));
    cities.removeIf(x -> { return (x == null) ? true : false;}); // Instead of lambda
    assertEquals(3, cities.size());

    cities = new ArrayList<>(Arrays. asList("Mpls", null, "LA", null, "NY"));
    cities.removeIf(Objects::isNull); // Use method reference
    assertEquals(3, cities.size());

    // object::instanceMethod
    String[] names = {"Jim", "Julie", "Fred", "Sally"};
    Arrays.sort(names, (x, y) -> x.compareToIgnoreCase(y)); // Instead of lambda
    Arrays.sort(names, String::compareToIgnoreCase);  // Use method reference
  }

  @Test
  void constructorReferences() {
    // Constructor references are like method references except name of method is 'new'
    List<String>  names = new ArrayList<>(Arrays. asList("Jim", "Judy", "Jon"));
    Stream<Employee> stream = names.stream().map(Employee::new);
    Employee[] staff = stream.toArray(Employee[]::new);
    assertEquals(3, staff.length);
    assertEquals("Jim", staff[0].getName());
  }

  private void printEmployees(List<Employee> employees) {
    for (Employee e : employees) {
      printEmployee(e);
    }
  }

  private void printEmployee(Employee e) {
      System.out.println(e.getPrintable());
  }

}

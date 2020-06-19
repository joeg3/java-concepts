package collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListSortingTests {
  private List<Worker> workers;

  // Comparator anonymous inner class
  static final Comparator<Worker> BONUS_ORDER = new Comparator<Worker>() {
    @Override
    public int compare(Worker w1, Worker w2) {
      return w1.getBonus() - w2.getBonus();
    }
  };

  @BeforeEach
  void beforeEachTest() {
    workers = new ArrayList<>();
    workers.add(new Worker("Jim", 50000, 1000));
    workers.add(new Worker("Sally", 51000, 3000));
    workers.add(new Worker("Al", 20000, 2000));
    workers.add(new Worker("Alice", 22000, 100000));
  }

  @Test
  void sortUsingComparable() {
    // We can sort workers collection because Worker class implements Comparable<Worker>

    // Order we added them to collection
    assertEquals("Jim", workers.get(0).getName());
    assertEquals("Alice", workers.get(3).getName());

    // Sorted from lowest to highest total compensation
    Collections.sort(workers);
    assertEquals("Al", workers.get(0).getName());
    assertEquals("Alice", workers.get(3).getName());

    // Reverse order
    Collections.reverse(workers);
    assertEquals("Alice", workers.get(0).getName());
    assertEquals("Al", workers.get(3).getName());
  }

  @Test
  public void sortUsingComparatorClass() {
    // Sorting by implementing Comparable, we can only implement the interface with Comparable once, so it doesn't
    // work if we want multiple ways to sort.
    // A comparator is external to the element we are sorting, so we can have multiple ways to sort

    // Here we created another class for the comparator
    Collections.sort(workers, new WorkerSalaryComparator());
    assertEquals("Al", workers.get(0).getName());
    assertEquals("Alice", workers.get(1).getName());
    assertEquals("Jim", workers.get(2).getName());
    assertEquals("Sally", workers.get(3).getName());

    // Since Java 8, the List interface supports the sort method directly, so don't need to use Collections.sort()
    workers.sort(new WorkerSalaryComparator());
  }

  @Test
  public void sortUsingComparatorAnnonymousInnerClass() {
    workers.sort(BONUS_ORDER);
    assertEquals("Jim", workers.get(0).getName());
    assertEquals("Al", workers.get(1).getName());
    assertEquals("Sally", workers.get(2).getName());
    assertEquals("Alice", workers.get(3).getName());
  }

}
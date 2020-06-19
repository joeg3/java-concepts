package collections;

import java.util.Comparator;

public class WorkerSalaryComparator implements Comparator<Worker> {

  @Override
  public int compare(Worker w1, Worker w2) {
    return w1.getSalary() - w2.getSalary();
  }
}

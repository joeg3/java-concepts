package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

public class ConcurrencyTest {

  /**
   * A Runnable carries out a task, but doesn't yield a value
   */
  @Test
  void runnable() {
    Runnable hellos = () -> {
      for (int i = 1; i <= 1000; i++) {
        System.out.println("Hello " + i);
      }
    };
    Runnable goodbyes = () -> {
      for (int i = 1; i <= 1000; i++) {
        System.out.println("Goodbye " + i);
      }
    };
    ExecutorService executor = Executors.newCachedThreadPool();
    executor.execute(hellos);
    executor.execute(goodbyes);
  }
}

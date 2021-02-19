package dateandtimeapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InstantAndDurationTest {
  Instant timeStamp1;
  Instant timeStamp2;

  @BeforeEach
  void setup() throws InterruptedException {
    timeStamp1 = Instant.now();
    TimeUnit.SECONDS.sleep((2L));
    timeStamp2 = Instant.now();
  }

  @Test
  void getInstant() {
    // You use Instant to get a point in time
    Instant pointInTime = Instant.now();
  }

  @Test
  void getDurationBetweenInstants() {
    // A duration is the amount of time between two instants
    Duration timeElapsed = Duration.between(timeStamp1, timeStamp2);
    assertEquals(2, timeElapsed.toSeconds());
  }

  @Test
  void getDurationStaticMethods() {
    Duration oneWeek = Duration.ofDays(7);
    long secondsInWeek = oneWeek.toSeconds();
    assertEquals(604800L, secondsInWeek);

    // These could come in handy for error checking
    assertFalse(oneWeek.isZero());
    assertFalse(oneWeek.isNegative());
  }

  @Test
  void timeArithmetic() {
    // Date/Time objects are immutable, so timeStamp2.plus(Duration.ofSeconds(3L));
    // won't update timeStamp2. Need to assign it to variable
    timeStamp2  = timeStamp2.plus(Duration.ofSeconds(3L));
    assertEquals(5, Duration.between(timeStamp1, timeStamp2).getSeconds());

    // This method takes a long instead of a Duration object
    timeStamp2  = timeStamp2.plusSeconds(3L);
    assertEquals(8, Duration.between(timeStamp1, timeStamp2).getSeconds());

    // You can also subtract
    timeStamp2  = timeStamp2.minusSeconds(3L);
    assertEquals(5, Duration.between(timeStamp1, timeStamp2).getSeconds());
  }
}

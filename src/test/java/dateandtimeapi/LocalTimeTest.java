package dateandtimeapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.LocalTime;
import org.junit.jupiter.api.Test;

public class LocalTimeTest {

  @Test
  void localTime() {
    // LocalTime doesn't have AM/PM, but the formatter can
    LocalTime now = LocalTime.now();
    LocalTime dinner = LocalTime.of(18, 30); // 6:30
    LocalTime bedtime = dinner.plusHours(4);
    assertEquals(22, bedtime.getHour());
    assertEquals(30, bedtime.getMinute());
  }

  @Test
  void compareLocalTimes() {
    assertTrue(LocalTime.of(7,0).isBefore(LocalTime.of(15, 30)));
  }
}

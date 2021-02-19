package dateandtimeapi;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

public class FormattingTest {

  @Test
  void standardFormatter() {
    // Use the ISO_DATE_TIME formatter
    LocalDateTime favDate = LocalDateTime.of(1998, 12, 19, 16, 0, 0, 0);
    String formatted = DateTimeFormatter.ISO_DATE_TIME.format(favDate);
    assertEquals("1998-12-19T16:00:00", formatted);

    // Reusable formatter instead of static method
    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    assertEquals("1998-12-19T16:00:00", formatter.format(favDate));
  }

  @Test
  void customFormatter() {
    LocalDateTime favDate = LocalDateTime.of(1998, 12, 19, 16, 0, 0, 0);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MM-dd-yyyy HH:mm");
    assertEquals("Sat 12-19-1998 16:00", formatter.format(favDate));
  }
}

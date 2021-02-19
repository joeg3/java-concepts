package dateandtimeapi;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import org.junit.jupiter.api.Test;

public class LocalDateTest {

  @Test
  void localDatesAndPeriods() {
    // Local dates do not correspond to a precise instant in time since they don't have
    // time zone or time of day information
    // It's recommended you don't use zoned time unless you really want to represent absolute time instances
    // For example, if you added a week to an instance, but it crossed the daylight savings
    // time boundary, you would be an hour too early or late!
    LocalDate today = LocalDate.now();
    LocalDate dadsBirthday = LocalDate.of(1934, 6, 14);
    dadsBirthday = LocalDate.of(1934, Month.JUNE, 14);
    LocalDate twoMonthsInFuture = today.plusMonths(2L); // Arithmetic for two months from now

    // Difference between two instances is a Duration
    // Difference between two local dates is a Period
    LocalDate oneYearOlder = dadsBirthday.plus(Period.ofYears(1));
    oneYearOlder = oneYearOlder.plus(Period.ofDays(365)); // !! Won't give correct result in leap year
    Period age = dadsBirthday.until(today); // until() returns difference between two local dates as a Period in years, months, days, but may not be useful with different number of days in each month
    long ageInDays = dadsBirthday.until(today, ChronoUnit.DAYS);
  }

  @Test
  void cautionWithArithmetic() {
    // Adding 1 month to Jan 31 or subtracting 1 month from March 31 does not yield Feb 31
    LocalDate lastDayInFeb = LocalDate.of(2016, 1, 31).plusMonths(1);
    assertEquals(29, lastDayInFeb.getDayOfMonth());
    lastDayInFeb = LocalDate.of(2016, 3, 31).minusMonths(1);
    assertEquals(29, lastDayInFeb.getDayOfMonth());
  }

  @Test
  void dayOfWeek() {
    assertEquals(DayOfWeek.THURSDAY, LocalDate.of(1776, 7, 4).getDayOfWeek());
    assertEquals(4, LocalDate.of(1776, 7, 4).getDayOfWeek().getValue());
    assertEquals(DayOfWeek.TUESDAY, DayOfWeek.SATURDAY.plus(3));
  }

  @Test
  void partialDates() {
    MonthDay christmas = MonthDay.of(12, 25);
    assertEquals(25, christmas.getDayOfMonth());
  }

  @Test
  void dateAdjusters() {
    LocalDate firstThursday = LocalDate.of(1776, 7, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
    assertEquals(4, firstThursday.getDayOfMonth());
  }
}

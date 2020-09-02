package streams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import oo.Department;
import oo.Employee;
import org.junit.jupiter.api.Test;

/*
  Notes on streams
  * Any collection can be turned into a stream with the stream() method of the Collection interface.
    For an array, use the static Stream.of() method instead.
  * Stream operations don't mutate their source. The filter method does not remove elements from
    a stream, it returns a new stream in which they are not present
  * Streams better allow optimization where it does lazy execution when the results are needed. If you
    only ask for the first 3 long words, it will stop filtering. Streams are also optimized for concurrent threads.
  * Streams are like pipelines with typically 3 stages:
     1) Create a stream with .stream() or .parallelStream()
     2) Specify intermediate operations like .filter()
     3) Apply a terminal operation like .count() that produces the result.
*/
public class StreamsTest {
  private List<String> cities = new ArrayList<>(List.of("Minneapolis", "Ely", "Rochester", "Lakeville", "Duluth", "Winona", "Stillwater", "Mankato"));

  @Test
  void iterationVsStream() {
    // Use iteration and streams to process list and find words with length > 7
    int iterationCount = 0;
    for (String c : cities) {
      if (c.length() > 7) iterationCount++;
    }
    assertEquals(4, iterationCount);

    // Streams don't alter their source - in this case cities
    long streamCount = cities.stream()
        .filter(c -> c.length() > 7)
        .count();
    assertEquals(4L, streamCount);
  }

  @Test
  void streamTransformation() {
    // A stream transformation produces a stream from another stream

    // Filter transformation
    Stream<String> longCityNames = cities.stream().filter(c -> c.length() > 7); // Argument of filter() is a Predicate<T>, a function from T to boolean

    // Map to transform by passing it the function to do the transformation
    Stream<String> lowercaseCities = cities.stream().map(String::toLowerCase); // Use map() with a method reference
    Stream<String> firstLetters = cities.stream().map(c -> c.substring(0, 1)); // Use map() with a lambda expression
  }

  @Test
  void substreams() {
    // Use limit() to end after 100 elements or when the stream ends (in this case stream is infinite)
    Stream<Double> randoms = Stream.generate(Math::random).limit(100);

    // Do the opposite and skip the first n elements
    String months = "Jan,Feb,Mar";
    Stream<String> sublist = Stream.of(months.split(",")).skip(1); // Skip Jan
  }

  @Test
  void removeDuplicates() {
    Stream<String> uniqueMonths = Stream.of("Jan", "Feb", "Mar", "Jan", "Feb").distinct();
  }

  @Test
  void sortingStreams() {
    // The sorted() method can work with streams of Comparable and Comparator elements
    Stream<String> longestFirst = cities.stream().sorted(Comparator.comparing(String::length).reversed());
  }

  @Test
  void reductions() { // Reductions is the name for terminal operations, reduce stream to non-stream value
    // Optional provides a better way of handling an empty stream, rather than dealing with null
    // Once a terminal operation is used on a stream, the stream can no longer be used
    Optional<String> largest = cities.stream().max(String::compareToIgnoreCase);
    assertEquals("Winona", largest.orElse(""));

    // findFirst() returns first value in non-empty collection, useful when combined with filter
    Optional<String> startsWithM = cities.stream().filter((c -> c.startsWith("M"))).findFirst();
    assertEquals("Minneapolis", startsWithM.orElse("")); // Found first city starting with 'M'

    // If you just want to know if there is a match
    boolean hasMatch = cities.stream().anyMatch(c -> c.startsWith("E"));
    assertTrue(hasMatch);
  }

  @Test
  void collectingResults() {

    // Iterate over cities with length > 7
    cities.stream().filter(c -> c.length() > 7).forEach(System.out::println);

    String[] result = cities.stream().toArray(String[]::new); // stream.toArray() has type Object[]

    List<String> list = cities.stream().collect(Collectors.toList());

    IntSummaryStatistics summary = cities.stream().collect(Collectors.summarizingInt(String::length));
    double averageWordLength = summary.getAverage();
    double maxWordLength = summary.getMax();
  }

  @Test
  void anotherExample() {
    List<String> bingoNumbers = Arrays.asList("N40", "N36", "B12", "B1", "G53", "G49", "G60", "G50", "g64", "O71");

    bingoNumbers
        .stream()
        .map(String::toUpperCase)
        .filter(s->s.startsWith("G"))
        .sorted()
        .forEach(System.out::println); // forEach is a terminal operation

    List<String> gNumbers = bingoNumbers
        .stream()
        .map(String::toUpperCase)
        .filter(s->s.startsWith("G"))
        .sorted()
        .collect(Collectors.toList()); // can also collect to a list
  }

  @Test
  void flatMapToCombineMultipleListsIntoOneStream() {
    Employee jim = new Employee("Jim");
    Employee jane = new Employee("Jane");
    Employee steve = new Employee("Steve");
    Employee karen = new Employee("Karen");

    Department hr = new Department("Human Resources");
    hr.addEmployee(jim);
    hr.addEmployee(jane);
    Department acct = new Department("Accounting");
    acct.addEmployee(steve);
    acct.addEmployee(karen);

    List<Department> departments = new ArrayList<>();
    departments.add(hr);
    departments.add(acct);

    // This combines multiple lists into one stream
    long allEmployeeCount = departments.stream().flatMap(department -> department.getEmployees().stream()).count();
    assertEquals(4, allEmployeeCount);
  }
}

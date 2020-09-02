package io;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class FileReadWriteTests {
  String fileName = "mytestfile.txt";
  String fileForReadTests = "src/test/resources/my_test_file_for_file_read.txt";

  // Old way, try with resources came along in JDK7
  @Test
  void writeAndReadFileBeforeJdk7() {
    Writer writer = null;
    String contentsToWriteToFile = "Hello World < jdk7" + System.getProperty("line.separator");
    try {
      writer = new BufferedWriter(new FileWriter(fileName));
      writer.write(contentsToWriteToFile);
      // writer.close(); // Can't try and close file here because if exception writing to file, will never get here
    } catch(IOException e) {
      e.printStackTrace();
    } finally { // finally block always executed
      try {
        if (writer != null) {
          writer.close(); // Closing the file may cause an exception
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    // Now read contents
    BufferedReader reader = null;
    StringBuilder contentsReadFromFile = new StringBuilder();
    try {
      reader = new BufferedReader(new FileReader(fileName));
      String line = null;
      while ((line = reader.readLine()) != null) {
        contentsReadFromFile.append(line);
        contentsReadFromFile.append(System.getProperty("line.separator")); // BufferedReader.readLine() doesn't read line separator from file
      }
      // reader.close(); // Can't try and close file here because if exception writing to file, will never get here
    } catch(IOException e) {
      e.printStackTrace();
    } finally { // finally block always executed
      try {
        if (reader != null) {
          reader.close(); // Closing the file may cause an exception
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    assertEquals(contentsToWriteToFile, contentsReadFromFile.toString());
  }

  // New way, try with resources came along in JDK7
  @Test
  void writeAndReadFileWithJdk7TryWithResources() {
    Path file = Paths.get(fileName); // Path and Paths are from JDK7 too and are preferable to pre JDK7 classes
    String contentsToWriteToFile = "Hello World >= jdk7" + System.getProperty("line.separator");
    try (Writer writer = Files.newBufferedWriter(file)) {
      writer.write(contentsToWriteToFile);
    } catch(IOException e) {
      e.printStackTrace();
    }

    // Now read contents
    StringBuilder contentsReadFromFile = new StringBuilder();
    try (BufferedReader reader = Files.newBufferedReader(file)) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        contentsReadFromFile.append(line);
        contentsReadFromFile.append(System.getProperty("line.separator")); // BufferedReader.readLine() doesn't read line separator from file
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
    assertEquals(contentsToWriteToFile, contentsReadFromFile.toString());
  }

  // Scanners are useful for reading structured data like numbers and words with delimiters
  @Test
  void readFileWithScannerBeforeJdk7() {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new FileReader(fileForReadTests));
      scanner.useDelimiter(",");
      while(scanner.hasNextLine()) { // Yes, a contrived example
        assertEquals("MN", scanner.next());
        scanner.skip(scanner.delimiter());
        assertEquals("CA", scanner.nextLine());
      }
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      if (scanner != null) {
        scanner.close();
      }
    }
  }

  // Scanners are useful for reading structured data like numbers and words with delimiters
  @Test
  void readFileWithScannerWithJdk7TryWithResources() {
    Path file = Paths.get(fileForReadTests); // Path and Paths are from JDK7 too and are preferable to pre JDK7 classes
    try (Scanner scanner = new Scanner(file)) {
      scanner.useDelimiter(",");
      while(scanner.hasNextLine()) { // Yes, a contrived example
        assertEquals("MN", scanner.next());
        scanner.skip(scanner.delimiter());
        assertEquals("CA", scanner.nextLine());
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void readAllLinesOfFile() {
    List<String> lines = null;
    try {
      lines = Files.readAllLines(Paths.get(fileForReadTests));
    } catch(IOException e) {
      e.printStackTrace();
    }
    assertEquals(3, lines.size());
  }
}

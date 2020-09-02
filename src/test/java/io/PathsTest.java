package io;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PathsTest {

  @Test
  void pathConstruction() {
    // Paths.get() joins strings with the default path separator for the current operating system
    Path absolute = Paths.get("/", "Users", "joe");
    Path relative = Paths.get("src", "test", "resources", "my_test_file_for_file_read");

    // You can also add path separators yourself
    absolute = Paths.get("/Users/joe");
  }

  @Test
  void resolvePaths() {
    Path q = Paths.get("/", "Users", "joe");
    Path p = Paths.get("src");
    assertEquals(q, p.resolve(q)); // If q is absolute, result is q
    q = Paths.get("test");
    assertEquals("src/test", (p.resolve(q)).toString()); // If q not absolute, the p/q
  }

  @Disabled("Don't have code to clean up created files and directories for this test")
  @Test
  void createFilesAndDirectories() throws IOException {
    // All but last item in path must already exist. Here we create an intermediate directory
    Path path = Paths.get("testdir");
    Files.createDirectories(path);

    // Create an empty file
    path = Paths.get("testdir", "junk.txt");
    Files.createFile(path); // Throws exception if already exists

    // Check paths
    Files.exists(path); // Check if already exists
    Files.isDirectory(path); // See if path is a directory or sym link
    Files.isRegularFile(path); // See if path is a file
  }

  @Disabled("Don't have code to clean up created files and directories for this test")
  @Test
  void copyMoveDeleteFile() throws IOException {
    Path fromPath = Paths.get("path1");
    Path toPath = Paths.get("path2");
    Files.copy(fromPath, toPath);
    Files.move(fromPath, toPath);
    Files.delete(fromPath); // Throws exception if file doesn't exist
    boolean deleted = Files.deleteIfExists(fromPath); // Won't matter if doesn't exist

    // If destination exists, use REPLACE_EXISTING to avoid exception and allow overwrite
    // Use COPY_ATTRIBUTES to copy all file attributes
    Files.copy(fromPath, toPath, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
  }
}

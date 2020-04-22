# java-concepts
A project where I learn/practice Java concepts

#### Run the build
- From command line: `./gradlew build`
- Run only Checkstyle and SpotBugs: `./gradle check`.  This runs the `checkstyleMain, checkstyleTest, spotbugsMain, spotbugsTest` Gradle tasks. Gradle will not run the `check` task on subsequent runs if there haven't been any code changes.
- Run only Checkstyle and SpotBugs even if already run, and without tests: `./gradlew clean check -x test`.
- From IntelliJ: Create a run configuration for the `test` folder by right-clicking on it and selecting `Run tests in ...`

Notes:
- For `System.out.println("Hello");`, `System.out` is an object; an instance of the `PrintStream` class. The `PrintStream` class has methods `println()` , `print()`, etc.

References:
- Core Java SE 9 for the Impatient, Second Edition, by Cay Horstmann

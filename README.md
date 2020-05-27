# java-concepts
A project where I learn/practice Java concepts

#### Run the build
- From command line: `./gradlew build`
- Run only Checkstyle and SpotBugs: `./gradle check`.  This runs the `checkstyleMain, checkstyleTest, spotbugsMain, spotbugsTest` Gradle tasks. Gradle will not run the `check` task on subsequent runs if there haven't been any code changes.
- Run only Checkstyle and SpotBugs even if already run, and without tests: `./gradlew clean check -x test`.
- From IntelliJ: Create a run configuration for the `test` folder by right-clicking on it and selecting `Run tests in ...`

#### Notes:
- For `System.out.println("Hello");`, the `System` class declares a constant `public static final PrintStream out` (One of the few times a constant isn't uppercase). So `System.out` is an object; an instance of the `PrintStream` class. The `PrintStream` class has methods `println()` , `print()`, etc.
- Strings are immutable. If you have a string `str`, then `str = str + 'hi'`, the word 'hi' isn't appended to `str`, instead a new string is created.

#### Differences between abstract classes and interfaces:
- Abstract classes are similar to interfaces in that you cannot instantiate them, and they may contain a mix of methods declared with and without implementation
- Abstract classes can have fields that ar not static and final, and you can have public, protected, and private concrete methods.
- An abstract class can extend only one parent class, but can implement multiple interfaces.
- The subclass of an abstract class usually implements the abstract methods of the parent abstract class. But if it doesn't, it too must also be declared abstract.
- An interface just declares the signature of methods, not the implementation.
- You cannot instantiate an interface, even though they may have methods implemented.
- All interface methods are automatically public and abstract
- An interface can extend another interface.
- Interfaces can contain default methods that are implemented. They can also have private methods.

References:
- Core Java SE 9 for the Impatient, Second Edition, by Cay Horstmann
- Udemy Java Programming Masterclass

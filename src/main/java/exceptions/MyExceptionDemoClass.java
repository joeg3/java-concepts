package exceptions;

public class MyExceptionDemoClass {

  public String reactionToTeam(String team) throws MyException {
    if (team.equalsIgnoreCase("packers")) {
      return "Yay";
    } else if (team.equalsIgnoreCase("bears")) {
      throw new MyException("boo");
    } else {
      return "meh";
    }
  }

  public void showTryWithResources() {
    // To solve the problem of closing resources if an exception was thrown, if the resources are specified
    // in the header of a try statement and belongs to a class implementing the AutoCloseable interface, the
    // resource will automatically be closed regardless if exception thrown or not

//    PrintWriter out = new PrintWriter("somefile.txt");
//    try(out) {
//      for (String line : lines) {
//        out.println(line.toLowerCase());
//      }
//    }
    // out.close() effectively called here
  }

  public void showFinallyClause() {
    // The finally clause is executed when the try block comes to an end, either normally or from an exception.
    // This is useful for cleaning up something that isn't AutoCloseable
    try {

    } catch (Exception e) {

    } finally {
      // Do cleanup here.
      // Don't put a return statement here. If the body of the try block has a return statement, the one here replaces
      // the one in the try block.
      // Also avoid throwing exceptions in the finally block
    }
  }
}

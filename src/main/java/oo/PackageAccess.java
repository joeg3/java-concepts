package oo;

public class PackageAccess {

  public void publicCanBeUsedByAnyClass() {}

  private void privateCanOnlyBeUsedByThisClass() {}

  void defaultCanOnlyBeUsedByClassesAndMethodsInThisPackage() {}

  protected void protectedMethods() {
    // Can be accessed within the enclosing class
    // Can be accessed by other classes in the same package
    // Can be accessed by subclasses regardless of package
  }

}

package oo;

public class PackageAccess {

  public void publicCanBeUsedByAnyClass() {}

  private void privateCanOnlyBeUsedByThisClass() {}

  void defaultCanOnlyBeUsedByClassesAndMethodsInThisPackage() {}

}

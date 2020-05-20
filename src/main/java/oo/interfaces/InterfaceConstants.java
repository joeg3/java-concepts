package oo.interfaces;

public interface InterfaceConstants {

  // You cannot have instance variables in an interface
  // Any variable defined in an interface is automatically public static final
  // Other classes can refer to it by it's qualified name: InterfaceConstants.MY_CONSTANT
  // An implementing class like InterfaceConstantsImpl can omit the InterfaceConstants
  // qualifier and just use MY_CONSTANT
  int MY_CONSTANT = 9;
}



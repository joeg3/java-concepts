package oo;

import java.text.NumberFormat;

public class FactoryMethods {

  // These two factory methods return an instance of the NumberFormat class
  // An advantage of not using constructors is that these can have different names,
  // constructors have the same name but different parameters.
  // Factory methods can also return an object of a subclass
  NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
  NumberFormat percentFormatter = NumberFormat.getPercentInstance();
}

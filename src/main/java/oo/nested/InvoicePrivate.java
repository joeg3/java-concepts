package oo.nested;

import java.util.ArrayList;

/**
 * This is an example of a Nested Class that is private
 * I think if inside class is static, it's called a Nested Class
 * Use a static nested class when the instances of the nested class don't need to know
 * to which instance of the enclosing class they belong.
 */
public class InvoicePrivate {
  private static class Item { // Private, only Invoice methods can access it.
    String description; // Since class is private, unnecessary to make instance variables of Item private
    int quantity;       // If Item were public, would want to use normal encapsulation, making member variables
    double unitPrice;   // private and initialize with constructor.

    double price() { return quantity * unitPrice; }
  }

  private ArrayList<Item> items = new ArrayList<>();

  public void addItem(String description, int quantity, double unitPrice) {
    Item newItem = new Item();
    newItem.description = description;
    newItem.quantity = quantity;
    newItem.unitPrice = unitPrice;
    items.add(newItem);
  }
}

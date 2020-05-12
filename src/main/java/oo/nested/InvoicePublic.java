package oo.nested;

import java.util.ArrayList;

/**
 * This is an example of a Nested Class that is public
 * I think if inside class is static, it's called a Nested Class
 * Use a static nested class when the instances of the nested class don't need to know
 * to which instance of the enclosing class they belong.
 */
public class InvoicePublic {
  public static class Item { // Public, other classes can use it
    private String description;
    private int quantity;
    private double unitPrice;

    public Item(String description, int quantity, double unitPrice) {
      this.description = description;
      this.quantity = quantity;
      this.unitPrice = unitPrice;
    }

    public double price() { return quantity * unitPrice; }
  }

  private ArrayList<Item> items = new ArrayList<>();

  public void add(Item item) { items.add(item); }
}

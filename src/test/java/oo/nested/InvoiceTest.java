package oo.nested;

import org.junit.jupiter.api.Test;

public class InvoiceTest {

  private InvoicePrivate invoicePrivate = new InvoicePrivate();
  private InvoicePublic invoicePublic = new InvoicePublic();;

  @Test
  void createItemsPrivate() {
    // Items private and not visible, created internally
    invoicePrivate.addItem("Toaster", 2, 19.99);
  }

  @Test
  void createItemsPublic() {
    // Items are public, so anyone can use them
    InvoicePublic.Item newItem = new InvoicePublic.Item("Toaster", 2, 19.99);
    invoicePublic.add(newItem);
  }
}

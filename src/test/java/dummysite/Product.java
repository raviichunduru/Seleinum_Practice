package dummysite;

public enum Product {

  IPHONE14("iPhone 14"),
  DELLINSPIRON("Dell Inspiron");

  private String productName;

  Product(String productName) {
    this.productName = productName;
  }

  public String getProductName() {
    return productName;
  }
}

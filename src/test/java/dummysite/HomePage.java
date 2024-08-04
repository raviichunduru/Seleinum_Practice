package dummysite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class HomePage {
  public ProductDetailPage SearchForProductAndClick(Product product) {

    // search by product.getProductName() and click product link
    return new ProductDetailPage(new ChromeDriver());
  }
}

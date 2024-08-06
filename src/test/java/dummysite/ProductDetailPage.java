package dummysite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import static dummysite.UserType.NORMAL;
import static dummysite.UserType.PRIME;
import static dummysite.UserType.STANDARD;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductDetailPage {

  private WebDriver driver;
  private WebElement shippingCharges;

  public ProductDetailPage(WebDriver driver) {
    this.driver = driver;
    this.shippingCharges = driver.findElement(By.xpath(""));
  }

  private static final Map<UserType, Predicate<WebElement>> shippingChargeValidationMap = new HashMap<>();

    static
    {
      shippingChargeValidationMap.put(PRIME, shippingCharges -> shippingCharges.getText().equals("Free"));
      shippingChargeValidationMap.put(STANDARD, shippingCharges -> shippingCharges.getText().equals("50 Rs"));
      shippingChargeValidationMap.put(NORMAL, shippingCharges -> shippingCharges.getText().equals("500 Rs"));
    }

  public void ValidateShippingCharges(UserType userType) {
      assertThat(shippingChargeValidationMap.get(userType).test(shippingCharges))
        .as("Shipping charges validation failed for " +userType)
        .isTrue();
  }
}

package selenium4;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsTest {
  public static void main(String[] args) {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://rahulshettyacademy.com/angularpractice/");

    By locatorForNameText = By.tagName("label");
    By locatorForUserNameInputField = By.xpath("//input[@name='name' and @class='form-control ng-untouched ng-pristine ng-invalid'] ");

    // finding name text by specifying relation to input filed
    RelativeLocator.RelativeBy byLocatorForName = RelativeLocator.with(locatorForNameText)
                                                                 .above(locatorForUserNameInputField);

    String actualLabel = chromeDriver.findElement(byLocatorForName).getText();
    String expectedLabel = "Name";
    Assertions.assertThat(actualLabel).isEqualTo(expectedLabel);
  }
}

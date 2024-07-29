package selenium4;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class RelativeLocatorsTests {

  @Test
  public void aboveLocatorTest () {
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

    chromeDriver.quit();
  }

  @Test
  public void leftLocatorTest () {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://rahulshettyacademy.com/angularpractice/");

    By locatorForCheckBox = By.tagName("input");
    By locatorForCheckBoxWithText = By.xpath("//label[text()='Check me out if you Love IceCreams!']");

    // finding checkbox by specifying relation to text filed (which is on left it)
    RelativeLocator.RelativeBy byLocatorForCheckBox = RelativeLocator.with(locatorForCheckBox)
      .toLeftOf(locatorForCheckBoxWithText);

    WebElement checkBox = chromeDriver.findElement(byLocatorForCheckBox);
    checkBox.click();
    boolean isSelected = checkBox.isSelected();

    Assertions.assertThat(isSelected);
    chromeDriver.quit();
  }

}

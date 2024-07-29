package selenium4;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

public class HandlingTwoApplications_InTwoTabs {

  @Test(description = "To demonstrate how user can handle two tabs : open 2 different applications in two tabs, get text fom 2nd tab..load into field in tab 1")
  public void multipleWindows () {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://rahulshettyacademy.com/angularpractice/");
    chromeDriver.switchTo().newWindow(WindowType.TAB);

    Set<String> windowHandles = chromeDriver.getWindowHandles();
    Iterator<String> iterator = windowHandles.iterator();
    String parentHandle = iterator.next();
    String childHandle = iterator.next();

    chromeDriver.switchTo().window(childHandle);
    chromeDriver.get("https://rahulshettyacademy.com/");

    String textToCopy =
      chromeDriver.findElements(By.xpath("//a[contains(@href,\"https://courses.rahulshettyacademy.com/p\")]")).get(1).getText();

    chromeDriver.switchTo().window(parentHandle);
    WebElement nameField =
      chromeDriver.findElement(By.xpath("//input[@name='name' and @class='form-control ng-untouched ng-pristine ng-invalid']"));
    nameField.sendKeys(textToCopy);

    Assertions.assertThat(nameField.getAttribute("value")).isEqualTo(textToCopy);
  }
}

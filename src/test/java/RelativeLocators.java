import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class RelativeLocators {
  @Test
  public void findingElements_With_RelativeLocators () {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    chromeDriver.manage().window().maximize();

    Wait<WebDriver> wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(3));
    WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

    RelativeLocator.RelativeBy relativeLocatorForPasswordField = RelativeLocator.with(By.tagName("input")).below(userName);
    chromeDriver.findElement(relativeLocatorForPasswordField).sendKeys("admin123");

    WebElement userNameText = chromeDriver.findElement(By.xpath("//label[contains(text(),'Username')]"));
    RelativeLocator.RelativeBy relativeLocatorForUserNameField = RelativeLocator.with(By.tagName("input")).below(userNameText);

    chromeDriver.findElement(relativeLocatorForUserNameField).sendKeys("Admin");
    chromeDriver.findElement(By.xpath("//button[@type='submit']")).click();

    Assert.assertEquals(chromeDriver.getTitle(),"OrangeHRM");
    chromeDriver.quit();
  }
}

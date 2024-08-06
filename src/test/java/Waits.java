import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {

  @Test
  public void ImplicitWait () {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // global wait

    chromeDriver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    chromeDriver.findElement(By.id("adder")).click();

    WebElement redBox = chromeDriver.findElement(By.id("box0"));

    Assert.assertEquals("redbox",redBox.getAttribute("class"));
    chromeDriver.quit();
  }

  @Test
  public void ExplicitWait () {
    WebDriver chromeDriver = new ChromeDriver();

    chromeDriver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    chromeDriver.findElement(By.id("reveal")).click();

    WebDriverWait wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(3));
    WebElement revealed = wait.until(ExpectedConditions.elementToBeClickable(By.id("revealed")));
    revealed.sendKeys("testing");

    Assert.assertEquals(revealed.getAttribute("value"),"testing");
    chromeDriver.quit();
  }

  @Test
  public void ExplicitWait_Lambda () {
    WebDriver chromeDriver = new ChromeDriver();

    chromeDriver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    chromeDriver.findElement(By.id("reveal")).click();

    WebElement revealed = chromeDriver.findElement(By.id("revealed"));
    WebDriverWait  wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(3));
    wait.until(element -> revealed.isDisplayed());

    revealed.sendKeys("testing");
    Assert.assertEquals(revealed.getAttribute("value"),"testing");
    chromeDriver.quit();
  }

  @Test
  public void FluentWait () {
    WebDriver chromeDriver = new ChromeDriver();

    chromeDriver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    chromeDriver.findElement(By.id("reveal")).click();

    WebElement revealed = chromeDriver.findElement(By.id("revealed"));

    Wait<WebDriver> wait = new FluentWait<>(chromeDriver)
      .withTimeout(Duration.ofSeconds(3))
      .pollingEvery(Duration.ofMillis(500))
      .ignoring(StaleElementReferenceException.class, ElementNotInteractableException.class);

    wait.until( element -> {
      revealed.sendKeys("testing");
      return true;
    });

    Assert.assertEquals(revealed.getAttribute("value"),"testing");
    chromeDriver.quit();
  }
}

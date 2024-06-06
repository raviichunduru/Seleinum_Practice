import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Iframes {
  private WebDriver chromeDriver;

  @BeforeTest
  private void setUp() {
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://www.w3schools.com/html/html_iframe.asp");
    chromeDriver.manage().window().maximize();
  }
  @Test
  public void iFramesDemo () {
    chromeDriver.switchTo().frame(1);
    chromeDriver.findElement(By.xpath("//a[contains(text(),'Next')]")).click();
    chromeDriver.switchTo().defaultContent();
    chromeDriver.findElement(By.xpath("//a[normalize-space()='HTML Id']")).click();
    Assert.assertEquals(chromeDriver.findElement(By.tagName("h1")).isDisplayed(),true);
  }

  @AfterMethod
  private void tearDown() {
    chromeDriver.quit();
  }
}

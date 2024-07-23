package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdowns_NonSelect {

  private WebDriver chromeDriver;

  @BeforeTest
  private void setUp() {
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://www.bstackdemo.com/");
    chromeDriver.manage().window().maximize();
  }

  @Test
  public void handling_DropDownValues_InList_and_Iterating() {

    chromeDriver.findElement(By.tagName("select")).click();
    List<WebElement> options = chromeDriver.findElements(By.xpath("//option"));

    String optionToSelect = "Highest to lowest";

    for(WebElement element : options) {
      if(element.getText().equalsIgnoreCase(optionToSelect)) {
        element.click();
        break;
      }
    }
  }

  @Test
  public void selecting_DropDownValue_Directly() {

    chromeDriver.findElement(By.tagName("select")).click();

    //WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='highestprice']"))).click();

    chromeDriver.findElement(By.xpath("//option[@value='highestprice']")).click();
  }

  @Test
  public void selecting_DropDownValue_Using_JavaScriptExecutor() {
    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
    WebElement dropDown = chromeDriver.findElement(By.tagName("select"));

    js.executeScript("arguments[0].value='highestprice'",dropDown);
  }

  @Test
  public void selecting_DropDownValue_Using_SendKeys() {
    //chromeDriver.findElement(By.tagName("select")).sendKeys("highestprice");
    chromeDriver.findElement(By.tagName("select")).sendKeys("lowestprice");
  }

  @AfterMethod
  private void tearDown() {
    //chromeDriver.quit();
  }
}

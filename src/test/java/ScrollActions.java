import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollActions {
  private WebDriver chromeDriver;

  @BeforeTest
  private void setUp() {
    chromeDriver = new ChromeDriver();
    chromeDriver.get("http://www.amazon.in/");
    chromeDriver.manage().window().maximize();
  }
  @Test
  public void scrollActions () throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;

    //scroll to bottom of page
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    //Thread.sleep(3000);

    //scroll by x,y offset
    js.executeScript("window.scrollTo(10, 10)");
    //Thread.sleep(3000);

    //scroll till an element
    WebElement helpLink = chromeDriver.findElement(By.xpath("//a[text()='Help']"));
    js.executeScript("arguments[0].scrollIntoView();", helpLink);
    //Thread.sleep(3000);

    //scroll right,left,down.up
    chromeDriver.manage().window().setSize(new Dimension(800,600));
    Thread.sleep(3000);
    js.executeScript("window.scrollBy(3000,0)");
    Thread.sleep(3000);
    js.executeScript("window.scrollBy(-3000,0)");
    Thread.sleep(3000);
    js.executeScript("window.scrollBy(0,3000)");
    Thread.sleep(3000);
    js.executeScript("window.scrollBy(0,-3000)");
    Thread.sleep(3000);
  }

  @AfterMethod
  private void tearDown() {
    chromeDriver.quit();
  }
}

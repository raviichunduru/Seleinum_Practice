import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseActions {
  private WebDriver chromeDriver;

  @BeforeTest
  private void setUp() {
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://jqueryui.com/slider/");
    chromeDriver.manage().window().maximize();
  }

  @Test
  public void moveSlider () throws InterruptedException {
    chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//iframe[@class='demo-frame']")));
    WebElement slider = chromeDriver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
    Actions actions = new Actions(chromeDriver);
    actions.clickAndHold(slider).moveByOffset(40,0).build().perform();
  }

  @AfterMethod
  private void tearDown() {
    chromeDriver.quit();
  }
}
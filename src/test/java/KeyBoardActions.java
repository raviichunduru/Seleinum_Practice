import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyBoardActions {
  private WebDriver chromeDriver;

  @BeforeTest
  private void setUp() {
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://extendsclass.com/text-compare.html");
    chromeDriver.manage().window().maximize();
  }

  @Test
  public void keyBoardActionsDemo () {
    WebElement sourceElement =
      chromeDriver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[@class='row-container editor-container']"));

    WebElement destinationElement =
      chromeDriver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]"));

    Actions action = new Actions(chromeDriver);

    /*action.click(sourceElement).keyDown(Keys.CONTROL).keyDown("a").keyUp(Keys.CONTROL).keyUp("a").
    keyDown(Keys.CONTROL).keyDown("c").keyUp(Keys.CONTROL).keyUp("c").build().perform();

    action.click(destinationElement).keyDown(Keys.CONTROL).keyDown("a").keyUp(Keys.CONTROL).keyUp("a").keyDown(Keys.CONTROL).keyDown("v").keyUp(Keys.CONTROL).keyUp("v").build().perform();
*/

    action.sendKeys(sourceElement,Keys.CONTROL,"a",Keys.CONTROL,"c")
          .sendKeys(destinationElement,Keys.CONTROL,"a",Keys.CONTROL,"v")
          .build().perform();

    Assert.assertEquals(sourceElement.getText(),destinationElement.getText());
  }

  @AfterMethod
  private void tearDown() {
    chromeDriver.quit();
  }
}

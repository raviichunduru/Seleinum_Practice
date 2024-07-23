package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.List;

public class Handling_Dropdowns_Using_Actions {

  private WebDriver chromeDriver;

  @Test
  public void handling_Dropdowns_Using_Actions() {

    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://www.browserstack.com/");
    chromeDriver.manage().window().maximize();

    WebElement element = chromeDriver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));

    Actions actions = new Actions(chromeDriver);
    actions.moveToElement(element).perform();

    chromeDriver.findElement(By.xpath("//span[text()='Documentation']")).click();
  }
}

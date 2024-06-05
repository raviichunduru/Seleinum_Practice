import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetActiveElement {
  @Test
  public void getActiveElement() {

      WebDriver driver = new ChromeDriver();
      driver.get("http://www.google.com");
      driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");

      // Get attribute of current active element
      System.out.println("Title of Active Element : " +driver.switchTo().activeElement().getAttribute("title"));

    System.out.println("Title of current page = " + driver.getTitle());
    System.out.println("Current URL = " + driver.getCurrentUrl());

    driver.quit();
  }
}

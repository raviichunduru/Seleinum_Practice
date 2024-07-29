package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetDimensionsOfWebElement {

  @Test
  public void getDimensionsOfWebElement() {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://rahulshettyacademy.com/angularpractice/");

    WebElement bannerElement = chromeDriver.findElement(By.xpath("//div[@class='jumbotron']"));
    Dimension dimension = bannerElement.getRect().getDimension();
    System.out.println("Height = " + dimension.getHeight());
    System.out.println("Width = " + dimension.getWidth());

    chromeDriver.quit();
  }
}

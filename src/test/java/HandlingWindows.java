import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class HandlingWindows {
  @Test
  public void handlingWindowsDemo () {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://demoqa.com/browser-windows");
    chromeDriver.manage().window().maximize();


    String parentWindowHandle = chromeDriver.getWindowHandle();
    //System.out.println("Parent Window Handle = " + parentWindowHandle);

    chromeDriver.findElement(By.xpath("//button[@id='windowButton']")).click();
    //chromeDriver.findElement(By.xpath("//button[@id='tabButton']")).click();
    //chromeDriver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();

    switchToChildWindowAndPerformSomeAction(chromeDriver, parentWindowHandle);
    chromeDriver.quit();
  }

  private static void switchToChildWindowAndPerformSomeAction(WebDriver chromeDriver, String parentWindowHandle) {
    Set<String> windowHandles = chromeDriver.getWindowHandles();
    Iterator<String> iterator = windowHandles.iterator();

    while (iterator.hasNext()) {
      String childWindowHandle = iterator.next();
      if(!parentWindowHandle.equalsIgnoreCase(childWindowHandle)) {
        System.out.println("Child Window ID :  " + childWindowHandle);
        chromeDriver.switchTo().window(childWindowHandle);
        System.out.println("Child Window Title :  " + chromeDriver.getTitle());
        chromeDriver.close();
      }
    }
    chromeDriver.switchTo().window(parentWindowHandle);
  }
}

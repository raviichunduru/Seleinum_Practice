import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingWindowOrTab_Selenium4 {

  private WebDriver chromeDriver;

  @BeforeTest
  private void setUp() {
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://demoqa.com/browser-windows");
    chromeDriver.manage().window().maximize();
  }

  @Test
  public void handlingWindowOrTab_Selenium4 () {
    String parentWindowHandle = chromeDriver.getWindowHandle();
    System.out.println("Parent Window Handle = " + parentWindowHandle);

    chromeDriver.findElement(By.xpath("//button[@id='windowButton']")).click();
    openNewWindowAndPerformAction();
    switchToParentWindow(parentWindowHandle);
    chromeDriver.findElement(By.xpath("//button[@id='tabButton']")).click();
    openNewTabAndPerformAction();
    switchToParentWindow(parentWindowHandle);
    tearDown();
  }

  @AfterMethod
  private void tearDown() {
    chromeDriver.quit();
  }

  private void switchToParentWindow( String parentWindowHandle) {
    chromeDriver.switchTo().window(parentWindowHandle);
  }

  private void openNewTabAndPerformAction() {
    chromeDriver.switchTo().newWindow(WindowType.TAB);
    System.out.println("Child Tab Handle = " + chromeDriver.getWindowHandle());
    System.out.println("Child Tab Title = " + chromeDriver.getTitle());
    chromeDriver.close();
  }

  private void openNewWindowAndPerformAction() {
    chromeDriver.switchTo().newWindow(WindowType.WINDOW);
    System.out.println("Child Window Handle = " + chromeDriver.getWindowHandle());
    System.out.println("Child Window Title = " + chromeDriver.getTitle());
    chromeDriver.close();
  }
}

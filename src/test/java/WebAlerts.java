import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebAlerts {
  @Test
  public void WebAlertsDemo () throws InterruptedException {
      WebDriver chromeDriver = new ChromeDriver();
      chromeDriver.get("https://demoqa.com/alerts");
      chromeDriver.manage().window().maximize();

      chromeDriver.findElement(By.xpath("//button[@id='alertButton']")).click();
      Thread.sleep(3000);
      chromeDriver.switchTo().alert().accept();

      chromeDriver.findElement(By.xpath("//button[@id='confirmButton']")).click();
      Thread.sleep(3000);
      Alert confirmAlert = chromeDriver.switchTo().alert();
      System.out.println("confirmAlert.getText() = " + confirmAlert.getText());
      confirmAlert.dismiss();

      chromeDriver.findElement(By.xpath("//button[@id='promtButton']")).click();
      Thread.sleep(3000);
      Alert promtAlert = chromeDriver.switchTo().alert();
      promtAlert.sendKeys("Hi");
      Thread.sleep(3000);
      promtAlert.dismiss();

      chromeDriver.quit();
    }
  }

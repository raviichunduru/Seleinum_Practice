import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileUploadTest {


  @Test
  void testFileUpload() throws InterruptedException {
    WebDriver chromeDriver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(3));


    chromeDriver.get("https://blueimp.github.io/jQuery-File-Upload/");

    WebElement uploadField = chromeDriver.findElement(By.xpath("//input[@name='files[]']"));
    uploadField.sendKeys(new File("./screenshots1.jpeg").getAbsolutePath());
    chromeDriver.findElement(By.xpath("//span[text()='Start upload']")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']"))).click();

    //Thread.sleep(5);
    //chromeDriver.quit();

  }
}

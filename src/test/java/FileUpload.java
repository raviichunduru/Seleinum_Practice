import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUpload {

  @Test
  public void verifyFileUpload() {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://the-internet.herokuapp.com/upload");
    String filePath = System.getProperty("user.dir")+"/fileupload.txt";

    chromeDriver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(filePath);
    chromeDriver.findElement(By.xpath("//input[@id='file-submit']")).click();

    Wait<WebDriver> wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(3));
    WebElement uploadConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='uploaded-files']")));

    Assert.assertEquals("fileupload.txt",uploadConfirmation.getText());
    chromeDriver.quit();
  }
}

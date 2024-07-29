package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.media.model.Timestamp;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class TakingScreenshotOfElement {

  @Test()
  public void takeScreenshotOfElement () throws IOException {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://rahulshettyacademy.com/angularpractice/");

    WebElement bannerElement = chromeDriver.findElement(By.xpath("//div[@class='jumbotron']"));
    File bannerScreenshot = bannerElement.getScreenshotAs(OutputType.FILE);

    String timeStamp = new SimpleDateFormat("yyyy-MMM-dd HH-mm-ss").format(new Date());

    Path destinationPath = Path.of(System.getProperty("user.dir") + "/screenshots/bannerScreenshot_"+timeStamp+".png");
    Path sourcePath = bannerScreenshot.toPath();

    Files.copy(sourcePath, destinationPath);

    chromeDriver.quit();
  }
}

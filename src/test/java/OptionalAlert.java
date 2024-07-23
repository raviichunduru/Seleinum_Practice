import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Optional;

public class OptionalAlert {
  @Test
  public void handlingOptionalAlert() throws InterruptedException {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://demoqa.com/alerts");
    chromeDriver.manage().window().maximize();

    chromeDriver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();

    /*
    Here i set wait time as 1 second,, to test if timeout error thrown
    there wont be error.. because we used Optional.ofNullable to handle scenario of alert not shown with in time specified
    if time modified as 5 seconds, alert will show and it gets accepted
    */

    acceptAlertIfPresentElseIgnore (chromeDriver, 1);
    chromeDriver.quit();
  }

  public void acceptAlertIfPresentElseIgnore (WebDriver chromeDriver, int waitTimeInSec) {
    chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeInSec));
    Optional.ofNullable(ExpectedConditions.alertIsPresent().apply(chromeDriver)).ifPresent(popup->popup.accept());
  }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Random {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("http://www.google.com");

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'हिन्दी')]"))).click();

    //driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    driver.navigate().back();
    driver.navigate().forward();

    driver.quit();

  }
}

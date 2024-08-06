import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;

public class RegistrationFormTest {

  private WebDriver chromeDriver;

  @Test
  public void registrationForm() {

    chromeDriver = new ChromeDriver();
    chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // global wait
    chromeDriver.manage().window().maximize();

    chromeDriver.get("https://demo.automationtesting.in/Register.html");
    chromeDriver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("first name");
  }
}

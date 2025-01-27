import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButton {
  private WebDriver chromeDriver;

  @BeforeTest
  private void setUp() {
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://codenboxautomationlab.com/practice/");
    chromeDriver.manage().window().maximize();
  }
  @Test
  public void radioButton () {
    List<WebElement> radioButtons = chromeDriver.findElements(By.xpath("//input[@name='radioButton']"));
    System.out.println(radioButtons.size());

    WebElement radioButton3 = radioButtons.stream()
      .filter(element -> element.getAttribute("value").equalsIgnoreCase("radio3"))
      .findFirst()
      .get();

    radioButton3.click();
    Assertions.assertThat(radioButton3.isSelected());
  }

  @AfterMethod
  private void tearDown() {
    chromeDriver.quit();
  }
}


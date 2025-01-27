import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBox {
  private WebDriver chromeDriver;

  @BeforeTest
  private void setUp() {
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://codenboxautomationlab.com/practice/");
    chromeDriver.manage().window().maximize();
  }
  @Test
  public void checkBox () {
    List<WebElement> checkBoxes = chromeDriver.findElements(By.xpath("//input[contains(@id,'checkBox')]"));
    System.out.println(checkBoxes.size());

    for (WebElement ele : checkBoxes) {
      ele.click();
      Assertions.assertThat(ele.isSelected());
    }
  }

  @AfterMethod
  private void tearDown() {
    chromeDriver.quit();
  }
}


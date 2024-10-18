package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DynamicDropDown {

  WebDriver driver;

  @BeforeTest
  void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://codenboxautomationlab.com/practice/");
  }

  @Test
  void dynamicDropdown() {
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete")));
    element.sendKeys("ind");

    List<WebElement> countriesWithNameAsIndia = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-1']/li")))
                                                    .stream()
                                                    .filter(e -> e.getText().equals("India"))
                                                    .collect(Collectors.toList());
    assertThat(countriesWithNameAsIndia.size()).isEqualTo(1);

    countriesWithNameAsIndia.getFirst().click();
    assertThat(element.getAttribute("value")).isEqualTo("India");
  }

  @AfterTest
  void tearDown() {
    driver.quit();
  }
}

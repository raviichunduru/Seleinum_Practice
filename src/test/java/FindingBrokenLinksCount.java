import io.restassured.RestAssured;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class FindingBrokenLinksCount {

  private WebDriver driver;

  private List<String> validLinks = new ArrayList<>();
  private List<String> brokenLinks = new ArrayList<>();

  @BeforeTest
  void setUp() {
    ChromeOptions options = new ChromeOptions();
    //options.addArguments("--headless=new");

    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.get("https://www.amazon.in/");
  }

  @SneakyThrows
  @Test
  void findingBrokenLinksCount() {
    List<WebElement> elements = driver.findElements(By.tagName("a"));
    log.info("Total links on the page : {}", elements.size());

    elements.parallelStream()
      .map(ele -> ele.getAttribute("href"))
      .filter(stringURL -> Objects.nonNull(stringURL) && !(stringURL.isBlank()))
      .forEach(stringURL -> findIfLinkIsBroken(stringURL));

    log.info("Valid link count : {}", validLinks.size());
    log.info("Broken link count : {}", brokenLinks.size());
  }

  private void findIfLinkIsBroken(String stringURL) {
    try {
      int responseCode = RestAssured.get(stringURL).getStatusCode();

      if (responseCode == 404 || responseCode >= 500) {
        //log.error("Broken link found: {}", stringURL);
        brokenLinks.add(stringURL);
      } else {
        validLinks.add(stringURL);
      }
    } catch (Exception e) {
      //log.error("Error accessing link: {} - Exception type: {}", stringURL, e.getClass().getSimpleName());
    }
  }

  @AfterTest
  void tearDown() {
    driver.quit();
  }
}
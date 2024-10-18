import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BrokenLinks {

  private WebDriver driver;

  private List<String> validLinks = new ArrayList<>();
  private List<String> brokenLinks = new ArrayList<>();

  @BeforeTest
  void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");

    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.get("https://www.amazon.in/");
  }

  @SneakyThrows
  @Test
  void brokenLinks() {
    List<WebElement> elements = driver.findElements(By.tagName("a"));
    System.out.println("Total links on the page: " + elements.size());

    elements.parallelStream()
            .map(ele->ele.getAttribute("href"))
            .filter(stringURL->Objects.nonNull(stringURL) && !(stringURL.isBlank()) )
            .forEach(stringURL-> findIfBrokenLink(stringURL));

    System.out.println("Valid links count: " + validLinks.size());
    System.out.println("Broken links count: " + brokenLinks.size());
  }

  private void findIfBrokenLink(String stringURL) {
    try {
      Response response = RestAssured.head(stringURL);
      int responseCode = response.getStatusCode();

      if (responseCode >= 400 && responseCode < 600) {
        brokenLinks.add(stringURL);
      } else {
        validLinks.add(stringURL);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @AfterTest
  void tearDown() {
    driver.quit();
  }
}


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class ChromeOptions_Arguments_Logs_Demo {

  @Test
  //@Description("To demonstrate different chrome options, adding arguments and updating user actions to log file")
  public void SeleniumTest1() throws InterruptedException {

    ChromeOptions chromeOptions = new ChromeOptions();

    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
    chromeOptions.setAcceptInsecureCerts(true);
    chromeOptions.setPageLoadTimeout(Duration.ofSeconds(10));
    chromeOptions.setScriptTimeout(Duration.ofSeconds(3));

    chromeOptions.addArguments("--start-maximized");
    chromeOptions.addArguments("--window-size=1920,1080");
    //chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("incognito");

    chromeOptions.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking")); // popup's won't be blocked
    chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation")); // info bar will be hidden "chrome being controlled ..."

    ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                                                                     .withLogFile(new File("./logfile"))
                                                                     .withAppendLog(true)
                                                                     .withReadableTimestamp(true)
                                                                     .withLogLevel(ChromiumDriverLogLevel.WARNING).build();

    WebDriver driver = new ChromeDriver(chromeDriverService, chromeOptions);
    driver.get("https://google.com");
    Thread.sleep(3000);

    driver.close();
  }
}

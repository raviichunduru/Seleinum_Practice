import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class IRCTCTest {
  WebDriver driver;

  @BeforeMethod
  public void setUp () {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.irctc.co.in/nget/train-search");
  }

  @Test
  public void testIfUserIsNavigatedTo_BusReservationTab() {
    driver.findElement(By.xpath("//a[text()=' BUSES ']")).click();
    Set<String> windowHandles = driver.getWindowHandles();

   for (String handle : windowHandles) {
      driver.switchTo().window(handle);
      if(driver.getTitle().equalsIgnoreCase("IRCTC Bus - Online Bus Ticket Booking | Bus Reservation")){
       System.out.println("Switched to child window");
       break;
      }
    }
   String expectedURL = driver.getCurrentUrl();
   String actualURL = "https://www.bus.irctc.co.in/home";

   Assert.assertEquals(actualURL,expectedURL);
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}

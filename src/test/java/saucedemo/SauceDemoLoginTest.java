package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceDemoLoginTest {
  ChromeDriver driver = new ChromeDriver();

  public static final By TXT_USER_NAME = By.xpath("//input[@name='user-name']");
  public static final By TXT_PASSWORD = By.xpath("//input[@name='password']");
  public static final By BTN_LOGIN = By.xpath("//input[@id='login-button']");

  @Test
  public void assertThatStandardUserCanLogin() {

    driver.findElement(TXT_USER_NAME).sendKeys("standard_user");
    driver.findElement(TXT_PASSWORD).sendKeys("secret_sauce");
    driver.findElement(BTN_LOGIN).click();

    Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed());
  }

  @BeforeTest
  public void setUp() {
    driver.get("https://www.saucedemo.com/v1/");
  }

  @AfterTest
  public void tearDown() {
    driver.close();
  }
}

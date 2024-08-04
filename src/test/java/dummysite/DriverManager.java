package dummysite;

import org.openqa.selenium.WebDriver;

public class DriverManager {

  ThreadLocal<WebDriver> WebDriver = new ThreadLocal<WebDriver>();

  public WebDriver getDriver() {
    return WebDriver.get();
  }
}

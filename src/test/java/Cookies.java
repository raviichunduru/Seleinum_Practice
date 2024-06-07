import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Cookies {
  private WebDriver chromeDriver;

  @BeforeTest
  private void setUp() {
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://www.lambdatest.com/");
    chromeDriver.manage().window().maximize();
  }

  @Test
  public void handlingCookies() {

    printAllCookies();
    System.out.println("cookie value for the name gclid : " + getParticularCookieValue("gclid"));

    addCookie("mycookiename","mycookievalue");
    System.out.println("cookie value for the name mycookiename : " + getParticularCookieValue("mycookiename"));

    deleteCookie("mycookiename");
    Optional.ofNullable(getParticularCookieValue("mycookiename"))
            .ifPresentOrElse(System.out::println,()-> System.out.println("cookie not exist or has null value"));

    chromeDriver.manage().deleteAllCookies();
    Assert.assertEquals(chromeDriver.manage().getCookies().size(),0);
  }

  @AfterMethod
  private void tearDown() {
    chromeDriver.quit();
  }

  private String getParticularCookieValue(String cookieName) {
    Cookie cookie = chromeDriver.manage().getCookieNamed(cookieName);
    return Objects.isNull(cookie) ? null : cookie.getValue();
  }

  private void printAllCookies() {
    Set<Cookie> cookies = chromeDriver.manage().getCookies();
    cookies.forEach(cookie -> System.out.println(cookie.getName() + "  " + cookie.getValue()));
  }

  private void addCookie(String cookiename, String cookievalue) {
    chromeDriver.manage().addCookie(new Cookie(cookiename,cookievalue));
  }

  private void deleteCookie(String mycookiename) {
    chromeDriver.manage().deleteCookieNamed("mycookiename");
  }
}

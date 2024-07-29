package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class Dropdowns_Select {

  private WebDriver chromeDriver;

  @BeforeMethod
  private void setUp() {
    chromeDriver = new ChromeDriver();
    chromeDriver.get("https://demoqa.com/select-menu");
    chromeDriver.manage().window().maximize();
  }

  @Test
  private void  handling_Dropdowns_With_SelectTag () {
    WebElement dropdown = chromeDriver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
    Select select = new Select(dropdown);

    select.selectByIndex(1); // Blue
    select.selectByValue("4"); //Purple
    select.selectByVisibleText("Indigo"); // Indigo
  }

  @Test
  private void  selecting_Multiple_Dropdownvalues () {
    WebElement multiSelectDropdown = chromeDriver.findElement(By.xpath("//select[@id='cars']"));
    Select select = new Select(multiSelectDropdown);
    boolean multiple = select.isMultiple();
    if(multiple) {
      System.out.println("This is multi selectable dropdown");
    }
    select.selectByVisibleText("Opel");
    select.selectByValue("audi");

    List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
    Assert.assertListContains(allSelectedOptions,ele->ele.isSelected(),"Expected options are not selected");
  }

  @Test
  private void  deselecting_Multiple_Dropdownvalues () {
    WebElement multiSelectDropdown = chromeDriver.findElement(By.xpath("//select[@id='cars']"));
    Select select = new Select(multiSelectDropdown);
    boolean multiple = select.isMultiple();
    if(multiple) {
      System.out.println("This is multi selectable dropdown");
    }
    select.selectByVisibleText("Opel");
    select.selectByValue("audi");
    select.selectByIndex(1);

    select.deselectByValue("audi");

    List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
    List<String> selectedOptions = new ArrayList<>();

    for (WebElement ele : allSelectedOptions) {
      selectedOptions.add(ele.getText());
      System.out.println("ele.getText() = " + ele.getText());

    }
    Assert.assertEquals(selectedOptions, List.of("Saab","Opel"));
  }

  @Test
  private void  multiSelectDropdownvalues () throws InterruptedException {

    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;

    WebElement dropdown = chromeDriver.findElement(By.xpath("//div[@class=' css-1hwfws3']/div[text()='Select...']"));
    js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
    dropdown.click();

    chromeDriver.findElement(By.xpath("//div[text()='Blue']")).click();
    chromeDriver.findElement(By.xpath("//div[@id='react-select-4-option-3']")).click();
  }

  @AfterMethod
  private void tearDown() {
    //chromeDriver.quit();
  }
}

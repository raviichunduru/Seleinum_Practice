import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPLAssignment {

  public static void main(String[] args) {

    int winCount=0;
    Map<String,Integer> map = new HashMap<>();

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.iplt20.com/");

    driver.findElement(By.xpath("(//a[@data-element_text='POINTS TABLE'])[2]")).click();
    List<WebElement> teams = driver.findElements(By.xpath("//tbody[@id='pointsdata']/tr"));

    for (int i=0; i< teams.size();i++) {
      String teamName = driver.findElement(By.xpath(String.format("(//tr[@class='team0 ng-scope']/td[@class='ih-t-color']/div/h2)[%s]",i+1))).getText();
      List<WebElement> wins = driver.findElements(By.xpath(String.format("(//td[@class='ih-pt-fb-w mob-hide ng-scope'])[%s]/div/span", i+1)));
      for (int j=0; j<5;j++) {
        if(wins.get(j).getText().equalsIgnoreCase("W")) {
          winCount++;
        }
      }
      map.put(teamName,winCount);
      winCount=0;
    }
    for (Map.Entry<String,Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " Wins : " +entry.getValue());
    }
    driver.quit();
  }
}

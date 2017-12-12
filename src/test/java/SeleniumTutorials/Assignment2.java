package SeleniumTutorials;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by Admin on 2/23/2017.
 */
public class Assignment2 {



    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test

    public void startDriver() {


        driver.get("http://new.dental-campus.com/Dentalcase/Caseplans");
        WebElement list = driver.findElement(By.xpath("//*[@id=\"dental-cases-container\"]/div/div[1]"));
        List<WebElement> allItems = list.findElements(By.partialLinkText("esthetic"));

        for (WebElement items : allItems) {
            System.out.println(items.getText());
        }

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        driver.findElement(By.xpath("//*[@id=\"dental-cases-container\"]/div/div[2]/nav/ul/li[2]/a")).click();

    }
}
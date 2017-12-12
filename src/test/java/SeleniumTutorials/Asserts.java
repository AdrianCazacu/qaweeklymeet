package SeleniumTutorials;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Admin on 3/14/2017.
 */
public class Asserts {


    WebDriver driver;

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test


    public void startDriver() throws InterruptedException {

        driver.get("https://www.google.com");


        //Verify
        WebElement element = driver.findElement(By.id("lst-ib"));

       // element.sendKeys("Aloha");

        try {
            Assert.assertFalse("Search complete", driver.findElement(By.name("btnK")).isDisplayed());
        }catch(AssertionError e){


        }






    }

}

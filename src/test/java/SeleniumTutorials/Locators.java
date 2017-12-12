package SeleniumTutorials;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.event.KeyEvent;
import java.security.Key;

/**
 * Created by pc on 1/27/2017.
 */
public class Locators {

    @Test

    public void Locators() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        // By ID
        //driver.get("https://www.facebook.com");

       // driver.findElement(By.id("email")).sendKeys("Aloha");


        Thread.sleep(2000);

        //By name value
        driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.name("userName")).sendKeys("Aloha");
        driver.findElement(By.name("userName")).sendKeys("text", Keys.chord(Keys.CONTROL,"c"));


        //By linktext & partialLinkText

        //driver.get("http://newtours.demoaut.com/");
       // driver.findElement(By.linkText("REGISTER"));
       // driver.findElement(By.partialLinkText("SIGN")).click();
        //driver.findElement(By.partialLinkText("ON")).click();
        //driver.findElement(By.partialLinkText("GN-O")).click();


        //By class name
//        driver.findElement(By.className("mouseOut")).click();
//
//        driver.get("http://adrian.thrive-dev.bitstoneint.com/wp-login.php");
//        driver.findElement(By.className("input")).sendKeys("this is the locator");
//
//        //By tagName
//
//        driver.get("http://adrian.thrive-dev.bitstoneint.com/selenium-tutorial/");
//        String text = driver.findElement(By.tagName("h1")).getText();
//        System.out.println(text);


    }
}

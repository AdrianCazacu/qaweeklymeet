package Tutorial;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

/**
 * Created by pc on 4/11/2017.
 */
public class Test2 {

    @Test

    public void checkTitleAfterSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.ro");
//        driver.findElement(By.id("lst-ib")).sendKeys("automation testing"+ Keys.ENTER);
//        String title = driver.getTitle();
//        System.out.println(title);
//
//        Assert.assertEquals("Google",title);
//        driver.quit();
//
//
//        driver.get("https://www.google.com");

        // Check if text is present on a page or not


        WebElement element = driver.findElement(By.id("lst-ib"));

        element.sendKeys("Aloha");

        Assert.assertFalse("Search complete", driver.findElement(By.name("btnK")).isDisplayed());

    }
}

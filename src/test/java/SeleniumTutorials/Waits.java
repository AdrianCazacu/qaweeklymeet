package SeleniumTutorials;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by pc on 9/5/2017.
 */
public class Waits {

    public void waits() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");


// Implicit Wait

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);



        //Explicit Wait
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 15);
        element = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));


        //FluentWait
        WebElement navigate = driver.findElement(By.id("email"));


        Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("u_0_s")));
        navigate.sendKeys("emailaddress");


        driver.findElement(By.name("userName")).sendKeys("text", Keys.chord(Keys.CONTROL, "c"));

    }
}



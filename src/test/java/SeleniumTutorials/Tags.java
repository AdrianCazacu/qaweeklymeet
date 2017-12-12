package SeleniumTutorials;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Admin on 2/2/2017.
 */
public class Tags {


    WebDriver driver;

    @Before


        public void setUP() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

@Test

        public void startDriver() throws InterruptedException {

    driver.get("http://www.google.com");

    WebElement element1 = driver.findElement(By.id("lst-ib"));
    element1.sendKeys("Selenium tutorial");
    element1.sendKeys(Keys.ENTER);
    Thread.sleep(3000);

    WebElement list = driver.findElement(By.className("_NId"));

    List<WebElement> allItems = list.findElements(By.partialLinkText("Selenium Tutorial"));


    for( WebElement itemes : allItems) {

        System.out.println(itemes.getText());

    }





}



    @After

            public void quitDriver(){

        driver.quit();


    }






}



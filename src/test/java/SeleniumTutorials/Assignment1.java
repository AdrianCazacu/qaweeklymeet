package SeleniumTutorials;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Admin on 2/2/2017.
 */
public class Assignment1 {

    @Test

    public void Locators ()throws  InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

       //By ID

//        driver.get ("http://new.dental-campus.com/Account/Login");
//        driver.findElement(By.id("loginViewEmail")).sendKeys("Test_email");


       // By.XPath

//        driver.get("http://box.osteology.org/");
//        driver.findElement(By.xpath("//*[@id=\"home-login\"]/p/a[1]")).click();


       // By Class
//        driver.get("http://box.osteology.org/");
//        driver.findElement(By.id("cube-overlay")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.className("p3")).click();




       // CSS selector
//        driver.get("http://box.osteology.org/");
//        driver.findElement(By.cssSelector("[href='/User/ResetPassword']")).click();


       // By Name
//        driver.get ("http://box.osteology.org/");
//        driver.findElement(By.name("RememberMe")).click();


       // By tagName
//        driver.get("http://box.osteology.org/");
//        String text = driver.findElement(By.tagName("h2")).getText();
//        System.out.println(text);


       // By linkText
//        driver.get("http://www.qtptutorial.net/");
//        driver.findElement(By.linkText("Get Started")).click();


       // By partialLinkText
//        driver.get("http://www.qtptutorial.net/");
//        driver.findElement(By.partialLinkText("for Huge Savings")).click();


    }

}



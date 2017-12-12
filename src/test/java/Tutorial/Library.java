package Tutorial;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by pc on 9/5/2017.
 */
public class Library {

    WebDriver driver = new ChromeDriver();

    public static void Login(String username, String pass) {

        WebDriver driver = new ChromeDriver();

        driver.get("http://newtours.demoaut.com/");

        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(pass);
    }


}

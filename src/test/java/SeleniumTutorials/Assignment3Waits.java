package SeleniumTutorials;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 3/7/2017.
 */
public class Assignment3Waits {


    WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test

    public void startDriver() throws InterruptedException {


        driver.get("http://Curaden:DEVELOPMENT@dev.curaden-dentaldepot.ch/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         /*Create Explicit wait*/
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 15);

//        On Mozilla browser there is an alert displayed
//        Alert alert = driver.switchTo().alert();
//        alert.accept();


//        login form
        driver.findElement(By.cssSelector(".header_user_info > a:nth-child(1)")).click();
        driver.findElement(By.id("header-email")).sendKeys("208081");
        driver.findElement(By.name("header-passwd")).sendKeys("Dentaldepot");
        Thread.sleep(2000);
        driver.findElement(By.name("HeaderSubmitLogin")).click();
        Thread.sleep(5000);

//        Go to A-Silokone page

        driver.findElement(By.xpath("//*[@id=\"collapsed-navigation\"]/ul/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"cat901\"]/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"cat1000\"]/li[1]")).click();
        Thread.sleep(1000);

        /*Add a product to cart*/
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div/div[3]/div/div/div/div[2]/input[2]")).sendKeys("3");
        Thread.sleep(5000);
        driver.findElement(By.id("button_order_cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[3]/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();

        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"uniform-cgv\"]")));
        driver.findElement(By.xpath("//*[@id=\"uniform-cgv\"]")).click();
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/p/button")));


//        Fail safe in case if any medicine is added into the cart.

        try {
            boolean check = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[4]/p[2]")).isDisplayed();
            if (check) {
                System.out.println("true");
                driver.findElement(By.xpath("//*[@id=\"uniform-drugs\"]")).click();
            }
        } catch (Exception $e) {
            System.out.println("There are no drugs in the Cart");
        }

//        end of fail safe.
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/p/button")));
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();

        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/a")));
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/a")).click();

        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cart_navigation\"]/a[2]")));
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/a[2]")).click();

//        payment using Visa Card
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/main/section[1]/ul/li[2]/form/button")));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/main/section[1]/ul/li[2]/form/button")).click();

        /*set the card number -- MUST BE A FIXED VALUE-- 9010100052000004*/
        driver.findElement(By.xpath("//*[@id=\"CardNumber\"]")).sendKeys("9010100052000004");

//        select a expiration data, make sure that you set a data higher than the date of the test

        /*set the month value for the expiration date -- USED 12 (December) -- change with values from 2-13 */
        driver.findElement(By.xpath("//*[@id=\"ExpMonth\"]/option[13]")). click();

        /*set the year value for the expiration date -- USED 31 (year 2046) -- change the value form 2-31*/
        driver.findElement(By.xpath("//*[@id=\"ExpYear\"]/option[31]")).click();

        /*name field not imported*/
        Thread.sleep(2000);
        //*[@id="HolderName"]
        driver.findElement(By.xpath("//*[@id=\"HolderName\"]")).sendKeys("ifdg  sofsdosd odsf s");

        /*security code -- can input any 3 numbers-- used 512*/
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"VerificationCode\"]")));
        driver.findElement(By.xpath("//*[@id=\"VerificationCode\"]")).sendKeys("512");

        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/form/footer/ul/li[3]/button")));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/footer/ul/li[3]/button")).click();

        /*finish payment*/
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Submit\"]")));
        driver.findElement(By.xpath("//*[@id=\"Submit\"]")).click();

        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/form/footer/ul/li[3]")));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/footer/ul/li[3]")).click();

        /*return to curaden and check the Invoice nr*/
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/p/a")));
        driver.findElement((By.xpath("//*[@id=\"center_column\"]/p/a"))).click();

        String order  =  driver.findElement(By.className("first_item")).getText();
        System.out.println(order);
        String OrdNumber = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")).getText();
        System.out.println(OrdNumber);

    }
}

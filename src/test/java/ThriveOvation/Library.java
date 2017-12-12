package ThriveOvation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.awt.*;

/**
 * Created by pc on 11/15/2016.
 */
public class Library {


    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);


    //VERIFY LOGIN

    public void Login (String username, String pass) {




    }
    public void Login() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        //WebDriver driver = new FirefoxDriver();
        driver.get("http://adrian.thrive-dev.bitstoneint.com/wp-admin/");
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='user_login']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_pass']")));

        driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys("admin");
        driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys("Vi7(tWqJr9Uf@mWugX(Q4qR^");
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")));
        Assert.assertEquals("Dashboard ‹ Adrian Dev Site — WordPress", driver.getTitle());
    }

    //GO TO TO DASHBOARD

    public void GoToThriveOvation() throws InterruptedException {
        driver.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tvo_admin_dashboard')]")));

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tvo_admin_dashboard')]")).click();
        Thread.sleep(1000);
        //driver.findElement(By.linkText("http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tvo_admin_dashboard")).click();
    }


    //GO TO TL DASHBOARD

    public void GoToThriveLeads() {
        driver.findElement(By.xpath("//a[contains(@class,'wp-first-item current')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/ul/li[6]/a")));

        driver.findElement(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=thrive_leads_dashboard')]")).click();

    }

    //GO TO TU DASHBOARD

    public void GoToThriveUltimatum() {
        driver.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tve_ult_dashboard')]")));

        driver.findElement(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tve_ult_dashboard')]")).click();
    }


    //GO TO THO DASHBOARD

    public void GoToThriveHeadOptimizer() {
        driver.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tho_admin_dashboard')]")));

        //driver.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/ul/li[5]/a")).click();
        driver.findElement(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tho_admin_dashboard')]")).click();
    }

    //MANAGE BROWSER WINDOW

    public void manageWindow() {
        driver.manage().window().maximize();

    }


    //CLOSE BROWSER
    public void closeFirefox() {

        driver.quit();
    }


    //ADD NEW TESTIMONIAL AND VERIFY
    public void addNewTestimonial() throws InterruptedException {

        GenerateData generateData = new GenerateData();

        driver.findElement(By.xpath("//a[@class='tvo-add-new-testimonial tvd-waves-effect tvd-waves-light tvd-btn tvd-btn-blue tvd-left']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'tvo-title')]")));

        driver.switchTo().activeElement();

        WebElement title = driver.findElement(By.xpath("//input[contains(@id,'tvo-title')]"));
        title.click();
        title.sendKeys("Automated Test - Testimonial 1");
        //driver.findElement(By.xpath("//input[contains(@id,'tvo-title')]")).sendKeys("Automated Test - Testimonial 1");
        Thread.sleep(500);

        WebElement name = driver.findElement(By.id("tvo-author-name"));
        name.click();
        String storename = generateData.generateRandomString(10) + " " + generateData.generateStringWithAllobedSplChars(15, "abcdefghijklmnop");
        name.sendKeys(storename);


        //driver.findElement(By.xpath("//label[contains(@for,'tvo-author-name')]")).sendKeys("Luke Skywalker");
        Thread.sleep(500);

        WebElement email = driver.findElement(By.id("tvo-author-email"));
        email.click();
        email.sendKeys(generateData.generateEmail(20));

        //driver.findElement(By.xpath("//label[contains(@for,'tvo-author-email')]")).sendKeys("luke.skywalker@email.com");
        Thread.sleep(500);

        WebElement role = driver.findElement(By.id("tvo-author-role"));
        role.click();
        role.sendKeys(generateData.generateRandomString(10));


        //driver.findElement(By.xpath("//label[contains(@for,'tvo-author-role')]")).sendKeys("QA Jedi");
        Thread.sleep(500);

        driver.switchTo().frame(driver.findElement(By.id("tvo-testimonial-content-tinymce_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys(generateData.generateRandomAlphaNumeric(60) + Keys.PAGE_DOWN);
        driver.switchTo().defaultContent();


        driver.findElement(By.xpath("//a[contains(@class,'tvo-save-new-testimonial tvd-waves-effect tvd-waves-light tvd-btn tvd-btn-green tvd-right')]")).click();

        driver.switchTo().defaultContent();

        driver.navigate().refresh();
        Thread.sleep(2000);
        String text = driver.findElement(By.id("tvo-testimonials-list")).getText();


        Assert.assertTrue("Testimonial not found", text.contains(storename));


    }


    //LOGOUT FROM WORDPRESS
    public void logout() throws InterruptedException {


        driver.get("http://adrian.thrive-dev.bitstoneint.com/wp-login.php?loggedout=true");
//        Actions actions = new Actions(driver);
//
//
//        WebElement moveonmenu = driver.findElement(By.xpath("//a[contains(.,'Howdy, admin')]"));
//        WebElement submenu = driver.findElement(By.cssSelector("#wp-admin-bar-logout a"));
//
//
//        Thread.sleep(1000);
//        actions.moveToElement(moveonmenu);
//        actions.perform();
//
//


        Thread.sleep(3000);


//        submenu.click();

        Assert.assertEquals("Adrian Dev Site ‹ Log In", driver.getTitle());
        //Thread.sleep(2000);


        //moveToElement(driver.findElement(By.xpath("//a[contains(@class,'ab-item')]"))).click();

        //moveToElement(driver.findElement(By.xpath("//a[contains(.,'Log Out')]"))).click().perform();


    }

    public void deleteTestimonial() throws InterruptedException {

        String text = driver.findElement(By.cssSelector("#tvo-testimonials-list > div:nth-child(1) >div:nth-child(1) > div:nth-child(1) > div:nth-child(3) a")).getText();

        System.out.println(text);

        driver.findElement(By.cssSelector("#tvo-testimonials-list > div:nth-child(1) >div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#tvo-dashboard-wrapper > div > div:nth-child(5) > div > div > div > div.tvd-row.tvd-no-margin >div:nth-child(1) > div > div:nth-child(2)> a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tvo-delete-multiple-testimonials-modal > div.tvd-modal-footer > div > div:nth-child(2) > a")));

        driver.findElement(By.cssSelector("#tvo-delete-multiple-testimonials-modal > div.tvd-modal-footer > div > div:nth-child(2) > a")).click();

        Thread.sleep(1000);

        driver.navigate().refresh();

        Thread.sleep(2000);
        String list = driver.findElement(By.cssSelector("#tvo-dashboard-wrapper > div > div:nth-child(5) > div > div > div")).getText();

        Assert.assertFalse("The testimonial was NOT deleted", list.contains(text));


    }

    public void editTestimonial() throws InterruptedException {

        driver.findElement(By.cssSelector("#tvo-testimonials-list > div:nth-child(1) >div:nth-child(5) >div >a:nth-child(2)")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("tvo-title")).sendKeys(" Edit");
        driver.findElement(By.id("tvo-author-name")).sendKeys(" Edit    ");
        WebElement role = driver.findElement(By.id("tvo-author-role"));
        role.clear();
        role.sendKeys("Edited Role");

        driver.switchTo().frame(driver.findElement(By.id("tvo-testimonial-content-tinymce_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys(" EDITED");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("#tvo-dashboard-wrapper > div > div:nth-child(2) > div.tvd-col.tvd-l8.tvd-m12 > div:nth-child(4) > div > a.tvd-waves-effect.tvd-waves-light.tvd-btn.tvd-btn-green.tvo-update-testimonial.tvd-right")).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tvo-dashboard-wrapper > div > div:nth-child(2) > div.tvd-col.tvd-l8.tvd-m12 > div:nth-child(4) > div > a.tvd-waves-effect.tvd-waves-light.tvd-btn.tvd-btn-gray.tvd-left")).click();


    }

    public void duplicateTestimonial() throws InterruptedException {




        //System.out.println(getTitle);
        driver.findElement(By.cssSelector("#tvo-testimonials-list > div:nth-child(1) >div:nth-child(5) >div >a:nth-child(1)")).click();

        Thread.sleep(1000);

        driver.navigate().refresh();
        Thread.sleep(3000);

        String getTitle = driver.findElement(By.cssSelector("#tvo-testimonials-list > div:nth-child(1) > div.tvd-col.tvd-s3.tvo-show-hide-description-container > span")).getText();

        //*[@id="tvo-testimonials-list"]/div[1]/div[2]/text()



        Assert.assertTrue("The Testimonial was not duplicated",getTitle.equals("Copy of Automated Test - Testimonial 1 Edit"));


        driver.findElement(By.cssSelector("#tvo-testimonials-list > div:nth-child(1) > div:nth-child(1) > div > div:nth-child(2) > a")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tvo-author-name")));

        driver.findElement(By.cssSelector("#tvo-author-name")).sendKeys("COPY");
        driver.findElement(By.cssSelector("#tvo-dashboard-wrapper > div > div:nth-child(2) > div.tvd-col.tvd-l8.tvd-m12 > div:nth-child(4) > div > a.tvd-waves-effect.tvd-waves-light.tvd-btn.tvd-btn-green.tvo-update-testimonial.tvd-right")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tvo-dashboard-wrapper > div > div:nth-child(2) > div.tvd-col.tvd-l8.tvd-m12 > div:nth-child(4) > div > a.tvd-waves-effect.tvd-waves-light.tvd-btn.tvd-btn-gray.tvd-left")).click();
//#tvo-testimonials-list > div.tvd-row.tvo-gray-box.testimonial-row-851 > div.tvd-col.tvd-s3.tvo-show-hide-description-container > span

    }

    public void testing() {}

    DesiredCapabilities capabilities = DesiredCapabilities.firefox();

}





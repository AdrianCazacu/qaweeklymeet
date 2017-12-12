package ThriveUltimatum;

import ThriveOvation.GenerateData;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by pc on 11/15/2016.
 */
public class Library {



    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);


    //VERIFY LOGIN

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


    //GO TO TU DASHBOARD

    public void GoToThriveUltimatum() {
        driver.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tve_ult_dashboard')]")));

        driver.findElement(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tve_ult_dashboard')]")).click();
    }


    //MANAGE BROWSER WINDOW

    public void manageWindow() {
        driver.manage().window().maximize();

    }

    //CLOSE BROWSER
    public void closeFirefox() {

        driver.quit();
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

        Assert.assertEquals("Adrian Dev Site ‹ Log In",driver.getTitle());
        //Thread.sleep(2000);





                //moveToElement(driver.findElement(By.xpath("//a[contains(@class,'ab-item')]"))).click();

                //moveToElement(driver.findElement(By.xpath("//a[contains(.,'Log Out')]"))).click().perform();


    }

    public void addUltimatum() throws InterruptedException {

        ThriveUltimatum.GenerateData genData = new ThriveUltimatum.GenerateData();
        driver.findElement(By.xpath("//i[contains(@class,'tvd-icon-plus tvd-icon-rounded tvd-icon-medium')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//img[contains(@data-id,'0')]")).click();
        driver.findElement(By.xpath("//a[@class='tvd-waves-effect tvd-waves-light tvd-btn tvd-btn-green tvd-right tvu-modal-next-step']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='tvu-new-campaign-name']")).sendKeys(genData.generateRandomAlphaNumeric(6));
        driver.findElement(By.xpath(".//*[@id='tvd-modal-base']/div[2]/div[2]/div/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tvu-campaign-settings']/div[1]/div/div[2]/div/div[2]/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#tvd-modal-base > div.tvd-modal-content > div.tvd-row.tvd-collapse > div:nth-child(1) > div > div > img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tvu-campaign-type-options']/div[1]/div/div[1]/div/label")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='tvu-start-date_root']/div/div/div/div/div[2]/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='tvu-campaign-type-options']/div[1]/div/div[3]/div/label")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='tvu-end-date_root']/div/div/div/div/div[2]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tvu-start-hour']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tvu-start-hour']")).sendKeys("01:00");
        driver.findElement(By.xpath(".//*[@id='tvu-end-hour']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tvu-end-hour']")).sendKeys("23:00");
        driver.findElement(By.xpath(".//*[@id='tvd-modal-base']/div[2]/div/div[2]/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='tvu-campaign-settings']/div[2]/div/div[2]/div/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tvu_leads_show_tab_other_screens']/div[1]/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tvd-modal-base']/div[2]/div/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tvu-designs-list']/div/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='tvu-design-types']/div[1]/div/img")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='tvd-modal-base']/div[2]/div/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tvu-designs-list']/div[1]/div/div[3]/div/div[2]/div/a[1]/i")).click();
        Thread.sleep(2000);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("The number of tabs open are: " + newTab.size());
        driver.switchTo().window(newTab.get(1));
        Thread.sleep(3000);
        driver.switchTo().frame(driver.findElement(By.id("tve-editor-frame")));
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tve_landing_page_selector']/div/div[1]/div[2]/span[1]/img")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='tve_landing_page_selector']/div/div[4]/div")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='tve_update_content']")).click();
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(newTab.get(0));
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tvu-admin-wrapper']/div/div[2]/div[2]/div/span[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#tvu-breadcrumbs-wrapper > ul > li:nth-child(2) > a")).click();
        Thread.sleep(2000);



    }

    public void verifyUltimatum() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(3000);

        String title = driver.findElement(By.cssSelector("#tvu-campaigns-list > div:nth-last-child(2) > div > div.tvd-card-content > h3")).getText();

        String list = driver.findElement(By.cssSelector("#tvu-campaigns-list")).getText();


        Assert.assertTrue("Campaign NOT added",list.contains(title));



        System.out.println(title);




    }

    public void deleteUltimatum() throws InterruptedException {

        String title = driver.findElement(By.cssSelector("#tvu-campaigns-list > div:nth-last-child(2) > div > div.tvd-card-content > h3")).getText();

        Actions hover = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector("#tvu-campaigns-list > div:nth-last-child(2) > div > div.tvu-campaign-controls"));

        hover.moveToElement(menu).perform();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tvu-campaigns-list > div:nth-last-child(2) > div > div.tvu-campaign-controls > div > a.tvu-delete-campaign.tvu-icon-gray.tvu-btn-icon-small.tvd-tooltipped > i")).click();

        Thread.sleep(500);

        driver.findElement(By.cssSelector("#tvu-campaigns-list > div:nth-last-child(2) > div > div.tvd-card-action > div > div:nth-child(1) > a")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();



        String list = driver.findElement(By.cssSelector("#tvu-campaigns-list")).getText();

        Assert.assertFalse("Campaign NOT deleted!!!!",list.contains(title));


    }






    }





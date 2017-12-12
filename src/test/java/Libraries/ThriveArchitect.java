package Libraries;

import ThriveOvation.GenerateData;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

/**
 * Created by pc on 11/15/2016.
 */
public class ThriveArchitect {



    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);

    Actions action = new Actions(driver);
    Libraries.GenerateData data = new Libraries.GenerateData();


    //VERIFY LOGIN

    public void Login(String URL, String username, String password) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        //WebDriver driver = new FirefoxDriver();
        driver.get(URL);
        Thread.sleep(2000);

        WebElement loginID = driver.findElement(By.xpath(".//*[@id='user_login']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginID);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_pass']")));

        loginID.sendKeys(username);
        driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys(password);
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();




        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")));
        Assert.assertEquals("Dashboard ‹ Adrian Dev Site — WordPress", driver.getTitle());
    }


    //MANAGE BROWSER WINDOW

    public void manageWindow() {
        driver.manage().window().maximize();

    }


    //CLOSE BROWSER
    public void closeFirefox() {

        driver.quit();
    }



    // GO TO Pages

    public void gotoPages() {

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#menu-pages > a > div.wp-menu-name")));
        driver.findElement(By.cssSelector("#menu-pages > a > div.wp-menu-name")).click();
    }


    public void createPage () throws InterruptedException {

        driver.findElement(By.className("page-title-action")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("title")));
        WebElement pageName = driver.findElement(By.id("title"));
        pageName.sendKeys("Automation Page " + data.generateRandomNumber(3));
        driver.findElement(By.id("publish")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("thrive_preview_button")));
        driver.findElement(By.id("thrive_preview_button")).click();

       // Thread.sleep(4000);

        ArrayList tabs = new ArrayList(driver.getWindowHandles());

        driver.switchTo().window((String) tabs.get(1));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tve-editor-frame")));

        String pageTitle = driver.getTitle();
        //System.out.println(pageTitle);
        Assert.assertTrue("The Thrive Architect didn't start",pageTitle.contains(" | Thrive Architect"));

    }

    public void addDisplayTestimonial(String templateName) throws InterruptedException {

        driver.findElement(By.cssSelector("#tve-elements > div:nth-child(44)")).click();
        Thread.sleep(2000);
            List<WebElement> templates = driver.findElements(By.className("tvo-template-name"));


            for (WebElement single : templates) {

                System.out.println(single.getText());

                if (single.getText().equals(templateName)) {

                    System.out.println("The template is: " + single.getText());
                   single.click();
                }



            }
        driver.findElement(By.cssSelector("#tcb-modal-display-testimonial-templates-lightbox > div > div > button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tvo-testimonial-shortcode-list > div:nth-child(10) > div.tvo-col.tvo-s5 > div > button")));
        driver.findElement(By.cssSelector("#tvo-testimonial-shortcode-list > div:nth-child(10) > div.tvo-col.tvo-s5 > div > button")).click();

    }


    //Add Text element

    public void addTextElement() throws InterruptedException {
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("The number of tabs open are: " + newTab.size());
        driver.switchTo().window(newTab.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tcb-frame-container")));

        System.out.println("cate sunt? " + driver.findElements(By.className("tcb-icon-text")).size());
        driver.findElements(By.className("tcb-icon-text")).get(0).click();


        Thread.sleep(4000);

        driver.switchTo().frame(driver.findElement(By.id("tve-editor-frame")));

        WebElement textInput = driver.findElement(By.cssSelector("#tve_editor > div > div > div > p"));

        textInput.click();

        Libraries.GenerateData genData = new Libraries.GenerateData();
        String newText = genData.generateRandomString(10);
        new Actions(driver).moveToElement(textInput).sendKeys(newText).perform();

        String verifyText = "Enter your text here..." + newText;
        //System.out.println(driver.findElement(By.cssSelector("#tve_editor > div > div > div > p")).getText());
        Assert.assertTrue(driver.findElement(By.cssSelector("#tve_editor > div > div > div > p")).getText().contains(verifyText));





//        String js = "document.getElementById('tve-drop-handle').style.display = \"block\";";
//
//        ((JavascriptExecutor) driver).executeScript(js);
    }


    // Add Star Rating element

    public void addStarRating() throws InterruptedException {

        driver.findElement(By.className("tve-header")).click();
        driver.findElement(By.className("tcb-icon-rating")).click();


        driver.switchTo().frame(driver.findElement(By.id("tve-editor-frame")));

       WebElement e1 = driver.findElement(By.cssSelector("div.thrv_wrapper:nth-child(2)"));
        WebElement e2 = driver.findElement(By.cssSelector(".tve-page-section-in"));

        Thread.sleep(1000);
        //driver.findElement(By.cssSelector(".tve-page-section-in")).click();

        action.clickAndHold(e1).build().perform();

        action.moveToElement(e2).build().perform();

        driver.switchTo().parentFrame();
        action.release().build().perform();


       //action.dragAndDropBy(e1, 687, 40).build().perform();
    }
    //Add Background section

    public void addBackgroundSectionElement() throws InterruptedException {
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        System.out.println("The number of tabs open are: " + newTab.size());
//        driver.switchTo().window(newTab.get(1));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tcb-frame-container")));
//
//        System.out.println("cate sunt? " + driver.findElements(By.className("tcb-icon-section")).size());
//        driver.findElements(By.className("tcb-icon-section")).get(0).click();
//        Thread.sleep(4000);
//        driver.findElement(By.cssSelector("body")).click();
//        Thread.sleep(4000);
//        driver.findElements(By.className("tcb-icon-text")).get(0).click();Thread.sleep(5000);
//        driver.switchTo().frame(driver.findElement(By.id("tve-editor-frame")));
//        //WebElement text = driver.findElement(By.cssSelector("#tve_editor > div.thrv_wrapper.thrv_text_element.tve-draggable.tve-droppable.tve_empty_dropzone.tve-froala.fr-box.tve-froala-1.fr-inline.edit_mode.active_delete"));
//        WebElement text = driver.findElement(By.id("tve-drag-handle"));
//
//        WebElement bgSection = driver.findElement(By.cssSelector("#tve_editor > div.thrv_wrapper.thrv-page-section.tve-draggable.tve-droppable"));
//        //#tve_editor > div.thrv_wrapper.thrv-page-section.tve-draggable.tve-droppable.edit_mode.active_delete > div.tve-page-section-in.tve_empty_dropzone
//        //#tve_editor > div.thrv_wrapper.thrv-page-section.tve-draggable.tve-droppable > div.tve-page-section-in.tve_empty_dropzone
//        //dragAndDropText(text, bgSection);
//        //driver.switchTo().frame(driver.findElement(By.id("tve-editor-frame")));
//        try{
//            driver.findElement(By.className("tve-page-section-in"));
//        } catch (WebDriverException e){
//            System.out.println("The bg section wasn't added");
//
//        }


        driver.findElement(By.className("tve-header")).click();

        driver.findElement(By.cssSelector("#tve-elements > div:nth-child(8) > div > span.tve-e-icon > svg")).click();


    }
    //LOGOUT FROM WORDPRESS
    public void logout() throws InterruptedException {


        Actions actions = new Actions(driver);
        WebElement moveonmenu = driver.findElement(By.xpath("//a[contains(.,'Howdy, admin')]"));
        WebElement submenu = driver.findElement(By.cssSelector("#wp-admin-bar-logout a"));

        actions.moveToElement(moveonmenu).perform();
        Thread.sleep(3000);

        actions.moveToElement(submenu).perform();
        submenu.click();

        Assert.assertEquals("Adrian Dev Site ‹ Log In",driver.getTitle());
        //Thread.sleep(2000);

        driver.findElement(new ByIdOrName(""));




                //moveToElement(driver.findElement(By.xpath("//a[contains(@class,'ab-item')]"))).click();

                //moveToElement(driver.findElement(By.xpath("//a[contains(.,'Log Out')]"))).click().perform();


    }



    }





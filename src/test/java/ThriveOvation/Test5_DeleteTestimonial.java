package ThriveOvation;

import org.junit.Test;

/**
 * Created by pc on 11/28/2016.
 */
public class Test5_DeleteTestimonial {

    @Test

    public void deleteTestimonial() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
        Library library = new Library();

        library.manageWindow();
        //Thread.sleep(1000);
        library.Login();
        library.GoToThriveOvation();
        Thread.sleep(1000);
        library.deleteTestimonial();

    }
}

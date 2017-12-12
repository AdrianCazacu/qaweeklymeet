package ThriveOvation;

import org.junit.Test;

/**
 * Created by pc on 12/7/2016.
 */
public class Test4_DuplicateTestimonial {

    @Test
    public void duplicateTestimonial() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        ThriveOvation.Library library = new ThriveOvation.Library();

        library.manageWindow();
        //Thread.sleep(1000);
        library.Login();
        library.GoToThriveOvation();
        Thread.sleep(2000);
        library.duplicateTestimonial();
    }
}

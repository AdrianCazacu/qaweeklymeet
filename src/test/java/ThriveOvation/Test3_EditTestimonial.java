package ThriveOvation;

import ThriveUltimatum.*;
import org.junit.Test;

/**
 * Created by pc on 11/29/2016.
 */
public class Test3_EditTestimonial {

    @Test
    public void editTestimonial() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        ThriveOvation.Library library = new ThriveOvation.Library();

        library.manageWindow();
        //Thread.sleep(1000);
        library.Login();
        library.GoToThriveOvation();
        Thread.sleep(2000);
        library.editTestimonial();
    }

}

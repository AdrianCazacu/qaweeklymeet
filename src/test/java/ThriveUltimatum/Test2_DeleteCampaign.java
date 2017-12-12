package ThriveUltimatum;

import org.junit.Test;

/**
 * Created by pc on 11/25/2016.
 */
public class Test2_DeleteCampaign {

    @Test
    public void deleteCampaign() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        Library library = new Library();

        library.manageWindow();
        //Thread.sleep(1000);
        library.Login();
        library.GoToThriveUltimatum();
        Thread.sleep(2000);

        library.deleteUltimatum();

    }
}

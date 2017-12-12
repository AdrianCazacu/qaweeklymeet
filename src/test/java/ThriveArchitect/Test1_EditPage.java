package ThriveArchitect;

import Libraries.GenerateData;
import Libraries.ThriveArchitect;
import org.junit.Test;

/**
 * Created by pc on 10/27/2017.
 */
public class Test1_EditPage {

    @Test

    public void editPage () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
        ThriveArchitect library = new ThriveArchitect();

        library.manageWindow();
        library.Login("http://adrian.thrive-dev.bitstoneint.com/wp-admin/", "admin","asdasd");
        library.gotoPages();
        library.createPage();

        library.addBackgroundSectionElement();
        Thread.sleep(2000);
        library.addStarRating();
        //library.addTextElement();


    }
}

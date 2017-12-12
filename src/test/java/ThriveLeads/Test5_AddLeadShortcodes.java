package ThriveLeads;

import Reporting.JUnitHTMLReporter;
import org.junit.*;

/**
 * Created by pc on 11/25/2016.
 */
public class Test5_AddLeadShortcodes extends JUnitHTMLReporter {

    @org.junit.Test
    public void addLead() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        ThriveLeads.Library library = new ThriveLeads.Library();
        library.manageWindow();
        library.Login();
        library.GoToThriveLeads();
        library.addLeadShortcodes();
    }
}

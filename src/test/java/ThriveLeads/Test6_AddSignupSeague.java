package ThriveLeads;

import Reporting.JUnitHTMLReporter;

/**
 * Created by pc on 11/25/2016.
 */
public class Test6_AddSignupSeague extends JUnitHTMLReporter{

    @org.junit.Test
    public void addSignupSeague() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        ThriveLeads.Library library = new ThriveLeads.Library();
        library.manageWindow();
        library.Login();
        library.GoToThriveLeads();
        Thread.sleep(2000);
        library.addSignupSeague();
}
    }

package APIConnections;

import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by pc on 3/8/2017.
 */


public class AddAPIConnections {

    @Test

    public void startDriver() throws InterruptedException {




        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win322\\chromedriver.exe");
        Library library = new Library();
        library.manageWindow();
        library.Login("http://adrian.thrive-dev.bitstoneint.com/wp-admin","admin","asdasd");
        library.GoToAPIConnections();
        library.AddAPIConnections();


    }
}

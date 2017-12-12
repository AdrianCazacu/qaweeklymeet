import ThriveUltimatum.Test1_AddCampaign;
import ThriveUltimatum.Test2_DeleteCampaign;
import org.apache.xpath.SourceTree;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

/**
 * Created by pc on 5/9/2017.
 */
public class TestRunner {

    public static void main(String args[]){

        //org.junit.runner.JUnitCore.main("junitfaq.SimpleTest");
        JUnitCore junit = new JUnitCore();
        Result result = JUnitCore.runClasses(Test1_AddCampaign.class, Test2_DeleteCampaign.class);

        System.out.println("Number of tests ran: " + result.getRunCount());
        //List<Failure> failures = result.getFailures();
        System.out.println("Number of tests failed: " + result.getFailureCount());
        System.out.println("Tests failed with error message: " + result.getFailures());
        System.out.println("Total time: " + result.getRunTime());


        List<Failure> fails = result.getFailures();

        for(Failure f : fails){

            System.out.println("Exception Message: " + f.getMessage());
            System.out.println("Trace: " + f.getTrace());
            System.out.println("Test Header: " + f.getTestHeader());
            System.out.println("Exception: " + f.getException());


        }

    }
}


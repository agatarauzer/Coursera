package Week3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LogAnalyzerTests {
    private LogAnalyzer logAnalyzer;
    private static String filePath = "UniqueIPData/short-test_log";

    @Before
    public void begin() {
        logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(filePath);
    }

    @Test
    public void testCountUniqueIPs() {
        Assert.assertEquals(4, logAnalyzer.countUniqueIPs());
    }

    @Test
    public void testPrintHigherThan() {
        Assert.assertEquals(3, logAnalyzer.printAllHigherThanNum(300));
    }

    @Test
    public void testUniqueIPVisitsOnDay() {
        ArrayList<String> ips = logAnalyzer.uniqueIPVisitsOnDay("Sep 30");
        Assert.assertEquals(4, ips.size());
    }

    @Test
    public void testCountUniqueIPsInRange() {
        Assert.assertEquals(4, logAnalyzer.countUniqueIPsInRange(200,300));
        Assert.assertEquals(0, logAnalyzer.countUniqueIPsInRange(50, 100));
    }
}

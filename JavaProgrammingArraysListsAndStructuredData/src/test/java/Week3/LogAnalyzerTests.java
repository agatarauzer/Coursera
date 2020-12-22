package Week3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class LogAnalyzerTests {
    private LogAnalyzer logAnalyzer;
    private static String filePath = "CountingVisitsData/weblog3-short_log";

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
        Assert.assertEquals(2, logAnalyzer.printAllHigherThanNum(300));
    }

    @Test
    public void testUniqueIPVisitsOnDay() {
        ArrayList<String> ips = logAnalyzer.uniqueIPVisitsOnDay("Sep 30");
        Assert.assertEquals(3, ips.size());
    }

    @Test
    public void testCountUniqueIPsInRange() {
        Assert.assertEquals(3, logAnalyzer.countUniqueIPsInRange(200,300));
        Assert.assertEquals(0, logAnalyzer.countUniqueIPsInRange(50, 100));
    }

    @Test
    public void testCountVisitsPerIP() {
        HashMap<String, Integer> counts = logAnalyzer.countVisitsPerIP();
        int countForIP84_189_158_117 = counts.get("84.189.158.117");
        int countForIP84_133_195_161 = counts.get("84.133.195.161");

        Assert.assertEquals(2, countForIP84_189_158_117);
        Assert.assertEquals(3, countForIP84_133_195_161);
    }

    @Test
    public void testMostNumberVisitsByIP() {
        HashMap<String, Integer> counts = logAnalyzer.countVisitsPerIP();
        int num = logAnalyzer.mostNumberVisitsByIP(counts);

        Assert.assertEquals(3, num);
    }

    @Test
    public void testIPsMostVisits() {
        HashMap<String, Integer> counts = logAnalyzer.countVisitsPerIP();
        ArrayList<String> visits = logAnalyzer.iPsMostVisits(counts);
        String firstAd = visits.get(0);
        String secondAd = visits.get(1);

        Assert.assertEquals("61.15.121.171", firstAd);
        Assert.assertEquals("84.133.195.161", secondAd);
    }

    @Test
    public void testIPsForDays() {
        HashMap<String, ArrayList<String>> ips = logAnalyzer.iPsForDays();
        int iPsNumForSep14 = ips.get("Sep 14").size();
        int iPsNumForSep30 = ips.get("Sep 30").size();

        Assert.assertEquals(1, iPsNumForSep14);
        Assert.assertEquals(5, iPsNumForSep30);
    }

    @Test
    public void testDayWithMostIPVisits() {
        HashMap<String, ArrayList<String>> ips = logAnalyzer.iPsForDays();
        String day = logAnalyzer.dayWithMostIPVisits(ips);

        Assert.assertEquals("Sep 30", day);
    }

    @Test
    public void testIPsWithMostVisitsOnDay() {
        HashMap<String, ArrayList<String>> ipsDays= logAnalyzer.iPsForDays();
        ArrayList<String> ipsMax = logAnalyzer.iPsWithMostVisitsOnDay(ipsDays, "Sep 30");

        Assert.assertEquals(2, ipsMax.size());
    }
}

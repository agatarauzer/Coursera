package Week3;

import Week1.predefinedClasses.FileResource;

import java.util.ArrayList;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<>();
    }

    public void readFile(String filename) {
        FileResource fileResource = new FileResource(filename);
        for (String line : fileResource.lines()) {
            LogEntry logEntry = WebLogParser.parseEntry(line);
            records.add(logEntry);
        }
    }

    public void printAll() {
        for (LogEntry logEntry : records) {
            System.out.println(logEntry);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> unigueIPs = new ArrayList<>();
        for (LogEntry logEntry : records) {
            String ip = logEntry.getIpAddress();
            if (!unigueIPs.contains(ip)) {
                unigueIPs.add(ip);
            }
        }
        return unigueIPs.size();
    }

    public int printAllHigherThanNum(int num) {
        int logsCounter = 0;
        for (LogEntry logEntry : records) {
            if (logEntry.getStatusCode() > num) {
                System.out.println(logEntry);
                logsCounter++;
            }
        }
        return logsCounter;
    }

    //parameter someday in format MMM DD  for ex.: “Dec 05
    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for (LogEntry logEntry : records) {
            String fullDate = logEntry.getAccessTime().toString();
            String date = fullDate.substring(4,10);
            if (date.equals(someday)) {
                String ip = logEntry.getIpAddress();
                if (!uniqueIPs.contains(ip)) {
                    uniqueIPs.add(ip);
                }
            }
        }
        return uniqueIPs;
    }

    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for (LogEntry logEntry : records) {
            int status = logEntry.getStatusCode();
            if (status >= low && status <= high){
                String ip = logEntry.getIpAddress();
                if (!uniqueIPs.contains(ip)) {
                    uniqueIPs.add(ip);
                }
            }
        }
        return uniqueIPs.size();
    }
}

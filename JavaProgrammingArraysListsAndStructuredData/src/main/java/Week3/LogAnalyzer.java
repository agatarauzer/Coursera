package Week3;

import Week1.predefinedClasses.FileResource;

import java.util.ArrayList;
import java.util.HashMap;

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

    //parameter someday in format MMM DD  for ex.: “Dec 05"
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

    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> counts = new HashMap<>();
        for (LogEntry logEntry : records) {
            String ip = logEntry.getIpAddress();
            if (!counts.containsKey(ip)) {
                counts.put(ip, 1);
            }
            else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        return counts;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> counts) {
        int max = 0;
        for (String key : counts.keySet()) {
            if (counts.get(key) > max) {
                max = counts.get(key);
            }
        }
        return max;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts) {
        ArrayList<String> ips = new ArrayList<>();
        int maxNumber = mostNumberVisitsByIP(counts);
        for (String key : counts.keySet()) {
            if (counts.get(key) == maxNumber) {
                ips.add(key);
            }
        }
        return ips;
    }

    //date in format MMM DD  for ex.: “Dec 05"
    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> ipsForDays = new HashMap<>();
        for (LogEntry logEntry : records) {
            String fullDate = logEntry.getAccessTime().toString();
            String date = fullDate.substring(4, 10);
            String ip = logEntry.getIpAddress();
            if (!ipsForDays.containsKey(date)) {
                ArrayList<String> ips = new ArrayList<>();
                ips.add(ip);
                ipsForDays.put(date, ips);
            } else {
                ArrayList<String> ips = ipsForDays.get(date);
                ips.add(ip);
                ipsForDays.put(date, ips);
            }
        }
        return ipsForDays;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> ipsForDays) {
        int max = 0;
        String dayOfMax = "";
        for (String day : ipsForDays.keySet()) {
            if (ipsForDays.get(day).size() > max) {
               max =  ipsForDays.get(day).size();
               dayOfMax = day;
            }
        }
        return dayOfMax;
    }

    //date in format MMM DD  for ex.: “Dec 05"
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> ipsForDays, String day) {
        ArrayList<String> ipsMax = new ArrayList<>();
        for (String dayKey : ipsForDays.keySet()) {
            if (dayKey.equals(day)) {
                HashMap<String, Integer> ipsVisitsOnDay = new HashMap<>();
                for (String ip : ipsForDays.get(dayKey)) {
                    if (!ipsVisitsOnDay.containsKey(ip)) {
                        ipsVisitsOnDay.put(ip, 1);
                    }
                    else {
                        ipsVisitsOnDay.put(ip, ipsVisitsOnDay.get(ip) + 1);
                    }
                }

                ipsMax = iPsMostVisits(ipsVisitsOnDay);
            }
        }
        return ipsMax;
    }








}

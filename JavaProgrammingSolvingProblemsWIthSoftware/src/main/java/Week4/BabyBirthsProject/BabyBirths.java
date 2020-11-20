package Week4.BabyBirthsProject;

import Week1.predefinedClasses.DirectoryResource;
import Week1.predefinedClasses.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyBirths {

    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;

        int totalNames = 0;
        int totalBoysNames = 0;
        int totalGirlsNames = 0;

        for (CSVRecord record : fr.getCSVParser(false)) {
            totalNames ++;
            int numBorn = Integer.parseInt(record.get(2));
            totalBirths += numBorn;
            if(record.get(1).equals("M")) {
                totalBoys += numBorn;
                totalBoysNames++;
            }
            else {
                totalGirls += numBorn;
                totalGirlsNames++;
            }
        }
        System.out.println("total births: " + totalBirths);
        System.out.println("total girls births: " + totalBoys);
        System.out.println("total boys births: " + totalGirls);
        System.out.println("total names: " + totalNames);
        System.out.println("total girls names: " + totalBoysNames);
        System.out.println("total boys names: " + totalGirlsNames);
    }

    public int getRank(int year, String name, String gender) {
        String fileName = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        int rank = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rank++;
                if(record.get(0).equals(name)) {
                    return rank ;
                }
            }
        }
        return -1;
    }

    public String getName(int year, int rank, String gender) {
        String fileName = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        int counter = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                counter++;
                if(counter == rank) {
                    return record.get(0);
                }
            }
        }
        return "NO NAME";
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rankInYearOfBirth = getRank(year, name, gender);
        String newName = getName(newYear, rankInYearOfBirth, gender);
        System.out.println(name + " born in " + year + " would be " + newName + " if was born in " + newYear);
    }

    //public int yearOfHighestRank(String name, String gender) {
       // DirectoryResource dr = new DirectoryResource();
        //for (File file : dr.selectedFiles()) {
        //}
    }
}

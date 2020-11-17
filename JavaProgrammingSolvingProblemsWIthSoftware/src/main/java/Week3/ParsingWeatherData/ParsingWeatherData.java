package Week3.ParsingWeatherData;

import Week1.predefinedClasses.DirectoryResource;
import Week1.predefinedClasses.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class ParsingWeatherData {

    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord min = null;
        for (CSVRecord row : parser) {
            if ((Double.parseDouble(row.get("TemperatureF"))) == -9999) {
                continue;
            }
            else {
                min = getMinOfTwo(row, min, "TemperatureF");
            }
        }
        return min;
    }

    public String fileWithColdestTemperature() {
        String fileName = "";
        DirectoryResource dr = new DirectoryResource();
        CSVRecord min = null;

        for (File file : dr.selectedFiles()) {
            FileResource fr = new FileResource(file);
            CSVRecord row = coldestHourInFile(fr.getCSVParser());
            if (min == null) {
                min = row;
            }
            else {
                double current = Double.parseDouble(row.get("TemperatureF"));
                double minimum = Double.parseDouble(min.get("TemperatureF"));
                if (current < minimum) {
                    min = row;
                    fileName = file.getName();
                }
            }
        }
        return fileName;
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord min = null;
        for (CSVRecord row : parser) {
            if (row.get("Humidity").equals("N/A")) {
                continue;
            }
            else {
                min = getMinOfTwo(row, min, "Humidity");
            }
        }
        return min;
    }

    public CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord min = null;
        for (File file : dr.selectedFiles()) {
            FileResource fr = new FileResource(file);
            CSVRecord row = lowestHumidityInFile(fr.getCSVParser());
            min = getMinOfTwo(row, min, "Humidity");
        }
        return min;
    }

    public double averageTemperatureInFile(CSVParser parser) {
        double sum = 0;
        int counter = 0;
        for (CSVRecord row : parser) {
            double temp = Double.parseDouble(row.get("TemperatureF"));
            sum += temp;
            counter++;
        }
        return sum / counter;
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double sum = 0;
        int counter = 0;
        for (CSVRecord row : parser) {
            double humidity = Double.parseDouble(row.get("Humidity"));
            if (humidity >= value) {
                double temp = Double.parseDouble(row.get("TemperatureF"));
                sum += temp;
                counter++;
            }
        }
        if (sum == 0) {
            return 0;
        }
        return sum / counter;
    }

    private CSVRecord getMinOfTwo(CSVRecord row, CSVRecord min, String column) {
        if (min == null) {
            min = row;
        }
        else {
            double current = Double.parseDouble(row.get(column));
            double minimum = Double.parseDouble(min.get(column));
            if (current < minimum) {
                min = row;
            }
        }
        return min;
    }
}

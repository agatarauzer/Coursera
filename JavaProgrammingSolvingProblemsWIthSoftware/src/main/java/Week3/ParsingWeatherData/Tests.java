package Week3.ParsingWeatherData;

import Week1.predefinedClasses.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Tests {

    private ParsingWeatherData parsingWeatherData = new ParsingWeatherData();

    public void testColdestHourInFile() {
        FileResource fileResource = new FileResource("nc_weather/2014/weather-2014-05-01.csv");
        CSVParser parser = fileResource.getCSVParser();
        CSVRecord record = parsingWeatherData.coldestHourInFile(parser);
        double temperature = Double.parseDouble(record.get("TemperatureF"));
        String time = record.get("DateUTC");

        System.out.println("Coldest temperature: " + temperature + " at: " + time);
    }

    public void testFileWithColdestTemperature() {
        String fileName = parsingWeatherData.fileWithColdestTemperature();
        FileResource fileResource = new FileResource("nc_weather/2013/" + fileName);
        CSVParser parser = fileResource.getCSVParser();
        CSVRecord record = parsingWeatherData.coldestHourInFile(parser);
        double temperature = Double.parseDouble(record.get("TemperatureF"));

        System.out.println("Coldest day was in file: " + fileName + "\nColdest temperature on that day was: " + temperature);
    }

    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord record = parsingWeatherData.lowestHumidityInFile(parser);
        double humidity = Double.parseDouble(record.get("Humidity"));
        String time = record.get("DateUTC");

        System.out.println("Lowest Humidity was: " + humidity + " at " + time);
    }

    public void testLowestHumidityInManyFiles() {
        CSVRecord min = parsingWeatherData.lowestHumidityInManyFiles();
        double humidity = Double.parseDouble(min.get("Humidity"));
        String time = min.get("DateUTC");

        System.out.println("Lowest Humidity was: " + humidity + " at " + time);
    }

    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = parsingWeatherData.averageTemperatureInFile(parser);

        System.out.println("Average temperature in file is: " + average);
    }

    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = parsingWeatherData.averageTemperatureWithHighHumidityInFile(parser, 80);
        if (average == 0) {
            System.out.println("No temperature with that humidity");
        } else {
            System.out.println("Average Temp when high Humidity is: " + average);
        }
    }
}

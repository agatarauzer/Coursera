package Week3.ParsingExportData;

import Week1.predefinedClasses.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Part1 {
    public String countryInfo(CSVParser parser, String country) {
        String result = "NOT FOUND";
        for (CSVRecord record : parser) {
            String coun = record.get("Country");
            if (coun.contains(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                result = coun + ": " + exports + ": " + value;
            }
        }
        return result;
    }

    public int howManyExports(CSVParser parser, String exportItem) {
        int counter = 0;
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem)) {
                counter++;
            }
        }
        return counter;
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }

    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                System.out.println(record.get("Country") + " " + value);
            }
        }
    }

    public void tester() {
        FileResource fr = new FileResource("exportdata.csv");

        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");

        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");

        parser = fr.getCSVParser();
        System.out.println(howManyExports(parser, "sugar"));
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.tester();
    }
}

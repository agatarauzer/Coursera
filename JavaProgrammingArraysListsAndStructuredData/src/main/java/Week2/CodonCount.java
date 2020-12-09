package Week2;

import Week1.predefinedClasses.FileResource;

import java.util.HashMap;

public class CodonCount {
    private HashMap<String, Integer> codons;

    public CodonCount() {
        codons = new HashMap<>();
    }

    public void buildCodonMap(int start, String dna) {
        codons.clear();
        for (int i = start; i <dna.length(); i += 3) {
            if (i + 4 > dna.length()) {
                break;
            }
            String codon = dna.substring(i, i + 3);
            if (codons.containsKey(codon)) {
                int value = codons.get(codon);
                codons.put(codon, value + 1);
            }
            else {
                codons.put(codon, 1);
            }
        }
    }

    public String getMostCommonCodon() {
        int max = 0;
        String maxCodon = "";
        for (String key : codons.keySet()) {
            if (codons.get(key) > max) {
                max = codons.get(key);
                maxCodon = key;
            }
        }
        return maxCodon;
    }

    public void printCodonCounts(int start, int end) {
        for (String key : codons.keySet()) {
            if (codons.get(key) >= start && codons.get(key) <= end) {
                System.out.println(key + " " + codons.get(key));
            }
        }
    }

    public void tester() {
        FileResource fr = new FileResource();
        String dna = fr.asString().toUpperCase();

        buildCodonMap(0, dna);
        System.out.println("Reading frame starting with 0 results in " + codons.size() +
        " unique codons");
        System.out.println(" and most common codon is " + getMostCommonCodon() + " with count " + codons.get(getMostCommonCodon()));
        System.out.println("Counts of codons between 1 and 5 inclusive are: " );
        printCodonCounts(1,5);

        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1 results in " + codons.size() +
                " unique codons");
        System.out.println(" and most common codon is " + getMostCommonCodon() + " with count " + codons.get(getMostCommonCodon()));
        System.out.println("Counts of codons between 1 and 5 inclusive are: " );
        printCodonCounts(1,5);

        buildCodonMap(2, dna);
        System.out.println("Reading frame starting with 2 results in " + codons.size() +
                " unique codons");
        System.out.println(" and most common codon is " + getMostCommonCodon() + " with count " + codons.get(getMostCommonCodon()));
        System.out.println("Counts of codons between 1 and 5 inclusive are: " );
        printCodonCounts(1,5);
    }
}

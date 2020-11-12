package Week2.StringThirdAssignments;

import Week1.predefinedClasses.FileResource;
import Week1.predefinedClasses.StorageResource;

public class Part3 {

    //for valid genes
    public void processGenes(StorageResource sr) {
        Part2 part2 = new Part2();

        int counterGenes = 0;
        int counterLong = 0;
        System.out.println("Genes longer than 9: ");
        for (String gene : sr.data()) {
            counterGenes++;
            if (gene.length() > 9) {
                counterLong++;
                System.out.println(gene);
            }
        }
        System.out.println("The number of genes longer than 9: " + counterLong);
        System.out.println("Number of genes: " + counterGenes);

        System.out.println("Gene with C-G ratio higher than 0.35: ");
        int counterCgRatio = 0;
        int longestGene = 0;
        for (String gene : sr.data()) {
            if (part2.cgRatio(gene) > 0.35) {
                counterCgRatio++;
                System.out.println(gene);
            }
            if (gene.length() > longestGene) {
                longestGene = gene.length();
            }
        }
        System.out.println("The number of genes with C-G ratio higher than 0.35: " + counterCgRatio);
        System.out.println("Length of the longest gene is: " + longestGene);
    }

    //first validate and modify the strand of dna to genes; next process all genes
    public void processGenesFromFile(String url) {
        Part1 part1 = new Part1();
        FileResource fr = new FileResource(url);
        String dna = fr.asString().toUpperCase();
        StorageResource sr = part1.getAllGenes(dna);
        processGenes(sr);
    }

    public void testProcessGenes() {
        String dna1 = "ATGTTTTTA";
        String dna2 = "ATGTTAAGGTTTTAGAGGAAATAA";
        String dna3 = "ATGGGGAAATTTCCCTAG";
        String dna4 = "ATGTTTCGCCCTACGTTTCCCTGA";

        StorageResource sr = new StorageResource();
        sr.add(dna1);
        sr.add(dna2);
        sr.add(dna3);
        sr.add(dna4);
        processGenes(sr);
    }

    public static void main(String[] args) {
        Part3 part3 = new Part3();
        //part3.testProcessGenes();
        part3.processGenesFromFile("brca1line_1.fa");
    }
}

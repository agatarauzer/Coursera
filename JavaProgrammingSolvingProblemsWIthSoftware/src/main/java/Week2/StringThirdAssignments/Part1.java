package Week2.StringThirdAssignments;

import Week1.predefinedClasses.StorageResource;
import Week2.StringsSecondAssignments.Part3;

public class Part1 {

    public StorageResource getAllGenes(String dna) {
        Part3 part3 = new Part3();
        int startIndex = 0;
        StorageResource res = new StorageResource();
        while(true) {
            String gene = part3.findGene(dna, startIndex);
            if (gene.isEmpty()) {
                break;
            }
            res.add(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return res;
    }

    public void testGetAllGenes() {
        StorageResource res1 = getAllGenes("ATGTAAGATGCCCTAGT");
        StorageResource res2 = getAllGenes("GGATGTTTAAATAAATGAAATGAATGAAATTTTAAATTTGGGATGAAATAGAAA");

        System.out.println("Genes in dna ATGTAAGATGCCCTAGT: ");
        for (String s : res1.data()) {
            System.out.println(s + "\n");
        }

        System.out.println("Genes in dna GGATGTTTAAATAAATGAAATGAATGAAATTTTAAATTTGGGATGAAATAGAAA: ");
        for (String s : res2.data()) {
            System.out.println(s + "\n");
        }
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testGetAllGenes();
    }
}

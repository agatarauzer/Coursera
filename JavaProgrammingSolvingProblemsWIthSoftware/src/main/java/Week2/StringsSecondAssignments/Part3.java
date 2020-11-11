package Week2.StringsSecondAssignments;

/*
methods to count all valid genes in strand of dna
 */

public class Part3 {

    //solution with modifying method findGene from Part1
    public int countGenes(String dna) {
        int startIndex = 0;
        int counter = 0;
        while (startIndex != -1) {
            int index = dna.indexOf("ATG", startIndex);
            if (index == -1) {
                return counter;
            }
            int taaIndex = findStopCodon(dna, index, "TAA");
            int tagIndex = findStopCodon(dna, index, "TAG");
            int tgaIndex = findStopCodon(dna, index, "TGA");

            int len = dna.length();
            int minIndex = Math.min(tgaIndex, (Math.min(tagIndex, taaIndex)));

            if ((taaIndex == len) || (tgaIndex != len && tgaIndex < taaIndex)) {
                minIndex = tgaIndex;
            } else {
                minIndex = taaIndex;
            }
            if ((minIndex == len) || (tagIndex != len && tagIndex < minIndex)) {
                minIndex = tagIndex;
            }
            if (minIndex == len) {
                return counter;
            }
            counter++;
            startIndex = minIndex + 3;
        }
        return counter;
    }

    //solution with using modified method findGene from Part1
    public int countGenes1(String dna) {
        int startIndex = 0;
        int counter = 0;

        while(true) {
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty()) {
                break;
            }
            counter++;
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return counter;
    }

    //add to method findGene from Part1 new parameter - index where to start searching
    public String findGene(String dna, int index) {
        int startIndex = dna.indexOf("ATG", index);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");

        int len = dna.length();
        int minIndex = Math.min(tgaIndex, (Math.min(tagIndex, taaIndex)));

        if ((taaIndex == len) || (tgaIndex != len && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        if ((minIndex == len) || (tagIndex != len && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        if (minIndex == len) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int len = currIndex - startIndex;
            if (len % 3 == 0) {
                return currIndex;
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }

    public void testCountGenes() {
        int test1 = countGenes("ATGTAAGATGCCCTAGT");
        int test2 = countGenes("GGATGTTTAAATAAATGAAATGAATGAAATTTTAAATTTGGGATGAAATAGAAA");
        int test3 = countGenes1("ATGTAAGATGCCCTAGT");
        int test4 = countGenes1("GGATGTTTAAATAAATGAAATGAATGAAATTTTAAATTTGGGATGAAATAGAAA");

        System.out.println("test1: " + test1);
        System.out.println("test2: " + test2);
        System.out.println("test3: " + test3);
        System.out.println("test4: " + test4);
    }

    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testCountGenes();
    }
}

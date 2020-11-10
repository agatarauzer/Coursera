package Week2.StringsSecondAssignments;

public class Part1 {


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

    public void testFindStopCodon() {
        String dna = "AAGGATGAAGTTGTTAGGGTTAATGGGGTAG";
        int test1 = findStopCodon(dna, 4, "TTA");
        int test2 = findStopCodon(dna, 20, "TTA" );
        String dna2 = "AAGGATGAAGTGTTGGGTTAATGGGGTAGAAGGATGAAGTTGTTAGGGTTAATGGGGTAG";
        int test3 = findStopCodon(dna2, 4, "TTA" );

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }

    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
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

    public void testFindGene() {
        String dna1ValidGene = "AAATATGAAGAATTAAGAAAATTAGTGAAAT";  //ATGAAGAATTAA
        String dna2NoATG = "AAATAAGAAGAATTAAGAAAATTAGTGAAAT";
        String dna3NoStopCodons = "ATGAAATTTGGGAAA";
        String dna4OneStopCodon = "AAATAGATGTGGAAAGGGTAGAAAGGG"; //ATGTGGAAAGGGTAG
        String dna5TwoStopCodons = "AGGATGAAAGGGGAATGAAAATAAGGG"; //ATGAAAGGGGAATGA

        System.out.println("DNA: " +  dna1ValidGene + ", gene: " + findGene(dna1ValidGene));
        System.out.println("DNA: " +  dna2NoATG + ", gene: " + findGene(dna2NoATG));
        System.out.println("DNA: " +  dna3NoStopCodons + ", gene: " + findGene(dna3NoStopCodons));
        System.out.println("DNA: " +  dna4OneStopCodon + ", gene: " + findGene(dna4OneStopCodon));
        System.out.println("DNA: " + dna5TwoStopCodons + ", gene: " + findGene(dna5TwoStopCodons));
    }




    public static void main(String[] args) {
        Part1 testPart1 = new Part1();
        //testPart1.testFindStopCodon();
        testPart1.testFindGene();
    }
}

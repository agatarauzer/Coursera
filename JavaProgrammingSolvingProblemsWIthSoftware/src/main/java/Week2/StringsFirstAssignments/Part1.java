package Week2.StringsFirstAssignments;


public class Part1 {


    public String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex < 0) {
            return "";
        }
        int endIndex = dna.indexOf("TAA", startIndex + 3);
        if (endIndex < 0) {
            return "";
        }
        if ((endIndex - startIndex - 3) % 3 == 0) {
            return dna.substring(startIndex, endIndex + 3);
        }
        return "";
    }

    public void testSimpleGene() {
        String dna1 = "AAATGTGAGTADNATAAGAT";
        String dna2 = "AAATGTGAGTDNATAAGAT";
        String dna3 = "AAAAAAAA";
        String dna4 = "ATGGDATGAATGTAA";
        String dna5 = "ATGTGAGDA";

        System.out.println("DNA 1 test:" + findSimpleGene(dna1));
        System.out.println("DNA 2 test:" + findSimpleGene(dna2));
        System.out.println("DNA 3 test:" + findSimpleGene(dna3));
        System.out.println("DNA 4 test:" + findSimpleGene(dna4));
        System.out.println("DNA 5 test:" + findSimpleGene(dna5));
    }

    public static void main(String[] args) {
        Part1 test = new Part1();
        test.testSimpleGene();
    }
}

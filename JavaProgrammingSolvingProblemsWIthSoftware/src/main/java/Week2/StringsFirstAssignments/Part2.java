package Week2.StringsFirstAssignments;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {

        if (dna.charAt(0) > 64 && dna.charAt(0) <91) {
            dna.toUpperCase();
        }
        else {
            dna.toLowerCase();
        }

        int startIndex = dna.indexOf(startCodon);
        if (startIndex < 0) {
            return "";
        }
        int endIndex = dna.indexOf(stopCodon, startIndex + 3);
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
        String dna2 = "AAATGTGARGTDNATAAGAT";
        String dna3 = "aahgtatgattaggtggtaagtt";
        String dna4 = "ATGGDATGAATGTAA";
        String dna5 = "ATGTGAGDA";

        System.out.println("DNA 1 test:" + findSimpleGene(dna1, "ATG", "TAA"));
        System.out.println("DNA 2 test:" + findSimpleGene(dna2, "ATG", "TAA"));
        System.out.println("DNA 3 test:" + findSimpleGene(dna3, "atg", "taa"));
        System.out.println("DNA 4 test:" + findSimpleGene(dna4, "ATG", "TAA"));
        System.out.println("DNA 5 test:" + findSimpleGene(dna5, "ATG", "TAA"));
    }

    public static void main(String[] args) {
        Part2 test = new Part2();
        test.testSimpleGene();
    }
}

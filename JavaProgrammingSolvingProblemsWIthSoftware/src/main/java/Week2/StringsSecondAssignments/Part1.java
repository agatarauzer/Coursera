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

    public static void main(String[] args) {
        Part1 testPart1 = new Part1();
        testPart1.testFindStopCodon();
    }
}

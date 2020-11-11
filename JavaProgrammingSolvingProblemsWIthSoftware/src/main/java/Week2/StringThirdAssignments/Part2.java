package Week2.StringThirdAssignments;

public class Part2 {

    public float cgRatio(String dna) {
        int cgCounter = 0;
        dna.toUpperCase();
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'C' || dna.charAt(i) == 'G') {
                cgCounter++;
            }
            System.out.println(cgCounter);
        }
        return (float) cgCounter / dna.length();
    }

    public int countCTG(String dna) {
        int counter = 0;
        int startIndex = dna.indexOf("CTG");
        while (startIndex != -1) {
            counter++;
            startIndex = dna.indexOf("CTG", startIndex + 3);
        }
        return counter;
    }

    public void testCgRatio() {
        String dna = "ATGCCATAG";
        System.out.println(cgRatio(dna));
    }

    public void testCountCTG() {
        String dna = "ATGCCATAG";
        String dna2 = "ATGCTGAAATTTCTGCTGAAA";
        System.out.println(countCTG(dna2));
        System.out.println(countCTG(dna));
    }

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.testCgRatio();
        part2.testCountCTG();
    }
}

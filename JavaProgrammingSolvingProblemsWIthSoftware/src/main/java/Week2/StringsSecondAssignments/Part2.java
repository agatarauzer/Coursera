package Week2.StringsSecondAssignments;

public class Part2 {

    public int howMany(String stringa, String stringb) {
        int counter = 0;
        int index = 0;

        while (index < stringb.length()) {
            index = stringb.indexOf(stringa, index);
            if (index == -1) {
                return counter;
            }
            else {
                counter++;
                index += stringa.length();
            }
        }
        return counter;
    }

    public void testHowMany() {
        int test1 = howMany("GAA", "ATGAACGAATTGAATC");
        int test2 = howMany("AA", "ATAAAA");
        int test3 = howMany("DRA", "OPPDTTFRRHHSGSGSGSS");
        System.out.println("test1: " + test1);
        System.out.println("test2: " + test2);
        System.out.println("test2: " + test3);
    }

    public static void main(String[] args) {
        Part2 test = new Part2();
        test.testHowMany();
    }
}

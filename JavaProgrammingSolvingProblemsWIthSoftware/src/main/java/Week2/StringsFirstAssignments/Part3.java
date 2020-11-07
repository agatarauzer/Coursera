package Week2.StringsFirstAssignments;

public class Part3 {


    public boolean twoOccurrences(String stringa, String stringb) {

        int firstOcc = stringb.indexOf(stringa);
        if (firstOcc > 0) {
            int secondOcc = stringb.indexOf(stringa, firstOcc + stringa.length());
            if (secondOcc > 0) {
                return true;
            }
        }
            return false;
    }

    public String lastPart(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);
        if (index < 0 ) {
            return stringb;
        }
        return stringb.substring(index + stringa.length());
    }

    public void testing() {
        boolean test1 = twoOccurrences("by", "A story by Abby Long");
        boolean test2 = twoOccurrences("a", "banana");
        boolean test3 = twoOccurrences("bye", "habtajajadhd");
        System.out.println("test1 result: " + test1);
        System.out.println("test2 result: " + test2);
        System.out.println("test3 result: " + test3);

        String testLast1 = lastPart("an", "banana");
        String testLast2 = lastPart("zoo", "forest");
        System.out.println("test1 lastPart result: " + testLast1);
        System.out.println("test2 lastPart result: " + testLast2);
    }

    public static void main(String args[]) {
        Part3 test = new Part3();
        test.testing();
    }
}

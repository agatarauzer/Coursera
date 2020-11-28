package Week1;

import Week1.predefinedClasses.FileResource;

public class WordLengths {

    public void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            boolean isPrefixALetter = Character.isLetter(word.charAt(0));
            boolean isSufixALetter = Character.isLetter(word.charAt(word.length() - 1));
            if (!isPrefixALetter) {
                word = word.substring(0, 1);
            }
            if (!isSufixALetter) {
                word = word.substring(0,word.length()-1);
            }
            int len = word.length();
            if (len > counts.length) {
                counts[counts.length - 1] += 1;
            }
            counts[len] += 1;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println("words of length " + i + ": " + counts[i]);
        }
    }
}

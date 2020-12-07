package Week2;

import Week1.predefinedClasses.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies() {
        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();
    }

    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for (String word : fr.words()) {
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index == -1) {
                myWords.add(word);
                myFreqs.add(1);
            }
            else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }

    public int findIndexOfMax() {
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) > max) {
                max = myFreqs.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void tester() {
        findUnique();
        System.out.println("Unique words:" + myWords.size());
        for (int i = 0; i < myWords.size(); i++) {
            System.out.println(myWords.get(i) + " " + myFreqs.get(i));
        }

        System.out.println("The word that occurs most often and its count are: " +
        myWords.get(findIndexOfMax()) + " " + myFreqs.get(findIndexOfMax()));
    }
}

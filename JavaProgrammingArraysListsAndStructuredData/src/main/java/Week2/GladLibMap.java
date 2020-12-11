package Week2;

import Week1.predefinedClasses.FileResource;
import Week1.predefinedClasses.URLResource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> usedWords;
    private ArrayList<String> usedCategories;
    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "GladLib/datalong/";

    public GladLibMap() {
        myMap = new HashMap<>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        usedWords = new ArrayList<>();
        usedCategories = new ArrayList<>();
    }

    public GladLibMap(String source) {
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {
        String[] categoriesList = {"adjective", "noun", "color", "country", "name", "animal",
        "timeframe", "verb", "fruit"};
        ArrayList<String> categories = new ArrayList<>();
        categories.addAll(Arrays.asList(categoriesList));
        for (int i = 0; i < categories.size(); i++) {
            ArrayList<String> words = readIt(source + categories.get(i) + ".txt");
            myMap.put(categories.get(i), words);
        }
    }

    private String randomFrom(ArrayList<String> source) {
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        addToUsedCategories(label);
        if (label.equals("number")) {
            return "" + myRandom.nextInt(50) + 5;
        }
        for (String key : myMap.keySet()) {
            if (key.equals(label)) {
                return randomFrom(myMap.get(key));
            }
        }
        return "**UNKNOWN**";
    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1) {
            return w;
        }
        String prefix = w.substring(0, first);
        String suffix = w.substring(last + 1);
        String sub = getSubstitute(w.substring(first + 1, last));
        while (usedWords.contains(sub)) {
            sub = getSubstitute(w.substring(first + 1, last));
        }
        usedWords.add(sub);
        return prefix + sub + suffix;
    }

    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for (String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }

    private void addToUsedCategories(String label) {
        if (!usedCategories.contains(label)) {
            usedCategories.add(label);
        }
    }

    public int totalWordsInMap() {
        int allWords = 0;
        for (String key : myMap.keySet()) {
            allWords += myMap.get(key).size();
        }
        return allWords;
    }

    public int totalWordsConsidered() {
        int sumOfWords = 0;
        for (int i = 0; i < usedCategories.size(); i++) {
            String key = usedCategories.get(i);
            if (myMap.containsKey(key)) {
                sumOfWords += myMap.get(key).size();
            }
        }
        return sumOfWords;
    }

    public void makeStory() {
        usedWords.clear();
        System.out.println("\n");
        String story = fromTemplate("GladLib/datalong/madtemplate3.txt");
        printOut(story, 60);
        System.out.println("\n\nNumber of replaced words: " + usedWords.size());
        System.out.println("Number of words to pick from: " + totalWordsInMap());
        System.out.println("Sum of considered words: " + totalWordsConsidered());
    }
}



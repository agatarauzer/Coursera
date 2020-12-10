package Week2;

import Week1.predefinedClasses.DirectoryResource;
import Week1.predefinedClasses.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> words;

    public WordsInFiles() {
        words = new HashMap<>();
    }

    private void addWordsFromFile(File f) {
        FileResource fileResource = new FileResource(f);
        for (String word : fileResource.words()) {
            if (words.containsKey(word)) {
                ArrayList<String> files = words.get(word);
                if (!files.contains(f.getName())) {
                    files.add(f.getName());
                    words.put(word, files);
                }
            }
            else {
                ArrayList<String> files = new ArrayList<>();
                files.add(f.getName());
                words.put(word, files);
            }
        }
    }

    public void buildWordFileMap() {
        words.clear();
        DirectoryResource directoryResource = new DirectoryResource();

        for (File file : directoryResource.selectedFiles()) {
            addWordsFromFile(file);
        }
    }

    public int maxNumber() {
        int maxNumber = 0;
        for (String key : words.keySet()) {
            if (words.get(key).size() > maxNumber) {
                maxNumber = words.get(key).size();
            }
        }
        return maxNumber;
    }

    public ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> resultWords = new ArrayList<>();
        for (String key : words.keySet()) {
            if (words.get(key).size() == number) {
                resultWords.add(key);
            }
        }
        return resultWords;
    }


}

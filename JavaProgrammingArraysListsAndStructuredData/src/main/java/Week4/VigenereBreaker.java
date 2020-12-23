package Week4;

import Week1.predefinedClasses.DirectoryResource;
import Week1.predefinedClasses.FileResource;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class VigenereBreaker {

    public void breakVigenere() {
        HashMap<String, HashSet<String>> languages = new HashMap<>();
        DirectoryResource directoryResource = new DirectoryResource();
        for (File file : directoryResource.selectedFiles()) {
            FileResource fileResource = new FileResource(file.toString());
            HashSet<String> dictionary = readDictionary(fileResource);
            languages.put(file.getName(), dictionary);
            System.out.println("Opened dictionary: " + file.getName());
        }
        FileResource fileResource = new FileResource();
        String message = fileResource.asString();
        String decrypted = breakForAllLangs(message, languages);
        System.out.println(decrypted);
    }

    public HashSet<String> readDictionary(FileResource fileResource) {
        HashSet<String> lines = new HashSet<>();
        for (String line : fileResource.lines()) {
            lines.add(line.toLowerCase());
        }
        return lines;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int wordsMax = 0;
        String decrypted = "";
        int keyLen = 0;
        int[] correctKey = new int[100];
        for (int i = 1; i <= 100; i++) {
            char mostCommonCh = mostCommonCharIn(dictionary);
            int[] key = tryKeyLength(encrypted, i, mostCommonCh);
            VigenereCipher vigenereCipher = new VigenereCipher(key);
            String message = vigenereCipher.decrypt(encrypted);
            int correctWords = countWords(message, dictionary);
            if (correctWords > wordsMax) {
                wordsMax = correctWords;
                decrypted = message;
                keyLen = i;
                correctKey = key;
            }
        }
        System.out.println(wordsMax);
        System.out.println(keyLen);
        System.out.println(Arrays.toString(correctKey));
        return decrypted;
    }

    public char mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<Character, Integer> letters = new HashMap<>();
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (!letters.containsKey(letter)) {
                    letters.put(letter, 1);
                }
                else {
                    letters.put(letter, letters.get(letter) + 1);
                }
            }
        }
        int max = 0;
        char keyOfMax = 'a';
        for (Character key : letters.keySet()) {
            if (letters.get(key) > max) {
                max = letters.get(key);
                keyOfMax = key;
            }
        }
        return keyOfMax;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        CaesarCracker caesarCracker = new CaesarCracker();
        int[] key = new int[klength];
        for (int i = 0; i < klength; i++) {
            String part = sliceString(encrypted, i, klength);
            key[i] = caesarCracker.getKey(part);
        }
        return key;
    }

    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i += totalSlices) {
            stringBuilder.append(message.charAt(i));
        }
        return stringBuilder.toString();
    }

    public int countWords(String message, HashSet<String> dictionary) {
        int counter = 0;
        String[] words = message.split("\\W+");
        for (int i = 0; i < words.length; i++) {
            if (dictionary.contains(words[i].toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }

    public String breakForAllLangs(String encrypted, HashMap<String,HashSet<String>> languages) {
        int correctWordsMax = 0;
        String correctMessage = "";
        String correctLan = "";
        for (String lan : languages.keySet()) {
            HashSet<String> dictionary = languages.get(lan);
            String decryptedInLan = breakForLanguage(encrypted, dictionary);
            int correctWordsInLan = countWords(decryptedInLan, dictionary);
            if (correctWordsInLan > correctWordsMax) {
                correctWordsMax = correctWordsInLan;
                correctMessage = decryptedInLan;
                correctLan = lan;
            }
        }
        System.out.println("Words: " + correctWordsMax);
        System.out.println("Language: " + correctLan + "\n");
        return correctMessage;
    }
}

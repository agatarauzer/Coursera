package Week4;

import Week1.predefinedClasses.FileResource;

import java.util.Arrays;
import java.util.HashSet;

public class VigenereBreaker {

    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i += totalSlices) {
            stringBuilder.append(message.charAt(i));
        }
        return stringBuilder.toString();
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

    public void breakVigenere() {
        FileResource fileResource = new FileResource();
        String message = fileResource.asString();
        FileResource fileDictionary = new FileResource();
        int[] key = tryKeyLength(message, 5, 'e');
        HashSet<String> dictionary = readDictionary(fileDictionary);
        VigenereCipher vigenereCipher = new VigenereCipher(key);
        String decrypted = breakForLanguage(message, dictionary);
        System.out.println(decrypted);
    }

    public HashSet<String> readDictionary(FileResource fileResource) {
        HashSet<String> lines = new HashSet<>();
        for (String line : fileResource.lines()) {
            lines.add(line.toLowerCase());
        }
        return lines;
    }

    public int countWords(String message, HashSet<String> dictionary) {
        int counter = 0;
        String[] words = message.split("\\W+");
        System.out.println("Total words in file: " + words.length);
        for (int i = 0; i < words.length; i++) {
            if (dictionary.contains(words[i].toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int wordsMax = 0;
        String decrypted = "";
        int keyLen = 0;
        int[] correctKey = new int[100];
        for (int i = 1; i <= 100; i++) {
            int[] key = tryKeyLength(encrypted, i, 'e');
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
}

package Week4;

import Week1.predefinedClasses.FileResource;

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
        int[] key = tryKeyLength(message, 4, 'e');
        VigenereCipher vigenereCipher = new VigenereCipher(key);
        System.out.println(vigenereCipher.decrypt(message));
    }
}

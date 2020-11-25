package Week1;

import Week1.predefinedClasses.FileResource;

public class CaesarCipher {

    public String encrypt(String input, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            boolean isLowerCase = Character.isLowerCase(input.charAt(i));
            char ch = Character.toLowerCase(input.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                if (isLowerCase) {
                    encrypted.setCharAt(i, shiftedAlphabet.charAt(index));
                }
                else {
                    encrypted.setCharAt(i, shiftedAlphabet.toUpperCase().charAt(index));
                }
            }
        }
        return encrypted.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabetFirstKey = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabetSecondKey = alphabet.substring(key2) + alphabet.substring(0, key2);
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            boolean isLowerCase = Character.isLowerCase(input.charAt(i));
            char ch = Character.toLowerCase(input.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                if ((i+1) % 2 != 0 ) {
                    if (isLowerCase) {
                        encrypted.setCharAt(i, shiftedAlphabetFirstKey.charAt(index));
                    }
                    else {
                        encrypted.setCharAt(i, shiftedAlphabetFirstKey.toUpperCase().charAt(index));
                    }
                }
                else {
                    if (isLowerCase) {
                        encrypted.setCharAt(i, shiftedAlphabetSecondKey.charAt(index));
                    }
                    else {
                        encrypted.setCharAt(i, shiftedAlphabetSecondKey.toUpperCase().charAt(index));
                    }
                }
            }
        }
        return encrypted.toString();
    }
}

package Week1;

public class CaesarBreaker {

    private CaesarCipher caesarCipher = new CaesarCipher();

    public String decrypt(String encrypted) {
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return caesarCipher.encrypt(encrypted, 26 - dkey);
    }

    public String decryptTwoKeys(String encrypted) {
        String partOne = halfOfString(encrypted, 0);
        String partTwo = halfOfString(encrypted, 1);
        int key1 = getKey(partOne);
        int key2 = getKey(partTwo);
        System.out.println("Key 1: " + key1 + ", key 2: " + key2);

        return caesarCipher.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
    }

    public String decryptTwoKeys(String encrypted, int key1, int key2) {
        return caesarCipher.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
    }

    public int[] countLetters(String input) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char ch = Character.toLowerCase(input.charAt(i));
            int dex = alphabet.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }

    public int maxIndex(int[] values) {
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public String halfOfString(String message, int start) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < message.length(); i = i + 2) {
            result.append(message.charAt(i));
        }
        return result.toString();
    }

    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }
}

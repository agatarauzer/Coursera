package Week1;

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
}

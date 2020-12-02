package Week1;

public class CaesarCipherObjectOriented {
    private String alphabet;
    private String shiftedAlphabet;
    private int key;

    public CaesarCipherObjectOriented(int key) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        this.key = key;
    }

    public String encrypt(String input) {
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

    public String decrypt(String input) {
        CaesarCipherObjectOriented cc = new CaesarCipherObjectOriented(26 - key);
        return cc.encrypt(input);
    }
}

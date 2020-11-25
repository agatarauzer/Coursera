package Week1;

public class WordPlay {

    public boolean isVowel(char ch) {
        String vowels = "aAeEiIoOuU";
        for (int i = 0; i < vowels.length(); i++) {
            if (vowels.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    public String replaceVowels(String phrase, char ch) {
        StringBuilder sb = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            if (isVowel(phrase.charAt(i))) {
                sb.setCharAt(i, ch);
            }
        }
        return sb.toString();
    }

    public String emphasize(String phrase, char ch) {
        StringBuilder sb = new StringBuilder(phrase);
        String phraseUpper = phrase.toUpperCase();
        String phraseLower = phrase.toLowerCase();
        for (int i = 0; i < phrase.length(); i++) {
            if (phraseUpper.charAt(i) == ch || phraseLower.charAt(i) == ch) {
                if ((i + 1) % 2 == 0) {
                    sb.setCharAt(i, '+');
                }
                else {
                    sb.setCharAt(i, '*');
                }
            }
        }
        return sb.toString();
    }
}

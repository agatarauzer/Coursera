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

    //public String replaceVowels(String phrase, char ch) {

    //}
}

package Week1;

import org.junit.Assert;
import org.junit.Test;

public class WordPlayTests {
    WordPlay wordPlay = new WordPlay();

    @Test
    public void isVowelTest() {
        Assert.assertTrue(wordPlay.isVowel('a'));
        Assert.assertTrue(wordPlay.isVowel('E'));
        Assert.assertTrue(wordPlay.isVowel('i'));

        Assert.assertFalse(wordPlay.isVowel('F'));
        Assert.assertFalse(wordPlay.isVowel('d'));
        Assert.assertFalse(wordPlay.isVowel('Z'));
    }
}

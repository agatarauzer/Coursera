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

    @Test
    public void replaceVowelsTest() {
        Assert.assertEquals("H*ll* W*rld", wordPlay.replaceVowels("Hello World", '*'));
        Assert.assertEquals("Whxt xs yxxr nxmx?", wordPlay.replaceVowels("What is your name?", 'x'));
    }

    @Test
    public void emphasizeTest() {
        Assert.assertEquals("dn* ctg+*+ctg+", wordPlay.emphasize("dna ctgaaactga", 'a'));
        Assert.assertEquals("M+ry Bell+ +br*c*d*br+", wordPlay.emphasize("Mary Bella Abracadabra", 'a'));
    }
}


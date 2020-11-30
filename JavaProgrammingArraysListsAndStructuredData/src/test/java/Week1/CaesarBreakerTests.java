package Week1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaesarBreakerTests {
    private CaesarBreaker caesarBreaker;

    @Before
    public void before() {
        caesarBreaker = new CaesarBreaker();
    }

    @Test
    public void countLettersTest() {
        String message = "abrakadabra alahomora";
        int[] result = caesarBreaker.countLetters(message);
        Assert.assertEquals(8, result[0]);
        Assert.assertEquals(2, result[1]);
        Assert.assertEquals(1, result[3]);
        Assert.assertEquals(1, result[7]);
        Assert.assertEquals(1, result[10]);
    }

    @Test
    public void maxIndexTest() {
        String message = "abrakadabra alahomora";
        int[] result = caesarBreaker.countLetters(message);
        Assert.assertEquals(0, caesarBreaker.maxIndex(result));
    }

    @Test
    public void halfOfStringTest() {
        String message = "abrakadabra arr";

        String resultStart0 = caesarBreaker.halfOfString(message, 0);
        Assert.assertEquals("arkdbaar", resultStart0);

        String resultStart1 = caesarBreaker.halfOfString(message, 1);
        Assert.assertEquals("baaar r", resultStart1);
    }

    @Test
    public void getKeyTest() {
        String message = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
        String halfOfMessage = caesarBreaker.halfOfString(message, 0);
        int key = caesarBreaker.getKey(halfOfMessage);
        Assert.assertEquals(23, key);
    }

    @Test
    public void caesarBreakerTest() {
        String messageToDecrypt = "Lwuv c ukorng oguucig ykvj gggggg";
        String originalMessage = "Just a simple message with eeeeee";
        Assert.assertEquals(originalMessage, caesarBreaker.decrypt(messageToDecrypt));
    }

    @Test
    public void caesarBreakerWithTwoKeysTest() {
        String messageToDecrypt = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
        String originalMessage = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        Assert.assertEquals(originalMessage, caesarBreaker.decryptTwoKeys(messageToDecrypt));
    }
}

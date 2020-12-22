package Week4;

import Week1.predefinedClasses.FileResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class VigenereBreakerTests {

    private VigenereBreaker vigenereBreaker;

    @Before
    public void before() {
        vigenereBreaker = new VigenereBreaker();
    }

    @Test
    public void testSliceString() {
        String str = "abcdefghijklm";

        Assert.assertEquals("adgjm", vigenereBreaker.sliceString(str, 0, 3));
        Assert.assertEquals("behk", vigenereBreaker.sliceString(str, 1, 3));
        Assert.assertEquals("cfil", vigenereBreaker.sliceString(str, 2, 3));
        Assert.assertEquals("aeim", vigenereBreaker.sliceString(str, 0, 4));
        Assert.assertEquals("bfj", vigenereBreaker.sliceString(str, 1, 4));
        Assert.assertEquals("cgk", vigenereBreaker.sliceString(str, 2,4));
        Assert.assertEquals("bfj", vigenereBreaker.sliceString(str, 1, 4));
        Assert.assertEquals("cgk", vigenereBreaker.sliceString(str, 2,4));
        Assert.assertEquals("dhl", vigenereBreaker.sliceString(str, 3, 4));
        Assert.assertEquals("afk", vigenereBreaker.sliceString(str, 0,5));
        Assert.assertEquals("bgl", vigenereBreaker.sliceString(str, 1, 5));
        Assert.assertEquals("chm", vigenereBreaker.sliceString(str, 2,5));
        Assert.assertEquals("di", vigenereBreaker.sliceString(str, 3, 5));
        Assert.assertEquals("ej", vigenereBreaker.sliceString(str, 4,5));
    }

    @Test
    public void testTryKeyLength() {
        FileResource fileResource = new FileResource("VigenereCipher/athens_keyflute.txt");
        String message = fileResource.asString();
        int[] key = vigenereBreaker.tryKeyLength(message, 5, 'e');
        String keyStr = Arrays.toString(key);
        Assert.assertEquals("[5, 11, 20, 19, 4]", keyStr);
    }
}

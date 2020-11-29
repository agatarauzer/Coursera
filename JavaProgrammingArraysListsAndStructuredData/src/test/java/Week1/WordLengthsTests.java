package Week1;

import Week1.predefinedClasses.FileResource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordLengthsTests {
    private WordLengths wordLengths;
    private FileResource fileResource;
    private int[] arr;
    private int[] resultArr;

    @Before
    public void before() {
        wordLengths = new WordLengths();
        fileResource = new FileResource("smallHamlet.txt");
        arr = new int[31];
        resultArr = wordLengths.countWordLengths(fileResource, arr);
    }

    @Test
    public void countWordLengthsTests() {
        Assert.assertEquals(2, resultArr[2]);
        Assert.assertEquals(3, resultArr[3]);
        Assert.assertEquals(2, resultArr[4]);
        Assert.assertEquals(1, resultArr[5]);
        Assert.assertEquals(1, resultArr[6]);
        Assert.assertEquals(1, resultArr[7]);
        Assert.assertEquals(2, resultArr[8]);
        Assert.assertEquals(1, resultArr[11]);
    }

    @Test
    public void indexOfMaxTests() {
        Assert.assertEquals(3, wordLengths.indexOfMax(resultArr));
    }
}


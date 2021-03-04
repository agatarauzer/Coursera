package spelling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class NearbyWordsTester {

    private Dictionary d;
    private String dataFile = "MOOCTextEditor/data/dict.txt";
    private NearbyWords w;

    @Before
    public void setUp() {
        d = new DictionaryHashSet();
        DictionaryLoader.loadDictionary(d, dataFile);

        w = new NearbyWords(d);
    }

    @Test
    public void testDistanceOne() {
        String word = "i";
        List<String> l = w.distanceOne(word, true);
        Assert.assertEquals(35, l.size());
        Assert.assertTrue(l.contains("pi"));
        Assert.assertTrue(l.contains("z"));

        //System.out.println("One away word Strings for for \""+word+"\" are:");
        //System.out.println(l+"\n");

        word = "tailo";
        List<String> li = w.distanceOne(word, true);
        Assert.assertEquals(2, li.size());
        Assert.assertTrue(li.contains("tails"));
        Assert.assertTrue(li.contains("tail"));

        //System.out.println("One away word Strings for for \""+word+"\" are:");
        //System.out.println(li+"\n");



    }



    /*
    String word = "i";
    // Pass NearbyWords any Dictionary implementation you prefer
    Dictionary d = new DictionaryHashSet();
	   DictionaryLoader.loadDictionary(d, "data/dict.txt");
    NearbyWords w = new NearbyWords(d);
    List<String> l = w.distanceOne(word, true);
	   System.out.println("One away word Strings for for \""+word+"\" are:");
	   System.out.println(l+"\n");

    word = "tailo";
    List<String> suggest = w.suggestions(word, 10);
	   System.out.println("Spelling Suggestions for \""+word+"\" are:");
	   System.out.println(suggest);

     */
}

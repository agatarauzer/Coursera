package Week1;

import org.junit.Assert;
import org.junit.Test;

public class CaesarCipherTests {
    CaesarCipher caesarCipher = new CaesarCipher();

    @Test
    public void caesarCipherTestUpperCase() {
        Assert.assertEquals("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!", caesarCipher.encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
    }

    @Test
    public void caesarCipherTestMixed() {
        Assert.assertEquals("Cfopq Ibdflk", caesarCipher.encrypt("First Legion", 23));
        Assert.assertEquals("Wzijk Cvxzfe", caesarCipher.encrypt("First Legion", 17));

    }

}

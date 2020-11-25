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
        Assert.assertEquals("Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!", caesarCipher.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));

    }

    @Test
    public void caesarCipherTestTwoKeys() {
        Assert.assertEquals("Czojq Ivdzle", caesarCipher.encryptTwoKeys("First Legion", 23, 17));
        Assert.assertEquals("Io iwjv jz dv bcm kjvammmikz mwju edbc twpz pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!", caesarCipher.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }

}

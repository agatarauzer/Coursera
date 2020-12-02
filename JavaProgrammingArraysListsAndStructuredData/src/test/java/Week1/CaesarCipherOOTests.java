package Week1;

import org.junit.Assert;
import org.junit.Test;

public class CaesarCipherOOTests {

    @Test
    public void encryptTests() {
        CaesarCipherObjectOriented cc = new CaesarCipherObjectOriented(23);
        String input = "First Legion";
        Assert.assertEquals("Cfopq Ibdflk", cc.encrypt(input));
    }

    @Test
    public void decryptTests() {
        String input = "Cfopq Ibdflk";
        CaesarCipherObjectOriented cc1 = new CaesarCipherObjectOriented( 23);
        Assert.assertEquals("First Legion", cc1.decrypt(input));
    }
}

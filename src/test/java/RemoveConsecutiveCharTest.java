import org.junit.Assert;
import org.junit.Test;
import service.RepeatStringRemoval;
import service.StringServiceImpl;

public class RemoveConsecutiveCharTest {
    StringServiceImpl service = new RepeatStringRemoval();

    @Test
    public void removeConsecutiveCharTest1(){

        String i = this.service.process("aacccad");
        String j = "d";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest2(){

        String i = this.service.process("aacccadddd");
        String j = "";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest3(){

        String i = this.service.process("aaacccadddd");
        String j = "a";

        Assert.assertEquals(i, j);
    }


    @Test
    public void removeConsecutiveCharTest4(){

        String i = this.service.process("aa");
        String j = "aa";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest5(){

        String i = this.service.process("aabcccbbdddbddddbdddddddd");
        String j = "aa";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest6(){

        String i = this.service.process("a3");
        String j = "";

        Assert.assertEquals(i, j);

        i = this.service.process("aAa");
        j = "";

        Assert.assertEquals(i, j);

        i = this.service.process("a ");
        j = "";

        Assert.assertEquals(i, j);

        i = this.service.process("a$");
        j = "";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest7(){

        String i = this.service.process("abbdcccddba");
        String j = "aa";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest8(){

        String i = this.service.process("abbdcccddbaa");
        String j = "";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest9(){

        String i = this.service.process("aaa");
        String j = "";

        Assert.assertEquals(i, j);
    }


}

import org.junit.Assert;
import org.junit.Test;
import service.RepeatStringReplacement;
import service.StringServiceImpl;

public class ReplaceConsecutiveCharTest {

    StringServiceImpl service = new RepeatStringReplacement();

    Integer tag = 2;

    @Test
    public void replaceConsecutiveCharTest0(){

        String i = this.service.process("ccc");
        String j = "b";

        Assert.assertEquals(i, j);

        i = this.service.process("bbb");
        j = "a";

        Assert.assertEquals(i, j);

        i = this.service.process("abcccbad");
        j = "d";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest1(){

        String i = this.service.process("aacccad");
        String j = "aabad";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest2(){

        String i = this.service.process("aaacccdddd");
        String j = "bc";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest3(){

        String i = this.service.process("aaacccaadddd");
        String j = "baac";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest4(){

        String i = this.service.process("aa");
        String j = "aa";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest5(){

        String i = this.service.process("aabcccbbdddbddddbddd");
        String j = "cbcbc";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest6(){

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

        String i = this.service.process("bccdeeeddcbb");
        String j = "a";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest8(){

        String i = this.service.process("abbcdddccbaa");
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

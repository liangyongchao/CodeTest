import org.junit.Assert;
import org.junit.Test;
import service.RepeatStringReplacement;
import service.StringServiceImpl;

public class ReplaceConsecutiveCharTest {

    StringServiceImpl service = new RepeatStringReplacement();

    Integer tag = 2;

    @Test
    public void replaceConsecutiveCharTest0(){

        String i = this.service.process("ccc", tag);
        String j = "b";

        Assert.assertEquals(i, j);

        i = this.service.process("bbb", tag);
        j = "a";

        Assert.assertEquals(i, j);

        i = this.service.process("abcccbad", tag);
        j = "d";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest1(){

        String i = this.service.process("aacccad", tag);
        String j = "aabad";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest2(){

        String i = this.service.process("aaacccdddd", tag);
        String j = "bc";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest3(){

        String i = this.service.process("aaacccaadddd", tag);
        String j = "baac";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest4(){

        String i = this.service.process("aa", tag);
        String j = "aa";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest5(){

        String i = this.service.process("aabcccbbdddbddddbddd", tag);
        String j = "cbcbc";

        Assert.assertEquals(i, j);
    }

    @Test
    public void replaceConsecutiveCharTest6(){

        String i = this.service.process("a3", tag);
        String j = "";

        Assert.assertEquals(i, j);

        i = this.service.process("aAa", tag);
        j = "";

        Assert.assertEquals(i, j);

        i = this.service.process("a ", tag);
        j = "";

        Assert.assertEquals(i, j);

        i = this.service.process("a$", tag);
        j = "";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest7(){

        String i = this.service.process("bccdeeeddcbb", tag);
        String j = "a";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest8(){

        String i = this.service.process("abbcdddccbaa", tag);
        String j = "";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest9(){

        String i = this.service.process("aaa", tag);
        String j = "";

        Assert.assertEquals(i, j);
    }

}

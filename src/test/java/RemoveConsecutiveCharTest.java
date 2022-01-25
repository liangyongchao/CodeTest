import org.junit.Assert;
import org.junit.Test;
import service.StringService;
import service.StringServiceImpl;

public class RemoveConsecutiveCharTest {
    StringService service = new StringServiceImpl();

    Integer tag = 1;

    @Test
    public void removeConsecutiveCharTest1() {

        String i = this.service.process("aacccad", tag);
        String j = "d";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest2() {

        String i = this.service.process("aacccadddd", tag);
        String j = "";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest3() {

        String i = this.service.process("aaacccadddd", tag);
        String j = "a";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest4() {

        String i = this.service.process("aa", tag);
        String j = "aa";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest5() {

        String i = this.service.process("aabcccbbdddbddddbddd", tag);
        String j = "aa";

        Assert.assertEquals(i, j);
    }

    @Test
    public void removeConsecutiveCharTest7() {

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


}

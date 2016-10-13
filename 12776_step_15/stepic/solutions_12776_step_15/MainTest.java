package stepic.solutions_12776_step_15;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by ipetrash on 13.10.2016.
 */
public class MainTest {
    @Test
    public void test1() throws Exception {
        InputStream in = new ByteArrayInputStream("1 2 3 4 5 6 7".getBytes());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setIn(in);
        System.setOut(printStream);

        Main.main(null);

        Assert.assertEquals(outputStream.toString(), "6 4 2 ");
    }
}
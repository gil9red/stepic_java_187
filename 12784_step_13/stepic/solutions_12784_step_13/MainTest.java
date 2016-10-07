package stepic.solutions_12784_step_13;

import org.junit.Test;
import java.io.*;

import static org.junit.Assert.assertEquals;


/**
 * Created by ipetrash on 06.10.2016.
 */
public class MainTest {
    @Test
    public void TestInput1() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1 2 3".getBytes());

        assertEquals("6.000000", doTest(inputStream));
    }

    @Test
    public void TestInput2() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("a1 b2 c3".getBytes());

        assertEquals("0.000000", doTest(inputStream));
    }

    @Test
    public void TestInput3() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("-1e3\n18 .111 11bbb".getBytes());

        assertEquals("-981.889000", doTest(inputStream));
    }

    public String doTest(ByteArrayInputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setIn(inputStream);
        System.setOut(printStream);
        Main.main(null);

        return outputStream.toString();
    }
}
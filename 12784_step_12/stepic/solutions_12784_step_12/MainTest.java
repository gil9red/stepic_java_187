package stepic.solutions_12784_step_12;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

/**
 * Created by ipetrash on 07.10.2016.
 */
public class MainTest {
    @Test
    public void test_UTF_8() throws Exception {
        byte[] byteArray = {48, 49, 50, 51};
        String text = Main.readAsString(new ByteArrayInputStream(byteArray), StandardCharsets.UTF_8);
        assertEquals(text, "0123");
    }

    @Test
    public void test_UTF_16() throws Exception {
        byte[] byteArray = {48, 49, 50, 51};
        String text = Main.readAsString(new ByteArrayInputStream(byteArray), StandardCharsets.UTF_16);
        assertEquals(text, "〱㈳");
    }

    @Test
    public void test_US_ASCII() throws Exception {
        byte[] byteArray = {48, 49, 50, 51};
        String text = Main.readAsString(new ByteArrayInputStream(byteArray), StandardCharsets.US_ASCII);
        assertEquals(text, "0123");
    }
}
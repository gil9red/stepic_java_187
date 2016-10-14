package stepic.solutions_12781_step_13;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by ipetrash on 14.10.2016.
 */
public class MainTest {
    @Test
    public void test1() throws Exception {
        String text = "Мама мыла-мыла-мыла раму!";
        check(text, "мыла", "мама", "раму");
    }

    @Test
    public void test2() throws Exception {
        String text = "Sample Input 2:\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam,\n" +
                "tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus\n" +
                "imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur\n" +
                "adipiscing elit. Integer vel odio nec mi tempor dignissim.";

        check(text,
                "consectetur",
                "faucibus",
                "ipsum",
                "lorem",
                "adipiscing",
                "amet",
                "dolor",
                "eget",
                "elit",
                "mi"
                );
    }

    void check(String text, String... result) throws Exception {
        ByteArrayInputStream input = new ByteArrayInputStream(text.getBytes());
        System.setIn(input);

        OutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

        Main.main(null);

        assertEquals(
            Arrays.asList(out.toString().split("\n")).stream().map(String::trim).collect(Collectors.toList()),
            Arrays.asList(result));
    }
}
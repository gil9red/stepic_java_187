package my.foo.test;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ipetrash on 20.09.2016.
 */
public class Foo {

    private final static Logger LOGGER = Logger.getLogger(Foo.class.getName());

    public static void main(String[] args) {
//        System.out.println(Time.This(() -> new BigInteger("12345").pow(10000)));

//        Object x = new Integer(0);
//        System.out.println((String)x);

//        try {
//            System.exit(0);
//        } catch (Exception e) {
//
//        } finally {
//            System.out.println("finally!");
//        }

//        foo("1", "2", "3");

//        LOGGER.log(Level.FINE, "dfsdfs {0}", 1);
//
//        LOGGER.log(Level.WARNING, "dfsdfs {0}, {1}, {2}", new Object[] {
//                Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});


//        try {
//            System.out.println(new File(".\\a\\b\\..\\b\\c\\.\\file.txt").getCanonicalPath());
//            System.out.println(new File("a\\.\\b\\..\\c\\.\\file.txt").getCanonicalPath());
//            System.out.println(new File("a\\b\\..\\file.txt").getCanonicalPath());
//            System.out.println(new File("a\\b\\c\\file.txt").getCanonicalPath());
//            System.out.println(new File("a\\..\\b\\c\\file.txt").getCanonicalPath());
//        } catch (IOException e) {
//            System.err.println(e);
//        }
//
//        Path path = Paths.get("");
//        //Paths.newInputStream(path); // not found method
//        try {
//            new FileInputStream(path.toFile());
//        } catch (FileNotFoundException e) {}
//        try {
//            Files.newInputStream(path);
//        } catch (IOException e) {}
//        // new FileInputStream(path); not found constructor

        try {
            Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
            writer.write("1");
            writer.write("〱㈳");
            writer.flush();
        } catch (IOException e) {
            System.err.println("error: " + e);
        }
    }

    static void foo(String... lines) {
        System.out.println(lines.length);
    }
}

class Time {
    static long This(Runnable runnable) {
        long t = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - t;
    }
}

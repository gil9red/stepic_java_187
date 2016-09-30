package my.foo.test;

import java.math.BigInteger;
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

        LOGGER.log(Level.FINE, "dfsdfs {0}", 1);

        LOGGER.log(Level.WARNING, "dfsdfs {0}, {1}, {2}", new Object[] {
                Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});


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

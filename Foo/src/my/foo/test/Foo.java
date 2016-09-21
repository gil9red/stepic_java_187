package my.foo.test;

import java.math.BigInteger;

/**
 * Created by ipetrash on 20.09.2016.
 */
public class Foo {
    public static void main(String[] args) {
        System.out.println(Time.This(() -> new BigInteger("12345").pow(10000)));
    }
}

class Time {
    static long This(Runnable runnable) {
        long t = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - t;
    }
}

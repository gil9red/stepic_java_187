package stepic.solutions_12775_step_12;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ipetrash on 12.10.2016.
 */
public class PairTest {
    @Test
    public void testFirstEqualOne() {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        assertEquals(i, Integer.valueOf(1));
    }

    @Test
    public void testSecondEqualHello() {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        String s = pair.getSecond(); // "hello"
        assertEquals(s, "hello");
    }

    @Test
    public void testPairEqualsPair2() {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        assertTrue(pair.equals(pair2)); // true!
    }

    @Test
    public void testPairEqualsPair2Hash() {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        assertTrue(pair.hashCode() == pair2.hashCode()); // true!
    }


    @Test
    public void test1() {
        Pair<Integer, String> pair1 = Pair.of(null, null);
        assertEquals(pair1, Pair.of(null, null));
    }

    @Test
    public void test2() {
        Pair<Integer, String> pair1 = Pair.of(null, null);
        Pair<String, Integer> pair2 = Pair.of(null, null);
        assertEquals(pair1, pair2);
    }
}
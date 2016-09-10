/**
 * Created by ipetrash on 10.09.2016.
 */

import java.math.BigInteger;

public class Main {

//    Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное.
//    Данная задача актуальна, например, при работе с битовыми полями.
//
//    Договоримся, что биты нумеруются от младшего (индекс 1) к старшему (индекс 32).
//    Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода
//    добавит проверяющая система.
//
//    Sample Input:
//            0 1
//
//    Sample Output:
//            1

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s).replace(' ', '0');
    }

    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        int index = 32 - bitIndex;

        String binaryString = Integer.toBinaryString(value);
        binaryString = padLeft(binaryString, 32);

        char[] binaryStringArr = binaryString.toCharArray();
        binaryStringArr[index] = binaryStringArr[index] == '1' ? '0' : '1';

        return new BigInteger(String.valueOf(binaryStringArr), 2).intValue();
    }

    public static void main(String[] args) {
        int value = 0;
        int bit = 1;

        int result = flipBit(value, bit);
        System.out.println(result);

        value = -1;
        result = flipBit(value, bit);
        System.out.println(result);
    }
}

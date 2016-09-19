package stepic.solutions_12762_step_8;

/**
 * Created by ipetrash on 11.09.2016.
 */

import java.math.BigInteger;

public class Main {
/*
Реализуйте метод, вычисляющий факториал заданного натурального числа.

Факториал N
вычисляется как 1⋅2⋅...⋅N

Поскольку это очень быстро растущая функция, то даже для небольших N вместимости типов int и long очень скоро
не хватит. Поэтому будем использовать BigInteger.
Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит
проверяющая система.

Sample Input 1:
1

Sample Output 1:
1


Sample Input 2:
3

Sample Output 2:
6
 */

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger number = BigInteger.ONE;
        while (value > 1) {
            number = number.multiply(BigInteger.valueOf(value));
            value--;
        }

        return number;
    }

    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(3));
        System.out.println(factorial(6));
        System.out.println(factorial(60));
    }

}

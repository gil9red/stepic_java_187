package stepic.solutions_12781_step_11;

import java.util.stream.IntStream;

/**
 * Created by ipetrash on 30.09.2016.
 */
public class Main {
/*
Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
    Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
    Первый элемент последовательности устанавливается равным этому числу.
    Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn ** 2)

, где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа. Например, mid(123456)=345

Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)

Пример

pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:

13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)

*/

    public static IntStream pseudoRandomStream(int seed) {
        // У корня числа делением убираем цифру справа, а остатком от деления оставшиеся 3 цифры справа
        return IntStream.iterate(seed, (x) -> (x * x) / 10 % 1000);
    }

    public static void main(String[] args) throws Exception {
        IntStream stream = pseudoRandomStream(13);
        stream.limit(15).forEach(value -> System.out.print(value + " "));
        System.out.println();

        stream = pseudoRandomStream(1);
        stream.limit(15).forEach(value -> System.out.print(value + " "));
        System.out.println();

        stream = pseudoRandomStream(0);
        stream.limit(15).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }
}

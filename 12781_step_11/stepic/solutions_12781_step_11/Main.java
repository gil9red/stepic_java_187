package stepic.solutions_12781_step_11;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
        IntStream stream = IntStream.iterate(seed, (x) -> {
            if (x == 0) {
                return 0;
            }

            x = x * x;

            // TODO: Число в строку, строку в список, список развернуть, и из списка взять 3 элемента, пропуская первый
            // после конкатенация в число и получение числа
            List<String> nums = new ArrayList<>();
            while (x > 0) {
                nums.add(String.valueOf(x % 10));
                x /= 10;
            }

            nums = nums.stream().skip(1).limit(3).collect(Collectors.toList());
            Collections.reverse(nums);

            StringBuilder builder = new StringBuilder();
            if (nums.isEmpty()) {
                nums.add("0");
            }
            nums.stream().forEach(builder::append);

            return Integer.valueOf(builder.toString());
        });
        return stream;
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

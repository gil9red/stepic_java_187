package stepic.solutions_12781_step_12;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ipetrash on 30.09.2016.
 */
public class Main {
/*
Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.

Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
minMaxConsumer.accept(min, max);

Если стрим не содержит элементов, то вызовите
minMaxConsumer.accept(null, null);

*/

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void main(String[] args) throws Exception {
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13, 21)).stream();

        findMinMax(
            stream,
            (x, y) -> x.compareTo(y),
            (x, y) -> System.out.println(String.format("min: %s, max: %s", x, y))
        );

        stream.close();
    }
}

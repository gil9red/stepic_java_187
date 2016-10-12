package stepic.solutions_12775_step_12;


/**
 * Created by ipetrash on 30.09.2016.
 */
public class Main {
/*
Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий
элементам принимать значение null.

Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of().
Конструктор должен быть закрытым (private).

С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:

Pair<Integer, String> pair = Pair.of(1, "hello");
Integer i = pair.getFirst(); // 1
String s = pair.getSecond(); // "hello"

Pair<Integer, String> pair2 = Pair.of(1, "hello");
boolean mustBeTrue = pair.equals(pair2); // true!
boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!


Пожалуйста, не меняйте модификатор доступа класса Pair. Для корректной проверки класс должен иметь пакетную видимость.

*/

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

        System.out.println(i);
        System.out.println(s);
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);

        Pair<Integer, String> pair1 = Pair.of(null, null);
        System.out.println(pair1.equals(Pair.of(null, null)));
    }
}

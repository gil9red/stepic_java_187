package stepic.solutions_12781_step_13;

import java.util.*;

/**
 * Created by ipetrash on 30.09.2016.
 */
public class Main {
/*
Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и
в конце выводящую 10 наиболее часто встречающихся слов.
Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в
строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
Выводите слова в нижнем регистре.
Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.

Sample Input 1:
Мама мыла-мыла-мыла раму!

Sample Output 1:
мыла
мама
раму

Sample Input 2:
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam,
tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus
imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur
adipiscing elit. Integer vel odio nec mi tempor dignissim.

Sample Output 2:
consectetur
faucibus
ipsum
lorem
adipiscing
amet
dolor
eget
elit
mi

*/


    public static void main(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());

            // nextLine съедает символ перехода на следующую строку, и получается
            // что последнее слово линии и первое слово следующей строки будут слитными
            builder.append(" ");
        }

        // Замена не буквенных символов на пробелы
        String text = builder.toString().replaceAll("[^a-zA-Zа-яА-Я0-9]", " ");

        // Словарь для подсчета количества слов
        Map<String, Integer> wordsByNumber = new HashMap<>();
        scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            if (wordsByNumber.containsKey(word)) {
                wordsByNumber.put(word, wordsByNumber.get(word) + 1);
            } else {
                wordsByNumber.put(word, 1);
            }
        }

        // Словарь, у которого ключом является количество слов, а значением список этих слов
        Map<Integer, List<String>> numberByWords = new HashMap<>();
        for (Map.Entry<String, Integer> entry : wordsByNumber.entrySet()) {
            String word = entry.getKey();
            Integer number = entry.getValue();

            if (!numberByWords.containsKey(number)) {
                numberByWords.put(number, new ArrayList<>());
            }

            numberByWords.get(number).add(word);
        }

        List<String> allWords = new ArrayList<>();

        // Заполняем список слов
        numberByWords.keySet().stream()
                // Сортировка от большего к меньшему
                .sorted((o1, o2) -> o2.compareTo(o1))
                .forEach(key -> {
                    List<String> words = numberByWords.get(key);
                    words.stream().sorted().forEach(value -> {
                        // Ограничение размера
                        if (allWords.size() >= 10) {
                            return;
                        }
                        allWords.add(value);
                    });
                });

        allWords.stream().forEach(System.out::println);
    }
}


// Эталонное решение от преподавателя.
/*
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // Для чтения входного потока используем Scanner.
        // Поскольку словами мы считаем последовательности символов,
        // состоящие из букв или цифр, то в качестве разделителя слов Scanner'у
        // указываем регулярное выражение, означающее
        // "один или более символ, не являющийся ни буквой, ни цифрой".
        Scanner scanner = new Scanner(System.in, "UTF-8")
                .useDelimiter("[^\\p{L}\\p{Digit}]+");

        // Пройдем по всем словам входного потока и составим Map<String, Integer>,
        // где ключом является слово, преобразованное в нижний регистр,
        // а значением - частота этого слова.
        Map<String, Integer> freqMap = new HashMap<>();
        scanner.forEachRemaining(s -> freqMap.merge(s.toLowerCase(), 1, (a, b) -> a + b));

        freqMap.entrySet().stream()                 // получим стрим пар (слово, частота)
                .sorted(descendingFrequencyOrder()) // отсортируем
                .limit(10)                          // возьмем первые 10
                .map(Map.Entry::getKey)             // из каждой пары возьмем слово
                .forEach(System.out::println);      // выведем в консоль
    }

    // Создание Comparator'а вынесено в отдельный метод, чтобы не загромождать метод main.
    private static Comparator<Map.Entry<String, Integer>> descendingFrequencyOrder() {
        // Нам нужен Comparator, который сначала упорядочивает пары частоте (по убыванию),
        // а затем по слову (в алфавитном порядке). Так и напишем:
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }
}
*/

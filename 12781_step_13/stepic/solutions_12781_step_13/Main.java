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
        String text = builder.toString().replaceAll("[^a-zA-Zа-яА-Я]", " ");
//        System.out.println(text);
//        System.out.println(builder.toString().replaceAll("\\W", " "));

        // Словарь для подсчета количества слов
        Map<String, Integer> wordsByNumber = new HashMap<>();
        scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
//            System.out.println(word);

            if (wordsByNumber.containsKey(word)) {
                wordsByNumber.put(word, wordsByNumber.get(word) + 1);
            } else {
                wordsByNumber.put(word, 1);
            }
        }

//        System.out.println(wordsByNumber);
//        System.out.println(wordsByNumber.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList()));

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
//        System.out.println(numberByWords);

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

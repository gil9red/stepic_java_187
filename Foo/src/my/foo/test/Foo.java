package my.foo.test;

import java.io.*;
import java.math.BigInteger;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ipetrash on 20.09.2016.
 */
public class Foo {

    private final static Logger LOGGER = Logger.getLogger(Foo.class.getName());

    public static void main(String[] args) {
//        System.out.println(Time.This(() -> new BigInteger("12345").pow(10000)));

//        Object x = new Integer(0);
//        System.out.println((String)x);

//        try {
//            System.exit(0);
//        } catch (Exception e) {
//
//        } finally {
//            System.out.println("finally!");
//        }

//        foo("1", "2", "3");

//        LOGGER.log(Level.FINE, "dfsdfs {0}", 1);
//
//        LOGGER.log(Level.WARNING, "dfsdfs {0}, {1}, {2}", new Object[] {
//                Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});


//        try {
//            System.out.println(new File(".\\a\\b\\..\\b\\c\\.\\file.txt").getCanonicalPath());
//            System.out.println(new File("a\\.\\b\\..\\c\\.\\file.txt").getCanonicalPath());
//            System.out.println(new File("a\\b\\..\\file.txt").getCanonicalPath());
//            System.out.println(new File("a\\b\\c\\file.txt").getCanonicalPath());
//            System.out.println(new File("a\\..\\b\\c\\file.txt").getCanonicalPath());
//        } catch (IOException e) {
//            System.err.println(e);
//        }
//
//        Path path = Paths.get("");
//        //Paths.newInputStream(path); // not found method
//        try {
//            new FileInputStream(path.toFile());
//        } catch (FileNotFoundException e) {}
//        try {
//            Files.newInputStream(path);
//        } catch (IOException e) {}
//        // new FileInputStream(path); not found constructor

//        try {
//            Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
//            writer.write("1");
//            writer.write("〱㈳");
//            writer.flush();
//        } catch (IOException e) {
//            System.err.println("error: " + e);
//        }

//        byte[] byteArray = StandardCharsets.UTF_8.encode("Ы").array();
//        for (byte b : byteArray) {
//            System.out.println(b + " " + Byte.toUnsignedInt(b));
//        }

//        System.out.println(new Date(2016, 2, 2).toString());

//        List< Map<String, Object> > listOfEvents = new ArrayList<>();
//        listOfEvents.add(createEvents("1", "Нах все", "11/10/2016", "15:30"));
//        listOfEvents.add(createEvents("2", "Стриптиз", "11/10/2016", "16:30"));
//        listOfEvents.add(createEvents("3", "Уборка территории", "08/10/2016", "10:30"));
//        listOfEvents.add(createEvents("4", "Поклон ректору", "19/10/2016", "16:30"));
//        listOfEvents.add(createEvents("5", "Поклон ректору", "19/10/2016", "18:30"));
//        listOfEvents.add(createEvents("6", "Поклон ректору", "19/10/2016", "10:30"));
//
//        for (Map<String, Object> event : listOfEvents) {
//            System.out.println(String.format("%s %s \"%s\"", event.get("Date"), event.get("Time"), event.get("Name")));
//        }
//        System.out.println();
//
//        // Лямбда для сортировки словарей
//        listOfEvents.sort((event1, event2) -> {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
//
//            try {
//                // Получение даты/времени событий
//                Date eventDateTime1 = sdf.parse(event1.get("Date") + " " + event1.get("Time"));
//                Date eventDateTime2 = sdf.parse(event2.get("Date") + " " + event1.get("Time"));
//
//                // Сравнение
//                return eventDateTime1.compareTo(eventDateTime2);
//
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        // Теперь список отсортирован
//        for (Map<String, Object> event : listOfEvents) {
//            System.out.println(String.format("%s %s \"%s\"", event.get("Date"), event.get("Time"), event.get("Name")));
//        }

//        Collection<?> collection = new ArrayList();
//        Object object = new Object();
//
//        collection.iterator();
//        collection.add(object);
//        collection.toArray();
//        collection.size();
//        collection.contains(object);
//        collection.remove(object);
//        collection.clear();
//        collection.addAll(Arrays.asList(object));

        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("1");
        l.add("1");
        l.add("1");
        l.add("1");
        l.add("1");
        l.add("1");

        Stream<String> stream = l.stream();

//        stream.sorted();
//        stream.forEach();
//        stream.count();
//        stream.collect();
//        stream.flatMap();
//        stream.limit();
//        stream.toArray();
//        stream.peek();
//        stream.map();
//        stream.filter();

//        System.out.println(l.stream().reduce(, String::a));
//        System.out.println(l.stream().limit(2).collect(Collectors.toList()));
    }

    static Map<String, Object> createEvents(String id, String name, String date, String time) {
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("Id", id); // id мероприятия
        hm.put("Name", name); // название мероприятия
        hm.put("Date", date); // Дата провидения мероприятия
        hm.put("Time", time); // время провидения мероприятия

        return hm;
    }

    static void foo(String... lines) {
        System.out.println(lines.length);
    }
}

class Time {
    static long This(Runnable runnable) {
        long t = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - t;
    }
}

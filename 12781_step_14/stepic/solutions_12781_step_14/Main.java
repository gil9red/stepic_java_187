package stepic.solutions_12781_step_14;


import java.util.*;
import java.util.function.*;

/**
 * Created by ipetrash on 30.09.2016.
 */
public class Main {
/*
// Random variables
String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

// Создание списка из трех почтовых сообщений.
MailMessage firstMessage = new MailMessage(
        "Robert Howard",
        "H.P. Lovecraft",
        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
);

assert firstMessage.getFrom().equals("Robert Howard"): "Wrong firstMessage from address";
assert firstMessage.getTo().equals("H.P. Lovecraft"): "Wrong firstMessage to address";
assert firstMessage.getContent().endsWith("Howard!"): "Wrong firstMessage content ending";

MailMessage secondMessage = new MailMessage(
        "Jonathan Nolan",
        "Christopher Nolan",
        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
);

MailMessage thirdMessage = new MailMessage(
        "Stephen Hawking",
        "Christopher Nolan",
        "Я так и не понял Интерстеллар."
);

List<MailMessage> messages = Arrays.asList(
        firstMessage, secondMessage, thirdMessage
);

// Создание почтового сервиса.
MailService<String> mailService = new MailService<>();

// Обработка списка писем почтовым сервисом
messages.stream().forEachOrdered(mailService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список сообщений, которые были ему отправлены
Map<String, List<String>> mailBox = mailService.getMailBox();

assert mailBox.get("H.P. Lovecraft").equals(
        Arrays.asList(
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        )
): "wrong mailService mailbox content (1)";

assert mailBox.get("Christopher Nolan").equals(
        Arrays.asList(
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                "Я так и не понял Интерстеллар."
        )
): "wrong mailService mailbox content (2)";

assert mailBox.get(randomTo).equals(Collections.<String>emptyList()): "wrong mailService mailbox content (3)";


// Создание списка из трех зарплат.
Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

// Создание почтового сервиса, обрабатывающего зарплаты.
MailService<Integer> salaryService = new MailService<>();

// Обработка списка зарплат почтовым сервисом
Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список зарплат, которые были ему отправлены.
Map<String, List<Integer>> salaries = salaryService.getMailBox();
assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)): "wrong salaries mailbox content (1)";
assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)): "wrong salaries mailbox content (2)";
assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)): "wrong salaries mailbox content (3)";

В конечном итоге, вам нужно реализовать классы MailService, MailMessage и Salary (и, вероятно, вспомогательные классы
и интерфейсы) и отправить их код в форму. Все классы должны быть публичными и статическими (ваши классы подставятся во
внешний класс для тестирования).

В идеологически правильном решении не должно фигурировать ни одного оператора instanceof.

В классе для тестирования объявлены следующие импорты:
import java.util.*;
import java.util.function.*;

*/

    // TODO: MailMessage и Salary можно объединить одним интерфейсом/базовым классом
    public static class MailMessage {
        private String from;
        private String to;
        private String content;

        public MailMessage(String from, String to, String content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public String getContent() {
            return content;
        }
    }

    public static class Salary {
        private String from;
        private String to;
        private Integer value;

        public Salary(String from, String to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public Integer getValue() {
            return value;
        }
    }

    public static class MailService <T> implements Consumer {

        // Единственное отличие, что для несуществующего элемента возвращает пустой список
        // Используется для прохождения проверки: mailBox.get(randomTo).equals(Collections.<String>emptyList())
        static private class MyHashMap <T> extends HashMap {
            @Override
            public Object get(Object key) {
                if (!containsKey(key)) {
                    return Collections.<T>emptyList();
                }

                return super.get(key);
            }
        }

//        private Map<String, List<T>> mailBox = new HashMap<>();
        // TODO: Выглядит костыльно
        private Map<String, List<T>> mailBox = new MyHashMap<>();

        @Override
        public void accept(Object o) {
            // TODO: выглядит некрасиво
            if (o instanceof MailMessage) {
                MailMessage mailMessage = (MailMessage) o;
                System.out.println(mailMessage.getFrom() + " -> " + mailMessage.getTo() + " : " + mailMessage.getContent());

                String to = mailMessage.getTo();
                if (!mailBox.containsKey(to)) {
                    mailBox.put(to, new ArrayList<>());
                }
                mailBox.get(to).add((T) mailMessage.getContent());

            } else if (o instanceof Salary) {
                Salary salary = (Salary) o;
                System.out.println(salary.getFrom() + " -> " + salary.getTo() + " : " + salary.getValue());

                String to = salary.getTo();
                if (!mailBox.containsKey(to)) {
                    mailBox.put(to, new ArrayList<>());
                }
                mailBox.get(to).add((T) salary.getValue());
            }
        }

        // Получение и проверка словаря "почтового ящика",
        // где по получателю можно получить список сообщений, которые были ему отправлены
        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }
    }


    public static void main(String[] args) throws Exception {
        // Random variables
        String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

        // Создание списка из трех почтовых сообщений.

        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard"): "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft"): "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!"): "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

        // Создание почтового сервиса.
        MailService<String> mailService = new MailService<>();

        // Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);

        // Получение и проверка словаря "почтового ящика",
        // где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                Arrays.asList(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ): "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ): "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()): "wrong mailService mailbox content (3)";


        // Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

        // Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

        // Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

        // Получение и проверка словаря "почтового ящика",
        // где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)): "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)): "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)): "wrong salaries mailbox content (3)";
    }
}


// Эталонное решение от преподавателя.
/*
// MailMessage и Salary имеют практически идентичный интерфейс
// за исключением типа поля content. Давайте абстрагируем это знание в интерфейс.
public static interface Sendable<T> {
    String getFrom();
    String getTo();
    T getContent();
}


// Абстрагируем логику хранения всех элементов класса во внутренних полях класса,
// создав класс SimpleSendable. Не забудем указать реализуемый интерфейс.
public static class SimpleSendable<T> implements Sendable<T> {
    private String from, to;
    private T content;

    public SimpleSendable(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public T getContent() {
        return content;
    }
}


// Теперь объявим MailMessage и Salary, отнаследовавшись от SimpleSendable
// с конкретным параметром типа.
public static class MailMessage extends SimpleSendable<String> {
    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}


public static class Salary extends SimpleSendable<Integer> {
    public Salary(String from, String to, Integer content) {
        super(from, to, content);
    }
}


// forEachOrdered и forEach ожидают в качестве аргумента класс,
// реализующий интерфейс Consumer.
// Судя по исходному коду, Consumer потребляет письма с содержимым,
// соответствующим параметру класса MailService.
public static class MailService<T> implements Consumer<Sendable<T>> {

    // Если внимательно посмотреть на исходный код задания, можно заметить,
    // что логика метода get у получаемого в getMailBox Map'а при отсутствующем элементе
    // отличается от логики стандартных коллекций. Переназначим эту логику в анонимном
    // наследнике HashMap.
    private Map<String, List<T>> messagesMap = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key) {
            if (this.containsKey(key)) {
                // Возвращать изменяемый список во внешний мир – не очень хорошая идея
                // по причине того, что его изменение может испортить внутреннее состояние
                // словаря. Лучше оборачивать подобный вывод в
                //  Collections.unmodifiableList.
                // Однако здесь мы не можем так поступить по причине того,
                // что добавлять новые элементы в списки из accept будет неудобно.
                // Нужно реализовать дополнительный метод getMutable, который возвращал
                // бы изменяемый список, удобный для модификации.
                // Но добавить новый метод мы можем только в именованный класс.
                return super.get(key);
            } else {
                // Collections.emptyList() возвращает один и тот же экземпляр
                // неизменяемого списка. Если бы мы возвращали здесь, допустим,
                // new ArrayList<>(), то множество вызовов get по отсутвующему
                // элементу создавало бы множество лишних объектов.
                return Collections.emptyList();
            }
        }
    };

    @Override
    public void accept(Sendable<T> sendable) {
        List<T> ts = messagesMap.get(sendable.getTo());
        if (ts.size() == 0) {
            ts = new ArrayList<>();
        }
        ts.add(sendable.getContent());
        messagesMap.put(sendable.getTo(), ts);
    }

    public Map<String, List<T>> getMailBox() {
        return messagesMap;
    }
}

*/

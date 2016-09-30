package stepic.solutions_12774_step_8;

import java.util.logging.*;

/**
 * Created by ipetrash on 30.09.2016.
 */
public class Main {

/*
В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет
выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

Требуется выставить такие настройки, чтобы:
    * Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
    * Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
    * Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности
      сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях
      "org.stepic", "org" и "".

Не упомянутые здесь настройки изменяться не должны.

(*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл. Но проверяющая система не разрешает
создавать файлы на диске, поэтому придется так.

Подсказки:
    * Level есть не только у Logger, но и у Handler.
    * Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.
*/

    private static void configureLogging() {
        // "Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней."
        Logger logger_ClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
        logger_ClassA.setLevel(Level.ALL);
        for (Handler handler : logger_ClassA.getHandlers()) {
            handler.setLevel(Level.ALL);
        }

        // "Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее."
        Logger logger_ClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
        logger_ClassB.setLevel(Level.WARNING);
        for (Handler handler : logger_ClassB.getHandlers()) {
            handler.setLevel(Level.WARNING);
        }

        // "Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности
        // сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях
        // "org.stepic", "org" и ""."
        Logger logger = Logger.getLogger("org.stepic.java");
        logger.addHandler(new ConsoleHandler());

        // Запрет передачи обработчикам выше уровня
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        for (Handler handler : logger.getHandlers()) {
            handler.setLevel(Level.ALL);
            handler.setFormatter(new XMLFormatter());
        }
    }

    /*
    // NOTE: прошло:
private static void configureLogging() {
    Logger logger_ClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
    logger_ClassA.setLevel(Level.ALL);

    Logger logger_ClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
    logger_ClassB.setLevel(Level.WARNING);

    Logger logger = Logger.getLogger("org.stepic.java");
    logger.setLevel(Level.ALL);
    // Запрет передачи обработчикам выше уровня
    logger.setUseParentHandlers(false);

    Handler handler = new ConsoleHandler();
    handler.setLevel(Level.ALL);
    handler.setFormatter(new XMLFormatter());

    logger.addHandler(handler);
}

    */

    public static void main(String[] args) {

    }
}

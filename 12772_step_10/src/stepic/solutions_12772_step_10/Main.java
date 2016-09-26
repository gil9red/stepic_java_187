package stepic.solutions_12772_step_10;

/**
 * Created by ipetrash on 11.09.2016.
 */


public class Main {

/*
Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный
утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName()
является точкой входа в программу, т.е. его никто не вызывал.
Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод,
откуда сообщение было залогировано.

Пример
package org.stepic.java.example;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        // ...
    }
}

При запуске эта программа должна вывести:
null
org.stepic.java.example.Test#main

P.S. При тестировании этой программы в среде разработки вы можете получить другой результат: вместо null в
первой строчке будет напечатан какой-то посторонний класс и метод. Это связано с тем, что среда разработки
обычно запускает не ваш класс, а свой собственный, который затем уже вызывает ваш. Чтобы этого избежать,
запускайте программу командой "java" в командной строке.
P.P.S. Эта задача в уроке про исключения не случайно :)
*/

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElementList = new Throwable().getStackTrace();
        if (stackTraceElementList.length == 2) {
            return null;
        }

        // 0 -- текущая функция
        // 1 -- функция в которой была вызвана текущая
        // 2 -- функция которая была вызвана текущей из предыдущей
        StackTraceElement element = stackTraceElementList[2];
        return String.format("%s#%s", element.getClassName(), element.getMethodName());
    }


    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();

        fooAnotherMethod();

        // При запуске эта программа должна вывести:
        // null
        // org.stepic.java.example.Test#main
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    private static void fooAnotherMethod() {
        anotherMethod();
    }
}


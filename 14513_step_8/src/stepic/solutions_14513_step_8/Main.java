package stepic.solutions_14513_step_8;

/**
 * Created by ipetrash on 11.09.2016.
 */


public class Main {

/*
Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают
в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет
занимать в два раза меньше памяти.

Класс AsciiCharSequence должен:
    * реализовывать интерфейс java.lang.CharSequence;
    * иметь конструктор, принимающий массив байт;
    * определять методы length(), charAt(), subSequence() и toString()

Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или
исходники).

В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их
проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.

P.S. В Java 9 ожидается подобная оптимизация в самом классе String: http://openjdk.java.net/jeps/254

*/

    public static void main(String[] args) {
        // Hello World!
        byte[] bytes = new byte[] { 0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x20, 0x57, 0x6f, 0x72, 0x6c, 0x64, 0x21 };
        AsciiCharSequence ascii = new AsciiCharSequence(bytes);
        String strAscii = ascii.toString();

        System.out.println(ascii + " -- " + strAscii);
        System.out.println(ascii.subSequence(0, 4).toString().equals(strAscii.subSequence(0, 4)));
        System.out.println(ascii.subSequence(4, 4).toString().equals(strAscii.subSequence(4, 4)));
        System.out.println(ascii.subSequence(3, 4).toString().equals(strAscii.subSequence(3, 4)));
    }
}

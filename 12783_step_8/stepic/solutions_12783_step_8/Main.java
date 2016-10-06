package stepic.solutions_12783_step_8;


import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ipetrash on 30.09.2016.
 */
public class Main {

/*
Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.

Контрольная сумма данных вычисляется по следующему алгоритму:

    Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
    Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:
    $C_{n+1}=\mathrm{rotateLeft}(C_n)\ \mathrm{xor}\ b_{n+1}$ , где $C_n$ — контрольная сумма первых n байт данных,
    rotateLeft — циклический сдвиг бит числа на один бит влево (чтобы не изобретать велосипед, используйте
    Integer.rotateLeft), $b_n$ — n-ный байт данных.

    // C(n+1) = rotateLeft(Cn) ^ b (n+1))

Поскольку метод не открывал данный InputStream, то и закрывать его он не должен. Выброшенное из методов
InputStream исключение должно выбрасываться из метода.

Пример
На вход подан InputStream, последовательно возвращающий три байта: 0x33 0x45 0x01. В качестве контрольной суммы
должно быть возвращено число 71.
*/

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int checksum = 0;

        int read = inputStream.read();
        while (read != -1) {
            checksum = Integer.rotateLeft(checksum, 1) ^ read;

            read = inputStream.read();
        }

        return checksum;
    }

    public static void main(String[] args) {
        ByteInputStream inputStream = new ByteInputStream();
        inputStream.setBuf(new byte[] { 0x33, 0x45, 0x01 } );

        try {
            System.out.println(checkSumOfStream(inputStream));
        } catch (Throwable e) {
            System.err.println("error: " + e);
        }
    }
}

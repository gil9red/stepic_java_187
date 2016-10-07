package stepic.solutions_12784_step_12;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by ipetrash on 30.09.2016.
 */
public class Main {

/*
Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

Пример
InputStream последовательно возвращает четыре байта: 48 49 50 51.
Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".

*/

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // Get byte array from inputStream
        java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
        int next = inputStream.read();
        while (next > -1) {
            bos.write(next);
            next = inputStream.read();
        }
        bos.flush();
        byte[] result = bos.toByteArray();

//        // Get byte array from inputStream
//        byte[] result = sun.misc.IOUtils.readFully(inputStream, -1, true);

        // Decode byte to char from charset (encoding)
        java.nio.ByteBuffer bb = java.nio.ByteBuffer.wrap(result);
        return charset.decode(bb).toString();
    }

    public static void main(String[] args) {
        byte[] byteArray = {48, 49, 50, 51};

        try {
            System.out.println(readAsString(new ByteArrayInputStream(byteArray), StandardCharsets.UTF_8));
            System.out.println(readAsString(new ByteArrayInputStream(byteArray), StandardCharsets.UTF_16));
            System.out.println(readAsString(new ByteArrayInputStream(byteArray), StandardCharsets.US_ASCII));

        } catch (IOException e) {
            System.err.println("error: " + e);
        }
    }
}

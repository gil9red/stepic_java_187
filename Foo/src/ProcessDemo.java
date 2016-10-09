
/*
Запуск внешней программы, получение и вывод ее вывода.
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by ipetrash on 09.10.2016.
 */
public class ProcessDemo {
    static void run_tasklist() throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("tasklist")
                .redirectOutput(ProcessBuilder.Redirect.PIPE);

        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            reader.lines().forEach(System.out::println);
        }

        int code = process.waitFor();
        if (code != 0) {
            System.err.println("Subprocess terminated abnormally.");
        }
    }

    static void run_dir() throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd", "/C", "dir")
                .directory(new File("C:\\"))
                .redirectOutput(ProcessBuilder.Redirect.PIPE);

        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            reader.lines().forEach(System.out::println);
        }

        int code = process.waitFor();
        if (code != 0) {
            System.err.println("Subprocess terminated abnormally.");
        }
    }

    public static void main(String[] args) throws Exception {
        // run_tasklist();
        run_dir();
    }
}

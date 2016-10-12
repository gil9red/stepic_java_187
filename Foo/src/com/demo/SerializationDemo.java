package com.demo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

/**
 * Created by ipetrash on 09.10.2016.
 */
public class SerializationDemo {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.setId(1);
        client.setName("Vasya");
        client.setBirthDate(LocalDate.of(1990, 1, 12));
        System.out.println(client);

        Path path = Paths.get("object.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(client);
        }

        Client deserializableClient;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            deserializableClient = (Client) ois.readObject();
        }
        System.out.println(deserializableClient);
    }
}

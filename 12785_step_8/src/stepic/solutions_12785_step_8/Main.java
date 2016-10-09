package stepic.solutions_12785_step_8;

import java.io.*;
import java.util.Arrays;

/**
 * Created by ipetrash on 09.10.2016.
 */
public class Main {
/*
Дан сериализуемый класс Animal:
    class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal. Массив байт устроен
следующим образом. Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size). Далее
подряд записано указанное количество объектов типа Animal, сериализованных при помощи
ObjectOutputStream.writeObject(animal).

Если вдруг массив байт не является корректным представлением массива экземпляров Animal, то метод должен бросить
исключение java.lang.IllegalArgumentException.

Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные и посмотрите,
какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и выбросить. Если что-то
забудете, то проверяющая система подскажет. Главное не глотать никаких исключений, т.е. не оставлять нигде пустой
catch.
*/

    public static byte[] serializeAnimalArray(Animal[] animals) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            // Сначала указывается количество животных
            oos.writeInt(animals.length);

            // Потом серивлизуются объекты животных
            for (Animal animal : animals) {
                oos.writeObject(animal);
            }
        }

        return baos.toByteArray();
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int length = ois.readInt();

            Animal[] animals = new Animal[length];
            for (int i = 0; i < length; i++) {
                animals[i] = (Animal) ois.readObject();
            }

            return animals;

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Animal[] animals = {
            new Animal("dog"),
            new Animal("cat"),
            new Animal("hotdog"),
            new Animal("shaurmyau"),
        };
        byte[] byteArrayAnimals = serializeAnimalArray(animals);

        // Десериализация и сравнение массивов
        Animal[] animalsDeserializable = deserializeAnimalArray(byteArrayAnimals);
        System.out.println(Arrays.equals(animals, animalsDeserializable));
    }
}

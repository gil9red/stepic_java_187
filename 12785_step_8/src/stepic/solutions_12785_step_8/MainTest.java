package stepic.solutions_12785_step_8;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ipetrash on 09.10.2016.
 */
public class MainTest {
    @Test
    public void test1() throws Exception {
        Animal[] animals = {
            new Animal("dog"),
            new Animal("cat"),
            new Animal("hotdog"),
            new Animal("shaurmyau"),
        };
        byte[] byteArrayAnimals = Main.serializeAnimalArray(animals);

        // Десериализация и сравнение массивов
        Animal[] animalsDeserializable = Main.deserializeAnimalArray(byteArrayAnimals);
        assertArrayEquals(animals, animalsDeserializable);
    }

    @Test
    public void test2() throws Exception {
        Animal[] animals = {
            new Animal("dog"),
            new Animal("cat"),
            new Animal("hotdog"),
            new Animal("shaurmyau"),
        };
        byte[] byteArrayAnimals = Main.serializeAnimalArray(animals);

        // Сломаю структуру, чтобы вызывать ошибку десериализации
        byteArrayAnimals[0] = 0;
        byteArrayAnimals[1] = 0;
        byteArrayAnimals[2] = 0;

        try {
            Main.deserializeAnimalArray(byteArrayAnimals);
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void test3() {
        byte[] byteArrayAnimals = null;

        try {
            Main.deserializeAnimalArray(byteArrayAnimals);
        } catch (IllegalArgumentException e) {

        }
    }
}
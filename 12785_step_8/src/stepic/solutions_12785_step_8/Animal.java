package stepic.solutions_12785_step_8;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by ipetrash on 09.10.2016.
 */
public class Animal implements Serializable {
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

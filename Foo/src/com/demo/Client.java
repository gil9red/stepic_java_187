package com.demo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by ipetrash on 09.10.2016.
 */
public class Client implements Serializable {
    private long id;
    private String name;

    private LocalDate birthDate;

    // transient говорит jvm, что не нужно сериализовывать это поле
    private transient int ageInYears;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public int getAgeInYears() {
        // If not init
        if (ageInYears == 0) {
            ageInYears = birthDate.until(LocalDate.now()).getYears();
        }

        return ageInYears;
    }

    @Override
    public String toString() {
        return String.format("<Client #%s, '%s', %s>", id, name, birthDate);
    }
}

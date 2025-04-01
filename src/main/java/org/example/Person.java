package org.example;

import java.util.*;
import java.util.ArrayList;

public class Person {
    private final String id;
    private final String name;
    private final List<Fine> fines;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
        this.fines = new ArrayList<>();
    }

    public String getId() {
        return name;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void addFine(Fine fine) {
        fines.add(fine);
    }

    public void removeFine(Fine fine) {
        fines.remove(fine);
    }

    @Override
    public String toString() {
        return  "ID: " + id + ", Имя: " + name + ", Штрафы: " + fines;
    }
}

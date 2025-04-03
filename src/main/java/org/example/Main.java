package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        System.out.println("\n Задание 1 \n");

        BoatStopSimulation simulation = new BoatStopSimulation();
        simulation.runSimulation();

        // Задание 2
        System.out.println("\n Задание 2");

        DictionaryApp app = new DictionaryApp();
        app.addWord("hello", Arrays.asList("hola", "bonjour"));
        app.addWord("world", Arrays.asList("undo", "monde"));
        app.run();

        // Задание 3
        System.out.println("\n Задание 3");

        TaxDatabase db = new TaxDatabase();
        db.addPerson("12345", "Иван Иванов");
        db.addFine("12345", new Fine("Парковка", 500, "Москва"));
        db.addFine("12345", new Fine("Превышение скорости", 1500, "Москва"));

        db.addPerson("67890", "Мария Петрова");
        db.addFine("67890", new Fine("Проезд на красный", 2500, "Санкт-Петербург"));

        db.run();
    }
}
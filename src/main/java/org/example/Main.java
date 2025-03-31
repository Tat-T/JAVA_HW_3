package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BoatStopSimulation simulation = new BoatStopSimulation();
        simulation.runSimulation();

        // Задание 2

        DictionaryApp app = new DictionaryApp();
        app.addWord("hello", Arrays.asList("hola", "bonjour"));
        app.addWord("world", Arrays.asList("undo", "monde"));
        app.run();

    }
}
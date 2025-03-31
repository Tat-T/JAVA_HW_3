package org.example;
import java.util.*;

public class BoatStopSimulation {
private static final int SIMULATION_HOURS = 24;
public static final int MAX_CAPACITY = 10; //вместимость катера
public static final int MAX_WAIT_TIME = 30; // Макс. время ожидания человека на остановке (в минутах)

    public final Queue<Integer> passengersQueue = new LinkedList<>();
    public final List<Integer> boatArrivals = new ArrayList<>();
    private final Random random = new Random();

    public void runSimulation() {
        int totalPassengers = 0;
        int totalWaitTime = 0;
        int passengersLeft = 0; // Счетчик ушедших пассажиров

        for (int hour = 0; hour < SIMULATION_HOURS; hour++) {
            int currentTime = hour * 60 + random.nextInt(60);

            // Удаляем пассажиров, которые ждали слишком долго
            while (!passengersQueue.isEmpty() && (currentTime - passengersQueue.peek() > MAX_WAIT_TIME)) {
                passengersQueue.poll();
                passengersLeft++;
            }

            // Добавляем новых пассажиров
            int newPassengers = random.nextInt(5) + 1; // 1-5 пассажиров
            for (int i = 0; i < newPassengers; i++) {
                passengersQueue.add(currentTime);
            }

            // Симуляция прибытия катера
            if (random.nextBoolean()) { // Катер прибывает случайным образом
                boatArrivals.add(currentTime);

                int passengersBoarded = Math.min(passengersQueue.size(), MAX_CAPACITY);
                for (int i = 0; i < passengersBoarded; i++) {
                    Integer arrivalTime = passengersQueue.poll();
                    if (arrivalTime != null) {
                        totalWaitTime += currentTime - arrivalTime;
                        totalPassengers++;
                    }
                }
            }
        }

        double avgWaitTime = (totalPassengers == 0) ? 0 : (double) totalWaitTime / totalPassengers;
        System.out.println("Среднее время пребывания пассажира: " + avgWaitTime + " мин.");
        System.out.println("Всего перевезено пассажиров: " + totalPassengers);
        System.out.println("Пассажиров ушло из-за долгого ожидания: " + passengersLeft);
    }
}

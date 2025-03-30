import java.util.*;

public class BoatStopSimulation {
private static final int SIMULATION_HOURS = 24;
private static final int MAX_CAPACITY = 10; //вместимость катера
private static final int MAX_WAIT_TIME = 30; // Макс. время ожидания человека на остановке (в минутах)

    private Queue<Integer> passengersQueue = new LinkedList<>();
    private List<Integer> boatArrivals = new ArrayList<>();
    private Random random = new Random();

    public void runSimulation() {
        int totalPassengers = 0;
        int totalWaitTime = 0;

        for (int hour = 0; hour < SIMULATION_HOURS; hour++) {
            int newPassengers = random.nextInt(5) + 1; // Случайное число пассажиров
            for (int i = 0; i < newPassengers; i++) {
                passengersQueue.add(hour * 60 + random.nextInt(60));// Записываем время прихода
            }

            // Симуляция прибытия катера
            if (random.nextBoolean()) {
                // Катер прибывает случайным образом
                boatArrivals.add(hour * 60 + random.nextInt(60));

                int passengersBoarded = Math.min(passengersQueue.size(), MAX_CAPACITY);
                for (int i = 0; i < passengersBoarded; i++) {
                    int arrivalTime = passengersQueue.poll();
                    totalWaitTime += (hour * 60 + random.nextInt(60)) - arrivalTime;
                    totalPassengers++;
                }
            }
        }

        double avgWaitTime = (totalPassengers == 0) ? 0 : (double) totalWaitTime / totalPassengers;
        System.out.println("Среднее время пребывания пассажира: " + avgWaitTime + " мин.");
        System.out.println("Всего перевезено пассажиров: " + totalPassengers);
    }
}

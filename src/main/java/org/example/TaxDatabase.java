package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaxDatabase {
    private final Map<Object, Person> database = new HashMap<Object, Person>();
    private final Scanner scanner = new Scanner(System.in);

    public void addPerson(String id, String name) {
        database.put(id, new Person(id, name));
    }

    public void addFine(String id, Fine fine) {
        Person person = database.get(id);
        if (person != null) {
            person.addFine(fine);
        } else {
            System.out.println("Человек с таким ID не найден!");
        }
    }

    public void removeFine(String id, String type) {
        Person person = database.get(id);
        if (person != null) {
            person.getFines().removeIf(fine -> fine.getType().equalsIgnoreCase(type));
        } else {
            System.out.println("Человек с таким именем не найден!");
        }
    }

    public void printAll() {
        database.values().forEach(System.out::println);
    }

    public void printById(String id) {
        System.out.println(database.getOrDefault(id, new Person(id, "Человек не найден.")));
    }

    public void printByFineType(String type) {
        database.values().stream()
                .filter(person -> person.getFines().stream().anyMatch(fine -> fine.getType().equalsIgnoreCase(type)))
                .forEach(System.out::println);
    }

    public void printByCity(String city) {
        database.values().stream()
                .filter(person -> person.getFines().stream().anyMatch(fine -> fine.getCity().equalsIgnoreCase(city)))
                .forEach(System.out::println);
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Добавить человека\n2. Добавить штраф\n3. Удалить штраф\n4. Распечатать всех\n5. Поиск по ID\n6. Поиск по типу штрафа\n7. Поиск по городу\n8. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    addPerson(id, name);
                    break;

                case 2:
                    System.out.print("Введите ID человека: ");
                    id = scanner.nextLine();
                    System.out.print("Введите тип штрафа: ");
                    String type = scanner.nextLine();
                    System.out.print("Введите сумму штрафа: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Введите город: ");
                    String city = scanner.nextLine();
                    addFine(id, new Fine(type, amount, city));
                    break;

                case 3:
                    System.out.print("Введите ID человека: ");
                    id = scanner.nextLine();
                    System.out.print("Введите тип штрафа для удаления: ");
                    type = scanner.nextLine();
                    removeFine(id, type);
                    break;
                case 4:
                    printAll();
                    break;
                case 5:
                    System.out.print("Введите ID: ");
                    printById(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Введите тип штрафа: ");
                    printByFineType(scanner.nextLine());
                    break;
                case 7:
                    System.out.print("Введите город: ");
                    printByCity(scanner.nextLine());
                    break;
                case 8:
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }
}

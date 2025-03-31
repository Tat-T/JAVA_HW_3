package org.example;

import java.util.*;

public class DictionaryApp {
    private final Map<String, List<String>> dictionary = new HashMap<>();
    private final Map<String, Integer> wordUsage = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    // Добавить слово и перевод
    public void addWord(String word, List<String> translations) {
        dictionary.put(word, translations);
        wordUsage.put(word, 0); // инициализируем счётчик обращений
    }

    // Удалить слово
    public void removeWord(String word) {
        dictionary.remove(word);
        wordUsage.remove(word);
    }

    // Показать перевод слова
    public void showTranslation(String word) {
        if (dictionary.containsKey(word)) {
            System.out.println("Переводы: " + dictionary.get(word));
            wordUsage.put(word, wordUsage.get(word) + 1);
        } else {
            System.out.println("Слово не найдено.");
        }
    }

    // Вывести ТОП-10 популярных слов
    public void showTopWords(boolean popular) {
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordUsage.entrySet());
        sortedWords.sort((a,b) -> popular ? b.getValue() - a.getValue() : a.getValue() - b.getValue());

        System.out.println((popular ? "ТОП-10 популярных" : "ТОП-10 непопулярных") + " слов:");
        sortedWords.stream().limit(10).forEach(entry ->
                System.out.println(entry.getKey() + " - " + entry.getValue() + " запросов")
        );
    }

    // Запуск меню
    public void run() {
        while (true) {
            System.out.println("\n1. Добавить слово\n2. Удалить слово\n3. Показать перевод\n4. ТОП-10 популярных\n5. ТОП-10 непопулярных\n6. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите слово: ");
                    String word = scanner.nextLine();
                    System.out.print("Введите переводы через запятую: ");
                    List<String> translations = Arrays.asList(scanner.nextLine().split(", "));
                    addWord(word, translations);
                    break;
                case 2:
                    System.out.print("Введите слово для удаления: ");
                    removeWord(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Введите слово для поиска: ");
                    showTranslation(scanner.nextLine());
                    break;
                case 4:
                    showTopWords(true);
                    break;
                case 5:
                    showTopWords(false);
                    break;
                case 6:
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }
}

// 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// 2. Пусть дан список сотрудников:
//Иван Иванов
//Светлана Петрова
//Кристина Белова
//Анна Мусина
//Анна Крутова
//Иван Юрин
//Петр Лыков
//Павел Чернов
//Петр Чернышов
//Мария Федорова
//Марина Светлова
//Мария Савина
//Мария Рыкова
//Марина Лугова
//Анна Владимирова
//Иван Мечников
//Петр Петин
//Иван Ежов

//3. Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

//4. Реализовать алгоритм пирамидальной сортировки (HeapSort).



import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

        // заполнение телефонной книги
        phoneBook.put("Иван Иванов", new ArrayList<>(Arrays.asList("111-111", "222-222")));
        phoneBook.put("Светлана Петрова", new ArrayList<>(Arrays.asList("333-333", "444-444")));
        phoneBook.put("Кристина Белова", new ArrayList<>(Arrays.asList("555-555")));
        phoneBook.put("Анна Мусина", new ArrayList<>(Arrays.asList("666-666", "777-777")));
        phoneBook.put("Анна Крутова", new ArrayList<>(Arrays.asList("888-888")));
        phoneBook.put("Иван Юрин", new ArrayList<>(Arrays.asList("999-999")));
        phoneBook.put("Петр Лыков", new ArrayList<>(Arrays.asList("000-000")));
        phoneBook.put("Павел Чернов", new ArrayList<>(Arrays.asList("111-111")));
        phoneBook.put("Петр Чернышов", new ArrayList<>(Arrays.asList("222-222")));
        phoneBook.put("Мария Федорова", new ArrayList<>(Arrays.asList("333-333")));
        phoneBook.put("Марина Светлова", new ArrayList<>(Arrays.asList("444-444")));
        phoneBook.put("Мария Савина", new ArrayList<>(Arrays.asList("555-555")));
        phoneBook.put("Мария Рыкова", new ArrayList<>(Arrays.asList("666-666")));
        phoneBook.put("Марина Лугова", new ArrayList<>(Arrays.asList("777-777")));
        phoneBook.put("Анна Владимирова", new ArrayList<>(Arrays.asList("888-888")));
        phoneBook.put("Иван Мечников", new ArrayList<>(Arrays.asList("999-999")));
        phoneBook.put("Петр Петин", new ArrayList<>(Arrays.asList("000-000")));
        phoneBook.put("Иван Ежов", new ArrayList<>(Arrays.asList("111-111")));

        // поиск повторяющихся имен
        HashMap<String, Integer> nameCount = new HashMap<>();
        for (String name : phoneBook.keySet()) {
            String firstName = name.split(" ")[0];
            if (nameCount.containsKey(firstName)) {
                nameCount.put(firstName, nameCount.get(firstName) + 1);
            } else {
                nameCount.put(firstName, 1);
            }
        }

        // сортировка по убыванию популярности
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(nameCount.entrySet());
        sortedList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // вывод результатов
        System.out.println("Повторяющиеся имена:");
        for (Map.Entry<String, Integer> entry : sortedList) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " раз");
            }
        }
    }
}
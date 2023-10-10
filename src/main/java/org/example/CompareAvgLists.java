package org.example;

import java.util.List;

/**
 * Создайте программу, которая принимает два списка и выполняет следующие действия:
 * 1. Рассчитывает среднее значение каждого списка
 * 2. Сравнивает эти средние значениея и выводит одно из сообщений:
 * - "Первый список имеет большее среднее"
 * - "Второй списко имеет большее среднее"
 * - "Средние значения списков равны"
 */
public class CompareAvgLists {
    /**
     * Метод принимает список Integer и возвращает среднее значение в списке
     * @param list входной список
     * @return среднее значение
     */
    public static double calculateAvg(List<Integer> list) {
        double res = 0;
        try {
            res = list.stream().mapToInt(a -> a).average().orElse(0);
        }
        catch(NullPointerException ex) {
            System.out.println("Список не инициализирован");
        }
        return res;
    }

    /**
     * Метод принимает два списка Integer и выводит сообщение о том, какой список имеет большее среднее значений
     * @param list1
     * @param list2
     * @return 1, если среднее списка list1 больше среднего списка list2; -1, если среднее списка list2 больше
     * списка list1; 0, если средние значения списков list1 и list2 равны.
     */
    public static int compareAvgOfLists(List<Integer> list1, List<Integer> list2) {
        if (calculateAvg(list1) > calculateAvg(list2))
            return 1;
        else if (calculateAvg(list1) < calculateAvg(list2))
            return -1;
        else
            return 0;
    }
}
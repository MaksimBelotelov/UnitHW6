package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareAvgListsTest {
    /**
     * Проверка того, что метод верно считает среднее значение для списка
     */
    @Test
    void testCalculateAvg() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 4));
        double avg = CompareAvgLists.calculateAvg(list);
        assertEquals(avg, 3.5);
    }

    /**
     * Проверка того, что среднее значение верно рассчитывается для одинаковых нулевых значений
     */
    @Test
    void testCalculateWithNul() {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 0, 0));
        double avg = CompareAvgLists.calculateAvg(list);
        assertEquals(avg, 0.0);
    }

    /**
     * Проверка того, что для некорректного параметра (null) возвращается корректное нулевое значение.
     */
    @Test
    void testCalculateWithNull() {
        List<Integer> list = null;
        double avg = CompareAvgLists.calculateAvg(list);
        assertEquals(avg, 0.0);
    }

    /**
     * Проверка того, что списки верно сравниваются, когда среднее первого списка меньше среднего второго списка
     */
    @Test
    void testCompareAvgOfListsFirstLess() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10));

        assertEquals(CompareAvgLists.compareAvgOfLists(list1, list2), -1);
    }

    /**
     * Проверка того, что списки верно сравниваются, когда среднее второго списка меньше среднего первого списка
     */
    @Test
    void testCompareAvgOfListsSecondLess() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 0));

        assertEquals(CompareAvgLists.compareAvgOfLists(list1, list2), 1);
    }

    /**
     * Проверка того, что списки верно сравниваются, когда среднее первого списка равно среднему второго списка
     */
    @Test
    void testCompareAvgOfListsEqual() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 4, 7));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 5, 5));

        assertEquals(CompareAvgLists.compareAvgOfLists(list1, list2), 0);
    }

    /**
     * Проверка сравнения с неинициализированным списком.
     */
    @Test
    void testCompareAvgOfListsFirstNull() {
        List<Integer> list2 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10));

        assertEquals(CompareAvgLists.compareAvgOfLists(null, list2), -1);
    }

    /**
     * Сравнение двух неинициализированных списков
     */
    @Test
    void testCompareAvgOfListsBothNull() {
        assertEquals(CompareAvgLists.compareAvgOfLists(null, null), 0);
    }

    /**
     * Проверка сравнения двух пустых списков
     */
    @Test
    void testCompareTwoEmpty() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        assertEquals(CompareAvgLists.compareAvgOfLists(list1, list2), 0);
    }
}
package com.company;

import java.util.Arrays;

public class QuickSort implements Sortable {

    public Person[] sort(Person[] persons) {
        Person[] result = Arrays.copyOf(persons, persons.length);
        int low = 0;
        int high = result.length - 1;
        sort(result, low, high);
        return result;
    }

    public static void sort(Person[] result, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        Person pivot = result[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (result[leftMarker].compareTo(pivot) < 0) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (result[rightMarker].compareTo(pivot) > 0) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    Person tmp = result[leftMarker];
                    result[leftMarker] = result[rightMarker];
                    result[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            sort(result, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            sort(result, leftBorder, rightMarker);
        }
    }
}

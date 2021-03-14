package com.company;

import java.util.Arrays;

public class BubbleSort implements Sortable {
    @Override
    public Person[] sort(Person[] persons) {
        Person[] result = Arrays.copyOf(persons, persons.length);
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                // если порядок элементов нарушен, то меняем местами
                if (result[i].compareTo(result[j]) > 0) {
                    Person tmp = result[i];
                    result[i] = result[j];
                    result[j] = tmp;
                }
            }
        }
        return result;
    }
}

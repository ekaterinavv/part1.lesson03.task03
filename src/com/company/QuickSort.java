package com.company;

public class QuickSort implements Sortable { Person[] persons;

    static int split(Person[] result, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (result[i].compareTo( result[pivot]) == -1) {
                Person tmp = result[counter];
                result[counter] = result[i];
                result[i] = tmp;
                counter++;
            }
        }
        Person tmp = result[pivot];
        result[pivot] = result[counter];
        result[counter] = tmp;

        return counter;
    }

    public Person[] sort (Person[] persons){
        Person[] result = persons.clone();
        int low = 0;
        int high = result.length - 1;
        sort(result, low, high);
        return result;
    }
    private  void sort(Person[] result, int begin, int end) {
        if (end <= begin) return;
        int pivot = split(result, begin, end);
        sort(result, begin, pivot - 1);
        sort(result, pivot + 1, end);
    }
}

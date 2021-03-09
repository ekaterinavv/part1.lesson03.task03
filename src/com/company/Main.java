package com.company;

import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Input n:");
        Scanner scanner = new Scanner(System.in);

        // Генерация исходных данных
        int n = Integer.parseInt(scanner.nextLine());
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            persons[i] = new Person();
        }


    /* Person[] persons = new Person[]{ new Person((byte)32, Sex.WOMAN, "ЖЕНЯ"),
                                        new Person((byte)31, Sex.WOMAN, "ЖЕНЯ"),
                                        new Person((byte)31, Sex.WOMAN, "АНЯ"),
                                        new Person((byte)31, Sex.MAN, "ЖЕНЯ"),
                                        new Person((byte)31, Sex.MAN, "ЖЕНЯ")};
       int n = persons.length;*/

        // Данные до сортировки
        System.out.println("Initial data: ");
        for (Person person: persons)
            System.out.println(person.getInformation());

        //BubbleSort
        Instant start = Instant.now();
        BubbleSort bubbleSort = new BubbleSort();
        Person[] sortedPersons1 = bubbleSort.sort(persons);
        Thread.sleep(1000);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("\n\nBubble sort, ms: " + elapsed);
        System.out.println("Sorted data: ");
        for (Person sortPerson: sortedPersons1)
            System.out.println(sortPerson.getInformation());

        //QuickSort
        start = Instant.now();
        QuickSort quickSort = new QuickSort();
        Person[] sortedPersons2 = quickSort.sort(persons);
        Thread.sleep(1000);
        finish = Instant.now();
        elapsed = Duration.between(start, finish).toMillis();
        System.out.println("\n\nQuick sort, ms: " + elapsed);
        System.out.println("Sorted data: ");
        for (Person sortPerson: sortedPersons2) {
            System.out.println(sortPerson.getInformation());

        }
        //Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение
        for (int i = 0; i < (sortedPersons1.length - 1); i++) {
            if(sortedPersons1[i].compareTo(sortedPersons1[i + 1]) == 0) {
                throw new Exception("People match : " + sortedPersons1[i].getInformation());
            }

        }

    }




}

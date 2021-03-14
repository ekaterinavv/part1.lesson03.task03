package com.company;

import java.util.Random;

public class Person implements Comparable<Person> {
    private byte age;
    private Sex sex;
    private String name;

    public Person(byte age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sex= " + this.sex + ", age= " + this.age + ", name = " + name;
    }

    @Override
    public int compareTo(Person person2) {
        if (this.sex != person2.sex)
            return this.sex.compareTo(person2.sex);
        else if (person2.age != this.age) {
            return Integer.compare(person2.age, this.age);
        } else {
            return (this.name.compareTo(person2.name));
        }
    }
}

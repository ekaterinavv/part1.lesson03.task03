package com.company;

import java.util.Random;

public class Person {
    private byte age;
    private Sex sex;
    private String name;
    public Person() {
        Random random = new Random();
        //генерируем возраст
        this.age = (byte)random.nextInt(101);

        // генерируем пол
        this.sex  = Sex.values()[random.nextInt(2)];

         // генерируем имя
        int len = random.nextInt(9) + 1;
        //int len = 10;
        int dif = 'Z'-'A';
        char[] str = new char[len];
        for (int i = 0; i < len; i++){
            str[i] = (char)(random.nextInt(dif) + 'A');
        }
        this.name = new String(str);

    }

    public Person(byte age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public String getInformation() {
        String information = "Sex= " + this.sex + ", age= " + this.age +  ", name = " + name;
        return information;
    }
    public int compareTo( Person person2) {
        if(this.sex != person2.sex)
            if (person2.sex == Sex.MAN) {
                return 1;
            }
            else{
                return -1;
            }
        else
             if (person2.age != this.age) {
                 return ((int) Math.signum(person2.age - this.age));
             }
             else {
                 return ((int) Math.signum (this.name.compareTo(person2.name)));
             }
    }

}
enum Sex{WOMAN, MAN};
package com.company;

import java.util.Random;

public class Util {
    static Random random = new Random();

    //генерируем возраст
    static byte generateAge(int maxAge) {
        return (byte) random.nextInt(maxAge + 1);
    }

    //генерируем пол
    static Sex generateSex() {
        return Sex.values()[random.nextInt(Sex.values().length)];
    }

    // генерируем имя
    static String generateName(int maxLen) {
        int len = random.nextInt(maxLen) + 1;
        int dif = 'Z' - 'A';
        char[] str = new char[len];
        for (int i = 0; i < len; i++) {
            str[i] = (char) (random.nextInt(dif) + 'A');
        }
        return new String(str);
    }
}

package com.in28minutes.springboot.basics.springbootin10steps;

import java.util.HashMap;
import java.util.Map;
/**
 * Problem Statement: To take number as a input and return the same number with ordinal append at the end of the number. E.g. 1st, 2nd, 3rd, 11th, 12th 121st, 125th
 */
public class Ordinal {

    public String getOrdinal(int number) {
        int lastDigit;
        int lastTwoDigits;
        Map<Integer, String> ordinalMap = new HashMap<>();
        ordinalMap.put(1, "st");
        ordinalMap.put(2, "nd");
        ordinalMap.put(3, "rd");
        lastDigit = number % 10;
        lastTwoDigits = number % 100;
        if (number == 0) {
            return String.valueOf(number);
        } else if (lastDigit >= 1 && lastDigit <= 3 && !(lastTwoDigits >= 11 && lastTwoDigits <= 19)) {
            return String.valueOf(number) + ordinalMap.get(lastDigit);
        } else {
            return String.valueOf(number) + "th";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Ordinal().getOrdinal(122));
    }
}

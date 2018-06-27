package net.asifhossain.leetcode.P0013RomanToInteger;

public class P0013RomanToInteger {
    public int romanToInt(String s) {

        s = s.replaceAll("CM", "H");
        s = s.replaceAll("CD", "G");
        s = s.replaceAll("XC", "F");
        s = s.replaceAll("XL", "E");
        s = s.replaceAll("IX", "B");
        s = s.replaceAll("IV", "A");

        int number = 0;

        for (char c: s.toCharArray()) {
            if (c == 'I') {
                number += 1;
            } else if (c == 'V') {
                number += 5;
            } else if (c == 'X') {
                number += 10;
            } else if (c == 'L') {
                number += 50;
            } else if (c == 'C') {
                number += 100;
            } else if (c == 'D') {
                number += 500;
            } else if (c == 'M') {
                number += 1000;
            } else if (c == 'A') {
                number += 4;
            } else if (c == 'B') {
                number += 9;
            } else if (c == 'E') {
                number += 40;
            } else if (c == 'F') {
                number += 90;
            } else if (c == 'G') {
                number += 400;
            } else if (c == 'H') {
                number += 900;
            }

        }

        return number;
    }
}

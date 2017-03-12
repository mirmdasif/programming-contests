package net.asifhossain.hackerrank.WeekOfCode29.MegaPrimes;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 2/26/17.
 */
public class MegaPrimes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long first = sc.nextLong();
        long last = sc.nextLong();

        int count = 0;


        for (Long i = getNext(first); i <= last; i = getNextProbablePrime(i)) {

            if (i < first) continue;
//            System.out.println(i);

            BigInteger b = new BigInteger(i.toString());

            if (b.isProbablePrime(10)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static long getNext(Long k ) {
        Map<Character, Character> con = new HashMap<>(4);
        con.put('0', '2');
        con.put('1', '2');
        con.put('2', '2');
        con.put('3', '3');
        con.put('4', '5');
        con.put('5', '5');
        con.put('6', '7');
        con.put('7', '7');
        con.put('8', '7');
        con.put('9', '7');

        char[] a = k.toString().toCharArray();

        for (int i = 0; i < a.length; i++) {
            if(con.get(a[i]) > a[i]) {
                a[i] = con.get(a[i]);
                while (++i < a.length) {
                    a[i] = '2';
                }
            } else if (con.get(a[i]) < a[i]) {
                a[i] = con.get(a[i]);
                while (++i < a.length) {
                    a[i] = '7';
                }
            } else {
                a[i] = con.get(a[i]);
            }
        }

        return Long.parseLong(new String(a));
    }

    static long getNextProbablePrime(Long n) {
        Map<Character, Character> map = new HashMap<>(4);
        map.put('2', '3');
        map.put('3', '5');
        map.put('5', '7');
        map.put('7', '2');

        char[] a = n.toString().toCharArray();

        for (int i = a.length - 1; i >= 0;) {
            char x = map.get(a[i]);
            a[i] = x;

            if(x == '2')
                i--;
            else {
                return Long.parseLong(new String(a));
            }
        }
        a = new char[a.length + 1];

        for (int i = 0; i < a.length; i++) {
            a[i] = '2';
        }

        return Long.parseLong(new String(a));
    }
}
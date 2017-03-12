package net.asifhossain.hackerrank.MegaPrimes;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 2/26/17.
 */
public class MegaPrimes {
    static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long first = sc.nextLong();
        long last = sc.nextLong();

        int count = 0;


        for (Long i = getNext(first); i <= last; i = getNextProbablePrime(i)) {

            if (i < first) continue;

            if (Prime.isPrime(i)) {
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

class Prime {

    // this is the RabinMiller test, deterministically correct for n < 341,550,071,728,321
    // http://rosettacode.org/wiki/Miller-Rabin_primality_test#Python:_Proved_correct_up_to_large_N
    public static boolean isPrime(BigInteger n, int precision) {

        if (n.compareTo(new BigInteger("341550071728321")) >= 0) {
            return n.isProbablePrime(precision);
        }

        int intN = n.intValue();
        if (intN == 1 || intN == 4 || intN == 6 || intN == 8) return false;
        if (intN == 2 || intN == 3 || intN == 5 || intN == 7) return true;

        int[] primesToTest = getPrimesToTest(n);
        if (n.equals(new BigInteger("3215031751"))) {
            return false;
        }
        BigInteger d = n.subtract(BigInteger.ONE);
        BigInteger s = BigInteger.ZERO;
        while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            d = d.shiftRight(1);
            s = s.add(BigInteger.ONE);
        }
        for (int a : primesToTest) {
            if (try_composite(a, d, n, s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(BigInteger n) {
        return isPrime(n, 100);
    }

    public static boolean isPrime(int n) {
        return isPrime(BigInteger.valueOf(n), 100);
    }

    public static boolean isPrime(long n) {
        return isPrime(BigInteger.valueOf(n), 100);
    }

    private static int[] getPrimesToTest(BigInteger n) {
        if (n.compareTo(new BigInteger("3474749660383")) >= 0) {
            return new int[]{2, 3, 5, 7, 11, 13, 17};
        }
        if (n.compareTo(new BigInteger("2152302898747")) >= 0) {
            return new int[]{2, 3, 5, 7, 11, 13};
        }
        if (n.compareTo(new BigInteger("118670087467")) >= 0) {
            return new int[]{2, 3, 5, 7, 11};
        }
        if (n.compareTo(new BigInteger("25326001")) >= 0) {
            return new int[]{2, 3, 5, 7};
        }
        if (n.compareTo(new BigInteger("1373653")) >= 0) {
            return new int[]{2, 3, 5};
        }
        return new int[]{2, 3};
    }

    private static boolean try_composite(int a, BigInteger d, BigInteger n, BigInteger s) {
        BigInteger aB = BigInteger.valueOf(a);
        if (aB.modPow(d, n).equals(BigInteger.ONE)) {
            return false;
        }
        for (int i = 0; BigInteger.valueOf(i).compareTo(s) < 0; i++) {
            // if pow(a, 2**i * d, n) == n-1
            if (aB.modPow(BigInteger.valueOf(2).pow(i).multiply(d), n).equals(n.subtract(BigInteger.ONE))) {
                return false;
            }
        }
        return true;
    }
}

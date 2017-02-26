package net.asifhossain.hackerrank.ExtraLongFactorial;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 2/16/17.
 */
public class ExtraLongFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        BigInteger n = new BigInteger(numStr);
        BigInteger sum = new BigInteger(numStr);

        while (!n.equals(BigInteger.ONE)) {
           n = n.subtract(BigInteger.ONE);
            sum = sum.multiply(n);
        }

        System.out.println(sum);
    }
}

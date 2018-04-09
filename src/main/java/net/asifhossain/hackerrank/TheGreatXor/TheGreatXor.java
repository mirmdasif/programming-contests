package net.asifhossain.hackerrank.TheGreatXor;

import java.util.Scanner;

public class TheGreatXor {

    static long theGreatXor(long x){
        String str = Long.toBinaryString(x);
        long c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                c += ((Double)Math.pow(2, str.length() - 1 - i)).longValue();
            }
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
    }
}

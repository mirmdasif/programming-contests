package net.asifhossain.iarcs.voterslist;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = new int[sc.nextInt()];
        int b[] = new int[sc.nextInt()];
        int c[] = new int[sc.nextInt()];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }


        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }


        for (int i = 0; i < c.length; i++) {
            c[i] = sc.nextInt();
        }

        int i = 0;
        int j = 0;
        int k = 0;

        int count = 0;
        StringBuilder builder = new StringBuilder();

        while (i < a.length || j < b.length || k < c.length) {
            int a_i = Integer.MAX_VALUE;
            int b_i = Integer.MAX_VALUE;
            int c_i = Integer.MAX_VALUE;
            if (i < a.length) {
                a_i = a[i];
            }

            if (j < b.length) {
                b_i = b[j];
            }

            if (k < c.length) {
                c_i = c[k];
            }

            int number = Math.min(Math.min(a_i, b_i), c_i);

            int app = 0;
            if (i < a.length && number == a[i]) {
                app++;
                i++;
            }

            if (j < b.length && number == b[j]) {
                app++;
                j++;
            }

            if (k <  c.length &&  number == c[k]) {
                app++;
                k++;
            }


            if (app > 1) {
                count++;
                builder.append(number);
                builder.append('\n');
            }

        }

        System.out.println(count);
        System.out.println(builder.toString());
    }
}

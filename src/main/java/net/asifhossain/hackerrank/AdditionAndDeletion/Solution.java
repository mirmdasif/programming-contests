package net.asifhossain.hackerrank.AdditionAndDeletion;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();

        if(k >= s.length() + t.length()) {
            System.out.println("Yes");
            return;
        }

        if(s.equals(t) &&  k % 2 == 0) {
            System.out.println("Yes");
            return;
        }

        int i = 0;
        for (; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
        }

        int diff = (s.length() - i) + (t.length() - i);

        if((k - diff) >= 0 && (k - diff) % 2 == 0) {
            System.out.println("Yes");
        } else {

            System.out.println("No");
        }

    }
}


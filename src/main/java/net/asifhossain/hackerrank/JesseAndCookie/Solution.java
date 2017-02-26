package net.asifhossain.hackerrank.JesseAndCookie;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }
        int i = 0;
        while (!queue.isEmpty()) {
            if (queue.peek() >= s) {
                System.out.println(i);
                return;
            }

            int min1 = queue.poll();
            if (queue.isEmpty()) {
                break;
            }

            int min2 = queue.poll();

            queue.add(min1 + min2 * 2);
            i++;
        }

        System.out.println(-1);
    }
}

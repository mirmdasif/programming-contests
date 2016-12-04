package net.asifhossain.hackerrank.QHeap1;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 12/1/16.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        Queue<Integer> queue = new PriorityQueue<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            switch (sc.nextInt()) {
                case 1 :
                    queue.add(sc.nextInt());
                    break;
                case 2 :
                    queue.remove(sc.nextInt());
                    break;
                case 3 :
                    System.out.println(queue.peek());
            }
        }

    }
}

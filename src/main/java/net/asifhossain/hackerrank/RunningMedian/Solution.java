package net.asifhossain.hackerrank.RunningMedian;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median
 * @author asif.hossain
 * @since 11/30/16.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();

            if (maxHeap.size() == 0) {
              maxHeap.add(number);
            } else if (number <= maxHeap.peek()) {
                maxHeap.add(number);
                if(maxHeap.size() - minHeap.size() > 1) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(number);

                if (maxHeap.size() < minHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }

            if (maxHeap.size() > minHeap.size()) {
                System.out.printf("%.1f\n", (float) maxHeap.peek());
            } else {
                System.out.printf("%.1f\n", (float) (maxHeap.peek() + minHeap.peek()) / 2);
            }
        }
    }
}
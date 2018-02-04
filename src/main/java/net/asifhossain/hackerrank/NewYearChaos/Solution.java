package net.asifhossain.hackerrank.NewYearChaos;

import java.util.Scanner;

public class Solution {

    static void minimumBribes(int[] q) {
        // Complete this function
        int count = 0;
        int[] swapCount = new int[q.length];
        for (int j = 0; j <q.length; j++) {


            for (int i = 0; i < q.length - 1; i++) {
                if (q[i] > q[i + 1]) {
                    swapCount[q[i] - 1]++;

                    if (swapCount[q[i] - 1] > 2) {

                        System.out.println("Too chaotic");

                        return;
                    }

                    swap(q, i, i + 1);
                    count++;

                }
            }
            boolean sorted = true;
            for(int i = 0; i < q.length - 1; i++) {
                if(q[i]>q[i+1]) {
                    sorted = false;
                    break;
                }
            }

            if(sorted) {
                break;
            }
        }

        System.out.println(count);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] q = new int[n];
            for(int q_i = 0; q_i < n; q_i++){
                q[q_i] = in.nextInt();
            }
            minimumBribes(q);
        }
        in.close();
    }
}
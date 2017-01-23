package net.asifhossain.hackerrank.AndOrXor;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author asif.hossain
 * @since 1/22/17.
 */
public class AndOrXorStack {
    int max(int[] a) {
        Stack<Integer> stack = new Stack<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty()) {
                if (max < (stack.peek() ^ a[i])) {
                    max = stack.peek() ^ a[i];
                }
                if (stack.peek() > a[i]) {
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(a[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        AndOrXorStack s = new AndOrXorStack();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(s.max(a));
    }
}

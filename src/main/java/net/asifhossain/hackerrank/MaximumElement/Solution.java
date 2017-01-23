package net.asifhossain.hackerrank.MaximumElement;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author asif.hossain
 * @since 1/23/17.
 */
public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int q = sc.nextInt();
            switch (q) {
                case 1 :
                    int x = sc.nextInt();
                    max = Math.max(x, max);
                    stack.push(new Node(x, max));
                    break;
                case 2:
                    stack.pop();
                    if(stack.isEmpty()) {
                        max = 0;
                    } else {
                        max = stack.peek().maxElement;
                    }
                    break;
                case 3:
                    System.out.println(stack.peek().maxElement);
            }
        }
    }
}

class Node {
    int value;
    int maxElement;

    public Node(int value, int maxElement) {
        this.value = value;
        this.maxElement = maxElement;
    }
}

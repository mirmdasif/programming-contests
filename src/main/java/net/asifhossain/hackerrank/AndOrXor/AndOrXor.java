package net.asifhossain.hackerrank.AndOrXor;

import java.util.Arrays;


/**
 * @author asif.hossain
 * @since 1/15/17.
 */
public class AndOrXor {
    public static void main(String[] args) {

        AndOrXor andOrXor = new AndOrXor();
        System.out.println(andOrXor.divideAndC(new int[] {9, 11, 6, 3, 5, 2}, 0, 4));
    }

    private Node divideAndC(int[] a, int l, int r) {
        if(l == r) {
            return new Node(a[l], Integer.MAX_VALUE, 0);
        }

        return new Node(divideAndC(a, l, (l + r)/2), divideAndC(a, (l + r)/2 + 1, r));
    }

    class Node {
        @Override
        public String toString() {
            return "Node{" +
                    "m1=" + m1 +
                    ", m2=" + m2 +
                    ", result=" + result +
                    '}';
        }

        int m1;
        int m2;
        int result;

        public Node(int m1, int m2, int result) {
            this.m1 = m1;
            this.m2 = m2;
            this.result = result;
        }

        public Node(Node n1, Node n2) {
            int a[] = new int[] {n1.m1, n1.m2, n2.m1, n2.m2};
            Arrays.sort(a);

            m1 = a[0];
            m2 = a[1];
            result = Math.max(Math.max(n1.result, n2.result), calcXor(a[0], a[1]));
        }

        private int calcXor(int m1, int m2) {
            return (m1 & m2) ^ (m1 | m2) & (m1 ^ m2);
        }
    }
}

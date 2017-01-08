package net.asifhossain.hackerrank.MaximumAreaInHistogram;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author asif.hossain
 * @since 12/21/16.
 */
public class MaximumRectangleInHistogram {
    SegmentTree tree;
    public int maxAreaBruteForce(int[] heights) {
        int maxRectangle = 0;

        for (int i = 0; i < heights.length; i++) {

            int rectangle = heights[i];
            int min = heights[i];

            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < min) {
                    min = heights[j];
                }

                if (min * (j - i + 1) > rectangle) {
                    rectangle = min * (j - i + 1);
                }
            }
            if (maxRectangle < rectangle) {
                maxRectangle = rectangle;
            }
        }

        return maxRectangle;
    }

    static int count = 0;
    public int maxAreaDivideAndConquer(int a[], int l, int r) {
        if (r < 0) {
            return 0;
        }
        if (l > r) {
            return 0;
        }
        if (l == r)
            return a[l];

//        int m = findIdxOfMinInRange(a, l, r);
        int m = tree.rmq(l, r);

        return max(
                maxAreaDivideAndConquer(a, l, m - 1),
                maxAreaDivideAndConquer(a,m + 1, r),
                (r - l + 1) * a[m]);
    }

    private int findIdxOfMinInRange(int[] a, int l, int r) {
        int min = l;
        for (int i = l + 1; i <= r; r++) {
            if (a[i] < a[min]) {
                min = i;
            }
        }

        return min;
    }

    int max(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }

    int maxArea(int[] heights) {
        int max = 0;

        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int p = stack.pop();
                int height = heights[p];
                int weight = stack.isEmpty() ? i : i - stack.peek() - 1;

                max = Math.max(max, weight * height);
            }
        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int height = heights[p];
            int weight = stack.isEmpty() ? i : i - stack.peek() - 1;

            max = Math.max(max, weight * height);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumRectangleInHistogram b = new MaximumRectangleInHistogram();
        Scanner sc = new Scanner(System.in);

        int[] a = new int[sc.nextInt()];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        b.tree = new SegmentTree(a);
        System.out.println(b.maxAreaBruteForce(a));
        System.out.println(b.maxAreaDivideAndConquer(a, 0, a.length -1));
        System.out.println(b.maxArea(a));
    }
}

class SegmentTree {
    private int[] a;
    private int[] array;

    public SegmentTree(int[] array) {
        a = new int[array.length * 4];

        a[a.length - 1] = Integer.MAX_VALUE;

        this.array = array;
        constructTree(array, 0, array.length - 1, 0);
    }

    private int constructTree(int[] array, int left, int right, int index) {
        if (left == right) {
            a[index] = left;
            return left;
        }

        int i1 = constructTree(array, left, mid(left, right), leftChild(index));
        int i2= constructTree(array, mid(left, right) + 1, right, rightChild(index));

        a[index] = array[i1] < array[i2] ? i1 : i2;
        return a[index];
    }

    public int rmq(int qs, int qe) {
        return rmq(qs, qe, 0, a.length / 4 - 1, 0);
    }

    private int rmq(int qs, int qe, int ss, int se, int idx) {
        if (ss >= qs && se <= qe) {
            return a[idx];
        }

        if (ss > qe || se < qs) {
            return - 1;
        }

        int i1 = rmq(qs, qe, ss, mid(ss, se), leftChild(idx));
        int i2 = rmq(qs, qe, mid(ss, se) + 1, se, rightChild(idx));
        return minValue(i1, i2);
    }

    private int minValue(int i1, int i2) {
        if(i1 == -1) return i2;
        if (i2 == -1) return i1;

        return array[i1] < array[i2] ? i1 : i2;
    }

    private int rightChild(int idx) {
        return idx * 2 + 2;
    }

    private int leftChild(int idx) {
        return idx * 2 + 1;
    }

    private int mid(int left, int right) {
        return (left + right) / 2;
    }
}
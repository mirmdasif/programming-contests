package net.asifhossain.hackerrank;

/**
 * @aurhor sadasidha
 * @since 3/18/17.
 */
import net.asifhossain.codeforces.utils.ArrayUtils;

/**
 * @author asif.hossain
 * @since 1/4/17.
 */
class SegmentTree {
    private int[] a;

    public SegmentTree(int[] array) {
        a = new int[array.length * 4];

        constructTree(array, 0, array.length - 1, 0);
    }

    private int constructTree(int[] array, int left, int right, int index) {
        if (left == right) {
            a[index] = array[left];
            return a[index];
        }

        a[index] = Math.min(constructTree(array, left, mid(left, right), leftChild(index)), constructTree(array, mid(left, right) + 1, right, rightChild(index)));
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
            return Integer.MAX_VALUE;
        }

        return Math.min(rmq(qs, qe, ss, mid(ss, se), leftChild(idx)), rmq(qs, qe, mid(ss, se) + 1, se, rightChild(idx)));
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

    public static void main(String[] args) {
        net.asifhossain.datastructure.SegmentTree.SegmentTree tree = new net.asifhossain.datastructure.SegmentTree.SegmentTree(new int[] {3, 1, 2, 0, 4, 5});
        ArrayUtils.printArray(tree.);

        System.out.println(tree.rmq(0, 0));
    }
}
public class RangeModularQuery {
}

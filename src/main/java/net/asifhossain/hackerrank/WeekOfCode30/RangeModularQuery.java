package net.asifhossain.hackerrank.WeekOfCode30;

/**
 * @author asif.hossain
 * @since 3/19/17.
 */
public class RangeModularQuery {
    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree(new int[]{1, 2});

        System.out.println(segmentTree.rmq(0, 1));
    }
}

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

        a[index] = constructTree(array, left, mid(left, right), leftChild(index)) + constructTree(array, mid(left, right) + 1, right, rightChild(index));
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
            return 0;
        }

        return rmq(qs, qe, ss, mid(ss, se), leftChild(idx)) + rmq(qs, qe, mid(ss, se) + 1, se, rightChild(idx));
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


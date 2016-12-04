package net.asifhossain.datastructure.heap;

/**
 * @author asif.hossain
 * @since 11/30/16.
 */
public class MeanHeap implements Heap {

    private static final int DEFAULT_SIZE = 50;

    private int[] a;
    private int size;


    public MeanHeap() {
        new MeanHeap(DEFAULT_SIZE);
    }

    public MeanHeap(int initialSize) {
        a = new int[initialSize];
    }

    @Override
    public void add(int value) {

    }

    @Override
    public void remove(int value) {

    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public int poll() {
        return a[0];
    }

    @Override
    public int size() {
        return this.size;
    }
}

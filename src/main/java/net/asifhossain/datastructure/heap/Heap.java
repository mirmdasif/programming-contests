package net.asifhossain.datastructure.heap;

/**
 * @author asif.hossain
 * @since 11/30/16.
 */
public interface Heap {
    void add(int value);
    void remove(int value);
    int peek();
    int poll();
    int size();
}

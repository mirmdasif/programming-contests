package net.asifhossain.javarivisited;

/**
 * @author asif.hossain
 * @since 10/16/17.
 */
public class FibonacciSeries {

    public static void main(String[] args) {
        fibonacci(10);
    }

    static void fibonacci(int n) {
        int n1 = 1;
        int n2 = 1;
        if(n < 1) return;
        System.out.println(n1);
        System.out.println(n2);
        while (n2 <= n) {
            System.out.println(n1 + n2);
            int next = n1 + n2;
            n1 = n2;
            n2 = next;
        }


    }
}

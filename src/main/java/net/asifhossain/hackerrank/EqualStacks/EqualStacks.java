package net.asifhossain.hackerrank.EqualStacks;

import java.util.*;

/**
 * @author asif.hossain
 * @since 11/2/17.
 */
public class EqualStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        int h1[] = new int[n1];
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
        }

        int h2[] = new int[n2];
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
        }

        int h3[] = new int[n3];
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
        }

        Map<Integer, Integer> heights1 = new HashMap<>(n1);

        int sum = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            sum += h1[i];
            heights1.put(sum, 1);
        }

        sum = 0;
        Set<Integer> heights2 = new HashSet<>(n2);
        for (int i = n2 - 1; i >= 0; i--) {
            sum += h2[i];
            if (heights1.get(sum) != null) {
                heights2.add(sum);
            }
        }

        sum = 0;
        Integer maxHeight = 0;

        for (int i = n3 - 1; i >= 0; i--) {
            sum += h3[i];
            if (heights2.contains(sum)) {
                maxHeight = sum;
            }
        }

        System.out.print(maxHeight);
    }
}

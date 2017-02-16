package net.asifhossain.hackerrank.PoisonusPlants;

import net.asifhossain.codeforces.utils.ArrayUtils;

import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 2/6/17.
 */
public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] killer = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        killer[0] = -1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int pk = i - 1;
            while (true) {
                if (pk == -1) {
                    killer[i] = -1;
                    break;
                }

                if (a[pk] < a[i]) {
                    if (killer[pk] == -1 || (pk - killer[pk] >= i - pk)) {
                        killer[i] = pk;
                        max = Math.max(i - pk, max);
                        break;
                    }
                }

                pk = killer[pk];
            }
        }

        ArrayUtils.printArray(a);
        ArrayUtils.printArray(killer);
        System.out.println(max);
    }
}

package net.asifhossain.iarcs.LeadGame;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 3/28/17.
 */
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int winner = -1;
        int diff = -1;
        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < n; i++) {
            p1 += sc.nextInt();
            p2 += sc.nextInt();

            if (p1 > p2) {
                if (p1 - p2 > diff) {
                    winner = 1;
                    diff = p1 - p2;
                }
            } else {
                if (p2 - p1 > diff) {
                    winner = 2;
                    diff = p2 - p1;
                }
            }
        }

        System.out.println(winner + " " + diff);
    }
}

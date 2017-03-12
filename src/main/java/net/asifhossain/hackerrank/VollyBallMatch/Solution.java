package net.asifhossain.hackerrank.VollyBallMatch;

import net.asifhossain.algorithms.combination.Combination;

import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 3/5/17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int teamA = sc.nextInt();
        int teamB = sc.nextInt();

        int winner = Math.max(teamA, teamB);
        int looser = Math.min(teamA, teamB);

        if(winner < 25 || (winner == 25 && winner - looser < 2) || (winner > 25 && winner - looser != 2)) {
            System.out.println("0");
            return;
        }

        long result;

        if(winner > 25) {
            result = (Combination.binomialCoefficient(48, 24) % 1000000007);
            result = (result * pow(2, looser - 24, 1000000007)) % 1000000007;
        } else {
            result = Combination.binomialCoefficient(winner + looser - 1, looser) % 1000000007;
        }

        System.out.println(result);
    }

    static long pow(int n, int k, int mod) {
        long result = 1L;

        for (int i = 0; i < k; i++) {
            result = (result * n) % mod;
        }

        return result;
    }
}

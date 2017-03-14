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

        long C_48_24 = 32247603683100l;

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
            result = C_48_24 % 1000000007;
            result = (result * pow(looser - 24)) % 1000000007;
        } else {
            result = Combination.binomialCoefficient(winner + looser - 1, looser) % 1000000007;
        }

        System.out.println(result);
    }

    static long pow(int pow) {
        long result = 1l;

        while (pow > 63) {
            result = ((long) (Math.pow(2, 63) % 1000000007) * result) % 1000000007;
            pow = pow - 63;
        }

        result = ((long) (Math.pow(2, pow) % 1000000007) * result) % 1000000007;

        return result;
    }
}

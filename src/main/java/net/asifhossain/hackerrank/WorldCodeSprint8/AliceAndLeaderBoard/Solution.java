package net.asifhossain.hackerrank.WorldCodeSprint8.AliceAndLeaderBoard;



import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 12/18/16.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        int[] ranks = new int[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
            if (scores_i == 0) {
                ranks[scores_i] = 1;
            } else if (scores[scores_i] == scores[scores_i - 1]) {
                ranks[scores_i] = ranks[scores_i - 1];
            } else  {
                ranks[scores_i] = ranks[scores_i - 1] + 1;
            }
        }


        int m = in.nextInt();
        int[] alice = new int[m];

        for(int alice_i=0, i = ranks.length - 1; alice_i < m; alice_i++){
            int aliceScore = in.nextInt();

            if (i == 0) {
                if (scores[0] <= aliceScore)
                    System.out.println(1);
                else
                    System.out.println(2);
            } else {
                for (; i >= 0; i--) {
                    if (i == 0) {
                        if (aliceScore >= scores[i])
                            System.out.println(1);
                        else
                            System.out.println(ranks[i] + 1);
                        break;
                    }

                    if (scores[i] > aliceScore) {
                        System.out.println(ranks[i] + 1);
                        break;
                    } else if (scores[i] == aliceScore) {
                        System.out.println(ranks[i]);
                        break;
                    }
                }
            }
        }
        // your code goes here
    }
}
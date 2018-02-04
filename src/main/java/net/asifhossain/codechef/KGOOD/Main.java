package net.asifhossain.codechef.KGOOD;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author asif.hossain
 * @since 11/27/16.
 */
public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedOutputStream writer = new BufferedOutputStream(System.out);

    public static void main(String[] args) throws IOException {

        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNo = 0; caseNo < testCases; caseNo++) {
            String[] tokens = reader.readLine().split("\\s+");

            String word = tokens[0];
            int k = Integer.parseInt(tokens[1]);
            int[] frequency = new int[26];

            for (int i = 0; i < word.length(); i++) {

                frequency[word.charAt(i) - 'a'] = frequency[word.charAt(i) - 'a'] + 1;
            }

            Arrays.sort(frequency);


            int min = 0;
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[i] != 0) {
                    min = frequency[i];
                    break;
                }
            }


            int count = 0;
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[i] - min > k) {
                    count += frequency[i] - min - k;
                }
            }

            System.out.println(count);
        }
    }
}

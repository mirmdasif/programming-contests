package com.mirasif.codeforces.P622C;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author asif.hossain
 * @since 2/14/16
 */
public class P622C {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedOutputStream writer = new BufferedOutputStream(System.out);
     
    public static void main(String[] args) throws IOException {
        String line = reader.readLine();
        int n = Integer.parseInt(line.split("\\s")[0]);
        int m = Integer.parseInt(line.split("\\s")[1]);

        
        String[] numbers = reader.readLine().split("\\s");
        int[] mappings = new int[n + 1];
        
        mappings[1] = 1;
        mappings[0] = -1;
        int leftPos = 1;
        for (int i = 2; i <= n; i++) {
            if (!numbers[i-1].equals(numbers[i-2])) {
                leftPos = i;
            }
            mappings[i] = leftPos;

        }

        for (int i = 1; i <= m; i++) {
            line = reader.readLine();
            int l = Integer.parseInt(line.split("\\s")[0]);
            int r = Integer.parseInt(line.split("\\s")[1]);
            String x = line.split("\\s")[2];

            if (!numbers[r-1].equals(x)) {
                writer.write((r + "\n").getBytes());
            }
            else if (l < mappings[r]) {
                writer.write(((mappings[r] - 1) + "\n").getBytes());
            } 
            else {
                writer.write((-1 + "\n").getBytes());
                
            }
        }
        writer.flush();

    }
}

package net.asifhossain.hackerrank.BirthdayCakeCandles;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BirthdayCakeCandles {

    // Complete the birthdayCakeCandles function below.
    static long birthdayCakeCandles(int[] a) {
        TreeMap<Integer, Long> map = new TreeMap();
        for (int i = 0; i < a.length; i++) {
            
            if (map.get(a[i]) == null) {
                map.put(a[i], 1L);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
            }
            
            
        }
        
       return map.pollLastEntry().getValue();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        long result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
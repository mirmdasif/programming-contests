package com.mirasif.codeforces.P622C;


import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 2/14/16
 */
public class P622C {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] numbers = new int[n + 1];
        int[] mappings = new int[n + 1];
        
        numbers[0] = -1;
        mappings[0] = -1;
        int leftPos = 0;
        for (int i = 1; i <= n; i++) {
            numbers[i] = sc.nextInt();
            if (numbers[i] != numbers[i-1]) {
                leftPos = i;
            }
            mappings[i] = leftPos;
        }
        for (int i = 1; i <= m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            
            if (numbers[r] != x) {
                System.out.println(r);
            }
            else if (l < mappings[r]) {
                System.out.println(mappings[r] - 1);
            } 
            else {
                System.out.println(-1);
                
            }
            
        }

    }
}

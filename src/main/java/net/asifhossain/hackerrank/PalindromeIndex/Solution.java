package net.asifhossain.hackerrank.PalindromeIndex;

import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 1/25/17.
 */
public class Solution {

    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0;  i < n; i++) {
            String str = sc.nextLine();
            solve(str);
        }
    }

    private static void solve(String str) {
        int j = 0;
        int k = str.length() - 1;
        for( ; j < k ;) {
            if(str.charAt(j) == str.charAt(k)) {
                j++;
                k--;
            } else {
                if (isPalindrome(str, j + 1, k)) {
                    System.out.println(j);
                    return;
                } else if (isPalindrome(str, j, k - 1)) {
                    System.out.println(k);
                    return;
                }
                break;
            }
        }

        System.out.println(-1);
    }

    private static boolean isPalindrome(String str, int j, int k) {
        boolean isPalindrome = true;
        while (j < k) {
            if (str.charAt(j) == str.charAt(k)) {
                j++;
                k--;
            } else {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}

package com.mirasif.codeforces.P550C;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 3/1/15
 */
public class DivisibilityByEight {

    String numberString;

    private void parseInput() {
        Scanner sc = new Scanner(System.in);
        numberString = sc.nextLine();
    }

    private void solve() {
//        bfs(numberString);
        
//      for (int i = 1; i <= numberString.length(); i++) {
//          dfs(numberString,i);
//      }

        iterativeSolution(numberString);
    }
    
    void iterativeSolution(String str) {
        for (int i = 0; i < str.length(); i++) {
//            if ( str.charAt(i) == '0') {
//                continue;
//            }
            String str1 = str.charAt(i)+"";
            for (int j = 0; j < str.length(); j++) {
                String str2 = new String(str1);
                if (j != i) {
                    str2 += str.charAt(j);
                }
                for (int k = 0; k < str.length(); k++) {
                    String str3 = new String(str2);
                    if ( k != j && k != i) {
                        str3 += str.charAt(k);
                    }
//                    System.out.println(str3);
                    if (checkDivisibility(str3)) {
                        System.out.println("YES");
                        System.out.println(str3);
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
    }
    
    void dfs(String str, int depth) {
        //Time limit exceeded :(
        if (str.length() == 0 || depth == -1 ) {
            return;
        }
        
        str = trimLeadingZeros(str);
        if (checkDivisibility(str)) {
            System.out.println("YES");
            System.out.println(str);
            System.exit(0);
        }
        
        for (int i = 0; i < str.length() -1; i++) {
            dfs(slice(str,i), depth-1);
        }
    }

    void bfs(String input) {
        // Memory Limit exceeded :(
        Queue<String> queue = new ArrayDeque<String>();
        queue.add(input);
        
        while (!queue.isEmpty()) {
            String str = queue.remove();
            str = trimLeadingZeros(str);
            if (checkDivisibility(str)) {
                System.out.println("YES");
                System.out.println(str);
                return;
            }
            for (int i = 0; i < str.length() - 1; i++) {
                queue.add(slice(str,i));
            }
        }
        System.out.println("NO");
    }

    String slice (String str , int i) {
        String strFirstPart = str.substring(0, i);
        String secondPart = str.substring((i + 1));
        return strFirstPart.concat(secondPart);
    }
    String trimLeadingZeros(String str) {
        int i = 0;
        for (; i < str.length() - 1 && str.charAt(i) == '0'; i++) ;
        return str.substring(i);
    }

    boolean checkDivisibility(String str) {

        if (str.length() >= 3) {
            str = str.substring(str.length() - 3);
        }

        if ((Integer.parseInt(str)) % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void printOutPut() {
    }

    public static void main(String args[]) {
        
        
        DivisibilityByEight main = new DivisibilityByEight();
        main.parseInput();
        main.solve();
        main.printOutPut();

    }
}

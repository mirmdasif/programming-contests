package com.mirasif.codeforces.P550C;

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
        
    }
    
    void bfs(String number) {
        if ()
    }
    
    boolean checkDivisibility (String str) {

        if (str.length()>= 3) {

            if (Integer.parseInt(str.substring(str.length() -3, str.length() -1))%8 == 0) {
                return true;
            }
        }
        if (str.length()== 2) {
            if (Integer.parseInt(str.substring(str.length() -2, str.length() -1))%8 == 0) {
                return true;
            }
        }

        if (str.length()== 1) {
            if (Integer.parseInt(str)%8 == 0) {
                return true;
            }
        }
        return false;
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

package net.asifhossain.codeforces.P625A;

import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 3/1/15
 */
public class P625A {

//    ax + by = c
//    maximize s = x + y
    
    int a, b, c, s;
    private void parseInput() {
       Scanner sc =new Scanner(System.in);
       c = sc.nextInt();
       a = sc.nextInt();
       b = sc.nextInt() - sc.nextInt();
    }

    private void solve() {
        int xMax = c/a;

        for (int x = 0; x <= xMax; x++) {
            int y = (c-a*x)/b;
            s = Math.max(s, x+y);
        }
    }

    private void printOutPut() {
        System.out.println(s);
    }

    public static void main(String args[]) {
        P625A main = new P625A();
        
        main.parseInput();
        main.solve();
        main.printOutPut();


    }
}

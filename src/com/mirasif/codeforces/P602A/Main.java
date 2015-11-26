package com.mirasif.codeforces.P602A;


import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 3/1/15
 */
public class Main {

    private void parseInput() {
    }

    private void solve() {
    }

    private void printOutPut() {
    }

    public static void main(String args[]) {
        Main main = new Main();
        
        main.parseInput();
        main.solve();
        main.printOutPut();

        Scanner sc = new Scanner(System.in);
        
        int numberOfDigitsX = sc.nextInt();
        int baseX = sc.nextInt();
        long numberX = 0;
        for (int i = 0; i < numberOfDigitsX; i++) {
            numberX += sc.nextInt()*Math.pow(baseX, numberOfDigitsX -i -1);
        }


        int numberOfDigitsY = sc.nextInt();
        int baseY = sc.nextInt();
        long numberY = 0;
        for (int i = 0; i < numberOfDigitsY; i++) {
            numberY += sc.nextInt()*Math.pow(baseY, numberOfDigitsY -i -1);
        }
        
        if (numberX == numberY) {
            System.out.println("=");
        }


        if (numberX < numberY) {
            System.out.println("<");
        }


        if (numberX > numberY) {
            System.out.println(">");
        }

    }
}

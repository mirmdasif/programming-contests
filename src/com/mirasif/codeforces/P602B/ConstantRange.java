package com.mirasif.codeforces.P602B;

import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 3/1/15
 */
public class ConstantRange {

    private static final Scanner sc = new Scanner(System.in);

    int n;
    int[] numbers;
    int maxLenght;
    private void parseInput() {
        n = sc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
    }

    private int solve() {
        if (n == 1) {
            return 1;
        }
        maxLenght = 2;
        int lastIndex = 0;
        int diff = numbers[0] -numbers[1];
        int j = 2;
        for (; j < n; j++) {
            if (numbers[j-1] - numbers[j] == 0) {
                continue;
            }
            if (diff != 0 && (numbers[j-1] - numbers[j])*-1 != diff) {
                if (maxLenght < j - lastIndex) {
                    maxLenght = j - lastIndex;
                }
                lastIndex ++;
            }
            diff = numbers[j-1] - numbers[j];
        }
        
        if (j -lastIndex > maxLenght) {
            maxLenght = j -lastIndex;
        }
        
        return maxLenght;
    }

    private void printOutPut() {
        System.out.println(maxLenght);
    }

    public static void main(String args[]) {
        ConstantRange main = new ConstantRange();

        main.parseInput();
        main.maxLenght = main.solve();
        main.printOutPut();

    }
}
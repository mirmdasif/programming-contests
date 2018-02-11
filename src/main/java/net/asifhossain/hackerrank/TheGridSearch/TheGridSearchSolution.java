package net.asifhossain.hackerrank.TheGridSearch;

import java.util.Scanner;

public class TheGridSearchSolution {
    public boolean containsPattern(int[][] grid, int[][] pattern) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (boundaryCheck(grid, i, j, pattern)) {
                    if(containsPattern(grid, i, j, pattern)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean boundaryCheck(int[][] grid, int i, int j, int[][] pattern) {
        return i + pattern.length - 1 < grid.length && j + pattern[0].length - 1 < grid[i].length;
    }

    private boolean containsPattern(int[][] grid, int i, int j, int[][] pattern) {

        for (int m = 0; m < pattern.length; m++) {
            for (int n = 0; n < pattern[m].length; n++) {
                if (grid[i + m][j + n] != pattern[m][n]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TheGridSearchSolution solution = new TheGridSearchSolution();
        Scanner sc = new Scanner(System.in);
        int noOfTestCase = Integer.parseInt(sc.nextLine());

        while (noOfTestCase-- > 0) {
            String[] s = sc.nextLine().split(" ");
            int gridI = Integer.parseInt(s[0]);
            int gridJ = Integer.parseInt(s[1]);
            int[][] grid = readArrayInput(gridI, gridJ, sc);

            s = sc.nextLine().split(" ");
            int patternI = Integer.parseInt(s[0]);
            int patternJ = Integer.parseInt(s[1]);

            int[][] pattern = readArrayInput(patternI, patternJ, sc);

            if (solution.containsPattern(grid, pattern)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static int[][] readArrayInput(int gridI, int gridJ, Scanner sc) {
        int[][] grid = new int[gridI][gridJ];
        for (int i = 0; i < gridI; i++) {
            String n = sc.nextLine();
            for(int j = 0; j < gridJ; j++) {
                grid[i][j] = Integer.parseInt(n.charAt(j)+"");

            }
        }

        return grid;
    }
}

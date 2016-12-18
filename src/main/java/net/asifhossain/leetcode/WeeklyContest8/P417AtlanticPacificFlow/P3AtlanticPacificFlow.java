package net.asifhossain.leetcode.WeeklyContest8.P417AtlanticPacificFlow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author asif.hossain
 * @since 10/10/16.
 */
public class P3AtlanticPacificFlow {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point p = (Point) obj;
                return p.x == x && p.y == y;
            }

            return false;
        }

        @Override
        public String toString() {
            return "x=" + x + ", y=" + y;
        }
    }
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix.length == 0) {
            return new ArrayList<>();
        }
        int[][] pacific = new int[matrix.length][matrix[0].length];
        int[][] atlantic = new int[matrix.length][matrix[0].length];

        Queue<Point> q = new ArrayDeque<>();

        for (int i = 0; i < matrix.length; i++) {
            q.add(new Point(i, 0));
        }

        for (int i = 1; i < matrix[0].length; i++) {
            q.add(new Point(0, i));
        }

        explore(matrix, q, pacific);

        q = new ArrayDeque<>();

        for (int i = 0; i < matrix.length; i++) {
            q.add(new Point(i, matrix[0].length - 1));
        }

        for (int i = 0;  i < matrix[0].length; i++) {
            q.add(new Point(matrix.length - 1, i));
        }

        explore(matrix, q, atlantic);

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    System.out.println(new Point(i, j));
                    int[] point  = new int[2];
                    point[0] = i;
                    point[1] = j;
                    list.add(point);
                }
            }
        }

        return list;
    }

    private  void explore(int[][] mat, Queue<Point> q, int[][] sea) {

        int [][] explored = new int[mat.length][mat[0].length];

        while (!q.isEmpty()) {
            Point p = q.poll();
            sea[p.x][p.y] = 1;

            explored[p.x][p.y] = 1;

            // explore up
            if (p.x - 1 >= 0 && explored[p.x - 1][p.y] != 1 && mat[p.x - 1][p.y] >= mat[p.x][p.y]) {
                q.add(new Point(p.x - 1, p.y));
            }

            // explore down
            if (p.x + 1 < mat.length && explored[p.x + 1][p.y] != 1 && mat[p.x + 1][p.y] >= mat[p.x][p.y]) {
                q.add(new Point(p.x + 1, p.y));
            }

            // explore left
            if (p.y - 1 >= 0 && explored[p.x][p.y - 1] != 1 && mat[p.x][p.y - 1] >= mat[p.x][p.y]) {
                q.add(new Point(p.x, p.y - 1));
            }

            // explore right
            if (p.y + 1 < mat[0].length && explored[p.x][p.y + 1] != 1 && mat[p.x][p.y + 1] >= mat[p.x][p.y]) {
                q.add(new Point(p.x, p.y + 1));
            }
        }
    }
}

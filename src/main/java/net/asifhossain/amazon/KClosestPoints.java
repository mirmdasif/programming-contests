package net.asifhossain.amazon;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 10/26/17.
 */
public class KClosestPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        PriorityQueue<Point> q = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            q.add(new Point(sc.nextInt(), sc.nextInt()));
        }

//        q.iterator().forEachRemaining(System.out::println);

        for (int i = k; i < n; i++) {
            Point p = new Point(sc.nextInt(), sc.nextInt());
            if (q.peek().compareTo(p) < 0) {
                q.poll();
                q.add(p);
            }
        }

        q.iterator().forEachRemaining(System.out::println);
    }

    static class Point implements Comparable {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object that) {
            return -distanceFormOrigin(this) + distanceFormOrigin((Point) that);
        }

        private int distanceFormOrigin(Point p) {
            return p.x * p.x + p.y * p.y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

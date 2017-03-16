package net.asifhossain.hackerrank.WeekOfCode29.CircleAndSquare;

import java.util.Scanner;
/**
 * @author sadasidha
 * @since 2/25/17.
 */
public class CircleAndSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        int circleX = in.nextInt();
        int circleY = in.nextInt();
        int r = in.nextInt();

        double x1 = in.nextInt();
        double y1 = in.nextInt();
        double x3 = in.nextInt();
        double y3 = in.nextInt();

        Circle c = new Circle(new Point(circleX, circleY), r);

        Point A = new Point(x1, y1);
        Point C = new Point(x3, y3);
        if (x1 > x3) {
            Point.swap(A, C);
        }

        Point B = getB(A, C);

        Rectangle ABCD = new Rectangle(A, B, C);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                Point M = new Point(x, y);
                if (ABCD.isInside(M) || c.isInside(M)) {
                    System.out.print("#");
                } else System.out.print(".");
            }

            System.out.println();
        }
    }

    public static Point getB(Point A, Point C) {
        double cx = (A.x + C.x) / 2;
        double cy = (A.y + C.y) / 2;

        double xd = (A.x - C.x) / 2;
        double yd = (A.y - C.y) / 2;

        return new Point(cx - yd, cy + xd);
    }
}

class Circle {
    Point C;
    int r;

    public Circle(Point c, int r) {
        C = c;
        this.r = r;
    }

    boolean isInside(Point P) {
        return Math.pow(P.x - C.x, 2) + Math.pow(P.y - C.y, 2) <= r * r;
    }
}
class Rectangle {
    Point A, B, C;

    public Rectangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public boolean isInside(Point M) {
        Vector AB = new Vector(A, B);
        Vector BC = new Vector(B, C);
        Vector AM = new Vector(A, M);
        Vector BM = new Vector(B, M);

        return 0 <= Vector.dot(AB, AM) && Vector.dot(AB, AM) <= Vector.dot(AB, AB)
                && 0 <= Vector.dot(BC,BM) && Vector.dot(BC,BM) <= Vector.dot(BC, BC);
    }
}
class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static void swap(Point A, Point B) {
        Point temp = new Point(A.x, A.y);
        A.x = B.x;
        A.y = B.y;
        B.x = temp.x;
        B.y = temp.y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Vector {
    double x;
    double y;

    public Vector(Point A, Point B) {
        this.x = B.x - A.x;
        this.y = B.y - A.y;
    }

    public static double dot(Vector u, Vector v) {
        return u.x * v.x + u.y * v.y;
    }
}

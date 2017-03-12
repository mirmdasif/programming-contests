package net.asifhossain.hackerrank.WeekOfCode29.DistanceToPie;
import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 2/26/17.
 */
public class DistanceToPi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long min = in.nextLong();
        long max = in.nextLong();

        double diff = Double.MAX_VALUE;
        double nx = 0;
        long dx = 0;
        for (long d = min; d <= max; d++) {
            double n = (long) Math.floor(Math.PI * d);


            double dif = Math.abs(Math.PI - n / d);
            if ( dif < diff) {
                nx = n;
                dx = d;
                diff = dif;
            }

            n = (long) Math.ceil(Math.PI * d);

            dif = Math.abs(Math.PI - n / d);

            if ( dif < diff) {
                nx = n;
                dx = d;
                diff = dif;
            }

        }

        System.out.println((long)nx + "/" + dx);
    }
}

package net.asifhossain.hackerrank.WeekOfCode30;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 3/15/17.
 */
public class MelodiousPassword {

    static char[] vowles = {'a', 'e', 'i', 'o', 'u'};
    static char[] consonents = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w' , 'x', 'z'};

    static BufferedOutputStream br = new BufferedOutputStream(System.out);

    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] str = new char[n];
        gen(str, 0, true, n);
        gen(str, 0, false, n);
        br.flush();
    }

    public static void gen(char[] str, int pos, boolean vowel, int n) throws IOException {
        if(pos == n) {
           br.write((new String(str) + "\n").getBytes());
            return;
        }

        if (vowel) {
            for (int i = 0; i < vowles.length; i++) {
                str [pos] = vowles[i];
                gen(str, pos + 1, false, n);
            }
        } else {
            for (int i = 0; i < consonents.length; i++) {
                str [pos] = consonents[i];
                gen(str, pos + 1, true, n);
            }
        }
    }
}

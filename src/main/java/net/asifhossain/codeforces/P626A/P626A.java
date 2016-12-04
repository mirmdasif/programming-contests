package net.asifhossain.codeforces.P626A;

import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 2/29/16
 */
public class P626A {
    static boolean returned(char[] chars) {
        int countU = 0;
        int countR = 0;
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'U') {
                countU++;
            }
            if (chars[i] == 'D') {
                countU--;
            }
            if (chars[i] == 'L') {
                countR++;
            }
            if (chars[i] == 'R') {
                countR--;
            }
        }
        return (countR == 0) && (countU == 0);
    }
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String str = scanner.nextLine();
        int count = 0;
        for (int i = 2; i <= str.length(); i++) {
            for (int j = 0; j <= str.length() - i; j++) {
                if (returned(str.substring(j, j + i).toCharArray())) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

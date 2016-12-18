package net.asifhossain.leetcode.WeeklyContest8.P415AddStrings;

/**
 * @author asif.hossain
 * @since 10/10/16.
 */
public class P1AddStrings {

    int getValue(String str, int index) {
        if(index >=  str.length() || index < 0) {
            return 0;
        }

        return str.charAt(index) - '0';
    }
    public String addStrings(String num1, String num2) {
        int iN1 = num1.length() - 1;
        int iN2 = num2.length() - 1;

        String sum = "";
        int rem = 0;

        while (iN1 >= 0 || iN2 >=0) {
            int temp = getValue(num1, iN1) + getValue(num2, iN2) + rem;
            sum = temp % 10 + sum;
            rem = temp / 10;
            iN1--;
            iN2--;
        }

        if(rem > 0) {
            sum = rem + sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        P1AddStrings p1AddStrings = new P1AddStrings();
        System.out.println(p1AddStrings.addStrings("11", "99"));
    }
}

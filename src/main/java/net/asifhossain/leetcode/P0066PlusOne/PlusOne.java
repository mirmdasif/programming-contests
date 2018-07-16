package net.asifhossain.leetcode.P0066PlusOne;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int remaider = 1;
        int[] sum = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmpRemainder = (digits[i] + remaider) / 10;
            digits[i] = (digits[i] + remaider) % 10;
            sum[i + 1] = digits[i];
            remaider = tmpRemainder;
        }

        if (remaider == 0) return digits;

        sum[0] = remaider;

        return sum;
    }
}

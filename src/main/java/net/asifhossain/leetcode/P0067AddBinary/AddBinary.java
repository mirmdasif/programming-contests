package net.asifhossain.leetcode.P0067AddBinary;

public class AddBinary {

    public String addBinary(String a, String b) {
        char r = '0';
        String sum = "";
        for(int i = a.length() - 1, j = b.length() - 1; i >=0 || j >= 0; i--, j-- ) {
            char xa = i >= 0 ? a.charAt(i) : '0';
            char xb = j >= 0 ? b.charAt(j) : '0';
             sum = add(xa, xb, r) + sum;
             r = remainder(xa, xb, r);
        }

        if(r == '1') {
            sum = r + sum;
        }

        return sum;
    }

    private char add(char a, char b, char r) {
        int count = 0;
        if (a == '1') count++;
        if (b == '1') count++;
        if (r == '1') count++;

        if (count == 1 || count == 3) return '1';
        return '0';
    }

    private char remainder(char a, char b, char r) {
        int count = 0;
        if (a == '1') count++;
        if (b == '1') count++;
        if (r == '1') count++;

        if (count == 2 || count == 3) return '1';
        return '0';
    }
}

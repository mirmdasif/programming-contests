package net.asifhossain.leetcode.P0038CountAndSay;

public class CountAndSay {
    public String countAndSay(int n) {
        String say = "1";
        int index = 1;
        while (index < n) {
            String tempSay = "";
            char[] chars = say.toCharArray();
            char ch =  chars[0];
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != ch) {
                    tempSay += count + "";
                    tempSay += ch;
                    ch = chars[i];
                    count = 1;
                } else {
                    count++;
                }
            }

            tempSay += count;
            tempSay += ch;
            say = tempSay;
            index++;
        }

        return say;
    }
}

package net.asifhossain.leetcode.P0020ValidParenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> opposite = new HashMap<>();
        opposite.put(')', '(');
        opposite.put('}', '{');
        opposite.put(']', '[');

        for (char c : s.toCharArray()) {
            if (isStartingParen(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !opposite.get(c).equals(stack.pop())) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isStartingParen(char ch) {
        if (ch == '(' || ch == '{' || ch == '[') {
            return true;
        }

        return false;
    }


}

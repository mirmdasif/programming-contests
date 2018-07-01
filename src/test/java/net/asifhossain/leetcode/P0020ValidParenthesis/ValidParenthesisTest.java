package net.asifhossain.leetcode.P0020ValidParenthesis;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesisTest {

    ValidParenthesis validParenthesis = new ValidParenthesis();

    @Test
    public void isValid() {
        Assert.assertEquals(true, validParenthesis.isValid("{()}"));
        Assert.assertEquals(false, validParenthesis.isValid("([)]"));
        Assert.assertEquals(true, validParenthesis.isValid("()[]{}"));
    }
}
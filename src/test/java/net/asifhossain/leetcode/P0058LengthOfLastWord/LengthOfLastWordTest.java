package net.asifhossain.leetcode.P0058LengthOfLastWord;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthOfLastWordTest {

    private LengthOfLastWord lastWord = new LengthOfLastWord();

    @Test
    public void testLengtjOfLastWord() {

        assertEquals(5, lastWord.lengthOfLastWord("Hello World"));
    }
}
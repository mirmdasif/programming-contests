package net.asifhossain.leetcode.P0125ValidPalindrome

class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1

        while (i < j) {
            while (i < s.length - 1 && !s[i++].isLetterOrDigit()) {}

            while (j > 0 && !s[j--].isLetterOrDigit()) {}


            if (i >= j) {
                return true
            }

            if (!s[i].equals(s[j], true) ) {
                return false
            }

        }

        return true
    }
}

fun main() {
    println(Solution().isPalindrome("A man, a plan, a canal: Panama"))
}
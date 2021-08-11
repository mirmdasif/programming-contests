package net.asifhossain.leetcode.P0118PascalTriangle;

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val pascal = mutableListOf<List<Int>>()

        for (i in 1..numRows) {
            val row = mutableListOf<Int>();
            for (j in 0..i-1) {
                if (j == 0 || j == i -1) {
                    row.add(1)
                } else {
                    row.add(pascal[i -2][j - 1] + pascal[i -2][j])
                }
            }
            pascal.add(row)
        }

        return pascal
    }
}
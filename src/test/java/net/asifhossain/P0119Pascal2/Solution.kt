package net.asifhossain.P0119Pascal2

class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        var lastRow = mutableListOf<Int>()
        for (i in 1..rowIndex+1) {
            val currentRow = mutableListOf<Int>()
            for (j in 0..i-1) {
                if(j == 0 || j == i-1) {
                    currentRow.add(1)
                } else {
                    currentRow.add(lastRow[j -1] + lastRow[j])   
                }
            }
            
            lastRow = currentRow
        }
        
        return lastRow
        
    }
}
package net.asifhossain.leetcode.P121Stocks;

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0;
        var min = prices[0]
        for (i in 1 until prices.size) {
            if (prices[i] - min > profit) {
                profit = prices[i] - min
            }
            
            if (prices[i] < min) {
                min = prices[i]
            }
        }
        
        return profit
    }
}
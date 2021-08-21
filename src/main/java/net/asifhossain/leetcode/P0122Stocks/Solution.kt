class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buy = prices[0]
        var sell = prices[0]
        var total = 0
        
        var i = 1
        while(i < prices.size) {
            if(prices[i] < sell) {
                total += sell - buy
                sell = prices[i]
                buy = prices[i]
            } else {
                sell = prices[i]
            }
            
            i++
        }
        
        total += sell - buy
        
        return total
    }
}

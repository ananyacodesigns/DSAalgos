/*
BEST TIME TO BUY AND SELL STOCK

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

*/
class Solution {
    public int maxProfit(int[] prices) {
        //find miinimum value before he selling day
        //minsofar updates with new mins
        //time complexity: O(n) because of the loop
        int minSoFar = prices[0];
        int ans = 0;

        for(int i=0; i<prices.length; i++){
            int profit = prices[i] - minSoFar;
            if(profit > ans){
                ans=profit; //desired
            }
            else{
                minSoFar = Math.min(prices[i],minSoFar); //making conditions that will favour us
            }
     

        }
        return ans;
    }
    
}

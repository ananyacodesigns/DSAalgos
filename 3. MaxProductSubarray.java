/*
MAXIMUM PRODUCT SUBARRAY
Given an integer array nums, find a
subarray
that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.


*/
class Solution {
    public int maxProduct(int[] nums) {
        //negative's product is positive
        //checking edge cases:
        if(nums == null || nums.length ==0){
            return 0;
        }
        int maxp = nums[0];
        int minp = nums[0];
        int result = nums[0];

        for(int i=1; i <nums.length; i++){
            if(nums[i]>=0){
                maxp = Math.max(nums[i],maxp*nums[i]); //need to compare with the current number too because it might be greater than the current max
                minp = Math.min(nums[i],minp*nums[i]);
            }
            else{
                int temp = maxp;
                maxp = Math.max(nums[i],minp*nums[i]);
                minp = Math.min(nums[i],temp*nums[i]);
            }
            result = Math.max(minp, maxp);
        }
        return result;
    }
}

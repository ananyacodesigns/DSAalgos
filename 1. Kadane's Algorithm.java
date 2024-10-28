//Kadane's algorithm for Given an integer array nums, find the subarray with the largest sum, and return its sum

class Solution {
    public int maxSubArray(int[] nums) {
        int n= nums.length;
        int i, sum =nums[0], cursum= nums[0];
        for(i=1; i<n; i++){
            if(cursum<0){
                cursum = 0;
            }
            cursum = cursum + nums[i];
            if(cursum>sum){
                sum = cursum;
            }
        }
        return sum;
        }
    }

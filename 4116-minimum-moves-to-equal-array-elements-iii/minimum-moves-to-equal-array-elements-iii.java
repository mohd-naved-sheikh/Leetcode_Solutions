class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int mid = 0 + (nums.length-1);
        int median = nums[mid];
        int ans =0;
      
          for(int n:nums){
             if(n>median){
                ans+=n-median;
             }
             if(median>n){
                ans+=median-n;
             }
          }     

           return ans;
            }
}
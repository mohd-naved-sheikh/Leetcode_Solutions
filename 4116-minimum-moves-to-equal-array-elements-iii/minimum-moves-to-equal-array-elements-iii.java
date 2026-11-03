class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int maxVal = nums[nums.length - 1];
        int ans = 0;
        
        for (int n : nums) {
            ans += maxVal - n;
        }    
        
        return ans;
    }
}
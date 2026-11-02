class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = (0 + nums.length-1)/2;
        int median = nums[mid];
        int operation =0;
        for(int n : nums){
            if(n>median){
                operation += n-median;
            }
            if(median>n){
                operation +=median-n;
            }
        }
        return operation;
    }
}
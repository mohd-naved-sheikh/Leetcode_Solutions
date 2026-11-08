class Solution {
    public int[] twoSum(int[] nums, int target) {
       if(nums.length<=0) return new int[2];

        Map <Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int reminder = target - nums[i];
            if(m.containsKey(reminder)){
                return new int [] {i,m.get(reminder)};
            }
            m.put(nums[i],i);
        }
        return new int [2];
    }
}
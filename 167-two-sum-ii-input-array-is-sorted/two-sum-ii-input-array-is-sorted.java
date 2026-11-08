class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length<=0) return new int [2];

        Map <Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int reminder =target - numbers[i];
            if(map.containsKey(reminder)){
                return new int [] {map.get(reminder)+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return new int [2];
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                
                int firstIdx = map.get(complement); 
                int secondIdx = i; 

                return new int[] {firstIdx, secondIdx};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}

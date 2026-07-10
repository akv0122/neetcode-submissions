class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        
        for (int i = 0; i < length; i++) {
            int mult = 1;
            for (int j = 0; j < length; j++) {
                if (i == j)
                    continue;
                mult *= nums[j];
            }

            result[i] = mult;
        }

        return result; 
    }
}

class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length; 

        int leftProduct = 1, rightProduct = 1, result = nums[0]; 

        for(int i = 0; i < n; i++){
            leftProduct = leftProduct == 0 ? 1 : leftProduct; 
            rightProduct = rightProduct == 0 ? 1 : rightProduct; 

            leftProduct *= nums[i]; 
            rightProduct *= nums[n - 1 - i]; 

            result = Math.max(result, Math.max(leftProduct, rightProduct)); 
        }

        return result; 
        
        
    }
}

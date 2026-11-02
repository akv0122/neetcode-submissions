class Solution {
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums); 
        
        if(nums.length == 0) return 0;
        if( k > nums.length) return 0;  

        return nums[nums.length - k]; 
        
    }
}

class Solution {
    public int trap(int[] height) {

        int left = 0; 
        int right = height.length - 1; 

        int lMax = 0; 
        int rMax = 0; 

        int totalWater = 0; 
        
        while(left <= right){

            lMax = Math.max(lMax, height[left]); 
            rMax = Math.max(rMax, height[right]);

            if(lMax < rMax){
                totalWater += lMax - height[left]; 
                left++; 
            } else{
                totalWater += rMax - height[right]; 
                right--; 
            }
        }
        return totalWater; 
        
    }
}

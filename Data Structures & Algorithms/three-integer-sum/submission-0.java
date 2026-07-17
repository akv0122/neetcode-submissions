class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>(); 

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){

                    int sum = nums[i] + nums[j]+ nums[k]; 
                    if(sum == 0){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]); 
                        Collections.sort(triplet); 
                        set.add(triplet); 
                    }
                }
            }
        }

        return new ArrayList<>(set); 
        
    }
}

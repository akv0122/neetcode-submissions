class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(); 
        backTrack(nums, temp, 0, result);
        return result; 
    }

    public void backTrack(int[] nums, List<Integer> temp , int i, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(temp)); 
            return;
        }

        // include
        temp.add(nums[i]);
        backTrack(nums, temp, i + 1, result);


        //backtrack
        temp.remove(temp.size() - 1); 


        //exclude
        backTrack(nums, temp, i + 1, result);
    }
}

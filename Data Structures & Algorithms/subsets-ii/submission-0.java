class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempArray = new ArrayList<>();

        helper(nums, 0, tempArray, result);
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> tempArr, List<List<Integer>> result) {
        // valid case
        if (index == nums.length) {
            result.add(new ArrayList<>(tempArr));
            return;
        }

        tempArr.add(nums[index]);

        // include
        helper(nums, index + 1, tempArr, result);

        // backtrack
        tempArr.remove(tempArr.size() - 1);

        while(index + 1 < nums.length && nums[index] == nums[index + 1]) index++; 
        
        // exclude
        helper(nums, index + 1, tempArr, result);
    }
}

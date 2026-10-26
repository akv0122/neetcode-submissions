class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, temp, 0, result);
        return result;
    }

    public void helper(int[] nums, List<Integer> temp, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // include
        temp.add(nums[i]);
        helper(nums, temp, i + 1, result);

        // backtrack
        temp.remove(temp.size() - 1);

        // exclude
        helper(nums, temp, i + 1, result);
    }
}

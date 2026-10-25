class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, target, 0, result, new ArrayList<>());

        return result;
    }

    private void helper(
        int[] nums, int target, int index, List<List<Integer>> result, List<Integer> current) {
        // found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // base cases
        if (index == nums.length || target < 0) {
            return;
        }

        // inclusive
        current.add(nums[index]);
        helper(nums, target - nums[index], index, result, current);

        // backtracking step : remove last item
        current.remove(current.size() - 1);

        // exclusive
        helper(nums, target, index + 1, result, current);
    }
}

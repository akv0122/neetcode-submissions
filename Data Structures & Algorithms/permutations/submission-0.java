class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, new ArrayList<>(), result);
        return result;
    }

    public void helper(int[] nums, List<Integer> tempArr, List<List<Integer>> result) {
        if (tempArr.size() == nums.length) {
            result.add(new ArrayList<>(tempArr));
            return;
        }

        // if( index == nums.length) return;

        for (int num : nums) {
            if (tempArr.contains(num))
                continue;

            tempArr.add(num);

            // include
            helper(nums, tempArr, result);

            // backtrack
            tempArr.remove(tempArr.size() - 1);
        }
    }
}

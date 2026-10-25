class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempArray = new ArrayList<>();

        helper(candidates, target, 0, tempArray, result);

        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> tempArray, List<List<Integer>> result){

        //found a valid 
        if(target == 0){
            result.add(new ArrayList<>(tempArray)); 
            return; 
        }

        //invalid options
        if( index == candidates.length || target < 0) return; 



        tempArray.add(candidates[index]); 

        //inclusion
        helper(candidates, target - candidates[index], index + 1, tempArray, result); 

        //backtracking
        tempArray.remove(tempArray.size() - 1); 



        //exclusion

        int next = index +1; 

        while( next < candidates.length && candidates[index] == candidates[next]) next++; 


        helper(candidates, target, next, tempArray, result);
    }
}

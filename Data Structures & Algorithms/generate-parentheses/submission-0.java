class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // StringBuilder sb = new StringBuilder();
        helper(n, result, 0, 0, "");
        return result;
    }

    private void helper( int n, List<String> result, int open, int close, String s) {
        
        //base case
        if(s.length() == (2*n)){
            result.add(s); 
            return; 
        }

        if( open < n){
            helper(n, result, open+1, close, s+ "("); 
        }

        if(open > close){
            helper(n, result, open, close + 1, s + ")");
        }
        
    }
}

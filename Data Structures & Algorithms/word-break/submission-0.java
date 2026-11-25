class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length(); 
        
        Set<String> set = new HashSet<>(wordDict);
        
        
        

        boolean[] dp = new boolean[n + 1];

        //base case : empty string is valid
        dp[0] = true;

        //logic : i ending index and j starting index
        for (int i = 1; i < n + 1; i++) {
            for( int j = 0;  j <= i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true; 
                    break; 
                }
            }
        }

        return dp[n]; 
    }
}

class Solution {
    public int countSubstrings(String s) {

        int count = 0; 

        for( int i = 0; i < s.length(); i++){

            //odd and even len check
            int odd = expandAroundCenter(s, i, i); 
            int even = expandAroundCenter(s, i, i+1); 

            count = count + odd + even; 
        }

        return count; 


        
    }

    public int expandAroundCenter(String s, int left, int right){

        int count = 0; 

        while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){

            count++; 

            left--; right++;

        }

        return count; 


    }
}

class Solution {
    public String minWindow(String s, String t) {

        if(t == null || t.length() > s.length()) return ""; 

        Map<Character, Integer> count = new HashMap<>(); 

        for( int i = 0; i < t.length(); i++){
            char ch = t.charAt(i); 
            count.put(ch, count.getOrDefault(ch , 0) + 1);
        }
 
        int n = s.length(); 
        int left = 0, right = 0; 
        int uniqueCount = count.size(); 
        int idx = -1; 
        int minLen = Integer.MAX_VALUE; 

        while(right < n){ //expansion 
            char ch = s.charAt(right); 
            if(count.containsKey(ch)){
                count.put(ch, count.get(ch)- 1); 
                if(count.get(ch) == 0){
                    uniqueCount--; 
                }
            }

            while(uniqueCount == 0){ //shrinking
                int len = right - left + 1; 
                if(len < minLen){
                    minLen= len; 
                    idx = left; 
                }

                ch = s.charAt(left);
                if(count.containsKey(ch)){
                    count.put(ch, count.get(ch)+1); 
                    if(count.get(ch) > 0){
                        uniqueCount++; 
                    }
                }
                left++; 
            }
            right++; 
        }
        
        if(idx == -1) return ""; 
        return s.substring(idx, idx+minLen); 
    }
}

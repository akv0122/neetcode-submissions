class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;

        Map<Character, Integer> lastIdxMap = new HashMap<>();

        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastIdxMap.containsKey(c)) {
                left = Math.max(left, lastIdxMap.get(c) + 1); 
            }

            lastIdxMap.put(c, right); 

            maxLength = Math.max(maxLength, right - left + 1); 
        }

        return maxLength; 
    }
}

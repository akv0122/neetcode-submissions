class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int uniqueCharCount = freqMap.size();
        int windowStart = 0, windowEnd = 0;
        int startIdx = -1;
        int minLen = Integer.MAX_VALUE;
        int n = s.length();

        while (windowEnd < n) {
            // expansion
            char ch = s.charAt(windowEnd);
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) - 1);
                if (freqMap.get(ch) == 0) {
                    uniqueCharCount--;
                }
            }

            // shrinkingPhase
            while (uniqueCharCount == 0) {
                int len = windowEnd - windowStart + 1;
                if (len < minLen) {
                    minLen = len;
                    startIdx = windowStart;
                }

                ch = s.charAt(windowStart);
                if (freqMap.containsKey(ch)) {
                    freqMap.put(ch, freqMap.get(ch) + 1);
                    if (freqMap.get(ch) > 0) {
                        uniqueCharCount++;
                    }
                }
                windowStart++;
            }
            windowEnd++;
        }

        if(startIdx == -1) return ""; 
        return s.substring(startIdx, startIdx + minLen); 
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxFreq = 0;
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;

            maxFreq = Math.max(maxFreq, count[c - 'A']);

            // window size = right - left + 1

            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }
}

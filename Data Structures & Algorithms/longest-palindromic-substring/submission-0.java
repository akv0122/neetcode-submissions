class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCorner(s, i, i); // odd
            int len2 = expandAroundCorner(s, i, i + 1); //

            int len = Math.max(len1, len2);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len-1)/2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    private int expandAroundCorner(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    // private boolean calculatePalin(String s) {
    //     int n = s.length();

    //     int left = 0;
    //     int right = n - 1;

    //     while (left < right) {
    //         if (s.charAt(left) != s.charAt(right)) {
    //             return false;
    //         }

    //         left++;
    //         right--;
    //     }

    //     return true;
    // }
}

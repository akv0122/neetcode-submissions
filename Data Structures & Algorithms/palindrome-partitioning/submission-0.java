class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        calcuatePalindromeParts(s, result, new ArrayList<>());
        return result;
    }

    private void calcuatePalindromeParts(
        String s, List<List<String>> result, List<String> partitions) {
        // base case
        if (s.isEmpty()) {
            result.add(new ArrayList<>(partitions));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String part = s.substring(0, i + 1);

            if (isPalindrome(part)) {
                partitions.add(part);
                calcuatePalindromeParts(s.substring(i + 1), result, partitions);

                // backtracing
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        String s2 = new StringBuilder(s).reverse().toString();

        return s.equals(s2);
    }
}

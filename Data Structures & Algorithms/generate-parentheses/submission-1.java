class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, result, 0, 0, sb);
        return result;
    }

    private void helper(int n, List<String> result, int open, int close, StringBuilder sb) {
        // base case
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        // open brackets
        if (open < n) {
            sb.append('(');
            helper(n, result, open + 1, close, sb);

            // backTracking
            sb.deleteCharAt(sb.length() - 1);
        }

        // closing brackets
        if (open > close) {
            sb.append(')');
            helper(n, result, open, close + 1, sb);

            // backtracking
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

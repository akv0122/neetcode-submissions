class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty() || s == null)
            return false;
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                // closing bracket condition
                if (stack.peek() == '{' && ch == '}' || stack.peek() == '(' && ch == ')'
                    || stack.peek() == '[' && ch == ']') {
                    stack.pop();
                } else
                    return false;
            }
        }

        return stack.isEmpty(); 

    }
}

class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[t.length];

        for (int i = 0; i < t.length; i++) {
            while (!stack.isEmpty() && t[i] > t[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);
        }

        return result;
    }
}

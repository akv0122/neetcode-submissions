class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0; 

        // first window
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        for (int i = k; i < nums.length; i++) {
            
             // before starting new window - adding the result of
                                              // the old window
            result[resultIndex] = nums[dq.peekFirst()];
            resultIndex++; 

            // remove elements which are not part of the current window
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            // remove the smaller values from the end which is smaller then the current element
            while (dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        result[resultIndex] = nums[dq.peekFirst()]; 
        return result; 
    }
    
    
}

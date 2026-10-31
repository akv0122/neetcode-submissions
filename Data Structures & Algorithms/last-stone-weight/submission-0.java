class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            // get the two heaviest stones
            int y = pq.remove();
            int x = pq.remove();

            if (x != y) {
                pq.add(y - x);
            }
        }

        if( pq.isEmpty()) return 0; 

        return pq.peek(); 

    }
}

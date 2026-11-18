class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // building adjacency list
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // intialize with empty ArrayList
        }

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int weight = time[2];

            adj.get(u).add(new int[] {v, weight});
            
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        k = k -1; 
        distance[k] = 0;

        // create min heap and comparing on the basis of distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.offer(new int[] {k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int node = current[0];
            int dist = current[1];

            if (dist > distance[node]) { // skipping outdated entries in queue
                continue; // means we already have the smallest distance in the distance array
            }

            // visiting neighbours
            for (int[] neighbour : adj.get(node)) {
                int v = neighbour[0];
                int weight = neighbour[1];

                if (distance[v] > dist + weight) {
                    distance[v] = dist + weight;

                    pq.offer(new int[] {v, dist + weight});
                }
            }
        }

        int max = 0; 
        for(int i = 0; i < distance.length; i++){
            if(distance[i] > max){
                max = distance[i]; 
            }
        }

        return max != Integer.MAX_VALUE ? max : -1; 
    }
}

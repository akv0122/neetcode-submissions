class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // visited Array
        boolean[] visited = new boolean[n];

        // min pq : {point, cost}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // starting from point 0 with cost0
        pq.offer(new int[]{0, 0});

        int totalCost = 0;
        int pointsConnected = 0;

        while (!pq.isEmpty() && pointsConnected < n) {
            int[] current = pq.poll();

            int point = current[0];
            int cost = current[1];

            if (visited[point])
                continue; // skip already visited nodes

            // include point in MST
            visited[point] = true;
            totalCost += cost;
            pointsConnected++;

            // calculate manhattan distance for every unvisited point

            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int distance = Math.abs(points[point][0] - points[next][0])
                        + Math.abs(points[point][1] - points[next][1]);

                    pq.offer(new int[] {next, distance});
                }
            }
        }

        return totalCost; 
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));

        for (int[] point : points) {
            pq.add(point);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        int index = 0;

        while (!pq.isEmpty()) {
            result[index] = pq.remove();

            index++;
        }

        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

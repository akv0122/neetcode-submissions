class MedianFinder {
    PriorityQueue<Integer> maxPq;
    PriorityQueue<Integer> minPq;

    public MedianFinder() {
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
        minPq = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxPq.isEmpty() || maxPq.peek() > num) {
            maxPq.offer(num);
        } else
            minPq.offer(num);

        if (maxPq.size() > minPq.size() + 1) {
            minPq.offer(maxPq.poll());
        } else if (maxPq.size() < minPq.size()) {
            maxPq.offer(minPq.poll());
        }
    }

    public double findMedian() {
        if (maxPq.size() == minPq.size())
            return (maxPq.peek() + minPq.peek()) / 2.0;

        return maxPq.peek();
    }
}

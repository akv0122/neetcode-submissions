class Solution {
    class Task {
        int frequency;
        int executionTime;

        Task(int f, int t) {
            this.frequency = f;
            this.executionTime = t;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // insertion in max heap
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);

        for (Character ch : map.keySet()) {
            int freq = map.get(ch);
            pq.offer(new Task(freq, 0));
        }

        // creaing Queue
        Queue<Task> queue = new LinkedList<>();

        int time = 0;

        while (!queue.isEmpty() || !pq.isEmpty()) {
            time++;

            // check if there is a task in pq then process it
            if (!pq.isEmpty()) {
                Task task = pq.poll();
                task.frequency--;

                if (task.frequency > 0) {
                    task.executionTime = time + n; // update the execution time and put in queue
                    queue.offer(task);
                }
            }

            // shift the active process to the PriorityQueue
            if (!queue.isEmpty() && queue.peek().executionTime == time) {
                Task t = queue.poll();
                pq.offer(t);
            }
        }
        return time;
    }
}

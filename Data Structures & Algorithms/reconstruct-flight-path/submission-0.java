class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        //build the adjacency list
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> ticket : tickets){

            String from = ticket.get(0);
            String to = ticket.get(1); 

            adj.putIfAbsent( from, new PriorityQueue<>()); 
            adj.get(from).offer(to); 
        }

        List<String> result = new ArrayList<>(); 

        dfs( "JFK", adj, result); 

        Collections.reverse(result); 
        
        return result; 
        
    }

    private void dfs( String airport, Map<String, PriorityQueue<String>> adj, List<String> result){

        PriorityQueue<String> neighbours = adj.get(airport); 

        while(neighbours != null && !neighbours.isEmpty() ){

            String nextAirport = neighbours.poll(); 

            dfs( nextAirport, adj, result); 
        }

        result.add(airport); 

    }
}

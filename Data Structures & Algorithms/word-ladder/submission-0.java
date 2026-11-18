class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) return 0; 

        Queue<String> queue = new LinkedList<>(); 

        queue.offer(beginWord); 

        Set<String> visited = new HashSet<>(); 

        visited.add(beginWord); 

        int level = 1; //no of words in our current transformation seq

        while(!queue.isEmpty()){

            int size = queue.size(); 

            for(int i = 0; i < size; i++){
                
                String word = queue.poll(); 

                if(word.equals(endWord))
                    return level;

                char[] chars = word.toCharArray(); 

                for( int j = 0; j < chars.length; j++){

                    char original = chars[j]; 

                    for( char c = 'a'; c <= 'z'; c++){
                        if(c == original) continue;

                        chars[j] = c; 

                        String newWord = new String(chars); 

                        if( wordSet.contains(newWord) && !visited.contains(newWord)){
                            visited.add(newWord); 
                            queue.add(newWord); 
                        }
                    }
                        chars[j] = original; 
                }
            }
                level++; 
        }
        return 0; 
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(s);
        }

        return new ArrayList<>(map.values()); 
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result; 
        calPerm(0, digits, new StringBuilder(), result);
        return result; 
    }

    private Map<Character, String> getMap() {
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return map;
    }

    private void calPerm(int index, String digits, StringBuilder sb, List<String> result) {
        // base case
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        Map<Character, String> map = getMap();
        String current = map.get(digits.charAt(index));

        for (int i = 0; i < current.length(); i++) {
            sb.append(current.charAt(i));
            calPerm(index + 1, digits, sb, result);

            // backtracking
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

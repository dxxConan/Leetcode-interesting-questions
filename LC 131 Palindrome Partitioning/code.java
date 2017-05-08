public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }
        List<String> cur = new ArrayList<>();
        helper(result, cur, 0, s);
        return result;
    }
    public void helper(List<List<String>> result, List<String> cur, int startIndex, String s){
        if(startIndex == s.length()){
            result.add(new ArrayList(cur));
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            String temp = s.substring(startIndex, i + 1);
            if(!isPalindrome(temp)){
                continue;
            }
            cur.add(temp);
            helper(result, cur, i+1, s);
            cur.remove(cur.size() - 1);
        }
    }
    public boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
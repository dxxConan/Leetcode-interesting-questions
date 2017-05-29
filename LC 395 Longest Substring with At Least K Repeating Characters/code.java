public class Solution {
    //notice that in the substring every char should appear at least k times
    //we can get chars whose occurency in the substring less than k times, and use them to split the string
    public int longestSubstring(String s, int k) {
        if(k <= 1){
            return s.length();
        }
        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c - 'a']++;
        }
        StringBuilder spliter = new StringBuilder();
        boolean first = true;
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0 && count[i] < k){
                if(first){
                    spliter.append((char)(i + 'a'));
                    first = false;
                }else{
                    spliter.append("|" + (char)(i+ 'a'));
                }
            }
        }
        if(spliter.length() > 0){
            String[] split = s.split(spliter.toString());
            int max = 0;
        
            for(String cur: split){
                int temp = longestSubstring(cur, k);
                max = Math.max(max, temp);
            }
            return max;
        }else{
            return s.length();
        }
    }
}

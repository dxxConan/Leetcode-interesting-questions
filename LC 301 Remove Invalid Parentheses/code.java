public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        //to remove the minimum number, we need to record the min left and min right parentheses, we can remove
        int removeLeft = 0;
        int removeRight = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                removeLeft++;
            }else if(c == ')'){
                if(removeLeft == 0){
                    removeRight++;
                }else{
                    removeLeft--;
                }
            }
        }
       
        StringBuilder sb = new StringBuilder();
        Set<String> result = new HashSet<>();
        helper(sb, result, s, 0, 0, removeLeft, removeRight);
        return new ArrayList<String>(result);
    }
    public void helper(StringBuilder sb, Set<String> result, String s, int index, int openPar, int removeLeft, int removeRight){
        //when openPar < 0 mean there are more ) than ( in the previous substring
        if(removeRight < 0 || removeLeft < 0 || openPar < 0){
            return;
        }
        if(index == s.length()){
        //    System.out.println(sb.toString());
            if(removeRight == 0 && removeLeft == 0 && openPar == 0){
                result.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        int len = sb.length();
        if(c == '('){
            helper(sb, result, s, index+1, openPar, removeLeft-1, removeRight); // not use
            helper(sb.append(c), result, s, index+1, openPar+1, removeLeft, removeRight); // use 
        }else if(c == ')'){
            helper(sb, result, s, index+1, openPar, removeLeft, removeRight-1); // not use
            helper(sb.append(c), result, s, index+1, openPar-1, removeLeft, removeRight); // use
        }else{
            helper(sb.append(c), result, s, index+1, openPar, removeLeft, removeRight); 
        }
        sb.setLength(len);
    }
}
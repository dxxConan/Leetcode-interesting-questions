public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int cur = 1;
        for(int i = 0; i < n; i++){
            result.add(cur);
            if(cur*10 <= n){
                cur *= 10;
            }else if(cur % 10 != 9 && cur < n){
                cur++;
            }else{
                //take 499 as example the next number should be added is 5
                //and if n is like 1200, 999 is the last number, not have chance to enter this if statement
                while((cur/10) % 10 == 9){
                    cur /= 10; 
                }
                cur = cur/10 + 1;
            }
        }
        return result;
    }
}
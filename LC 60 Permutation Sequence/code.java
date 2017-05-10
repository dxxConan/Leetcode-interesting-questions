public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <=n; i++){
            num.add(i);
        }
        int[] factor = new int[n];
        factor[0] = 1;
        for(int i = 1; i < n; i++){
            factor[i] = factor[i-1]*i;
        }
        k = k - 1;
        for(int i = n; i > 0; i--){
            int index = k / factor[i-1];
            k = k % factor[i-1];
            sb.append(num.get(index));
            num.remove(index);
        }
        return sb.toString();
    }
}
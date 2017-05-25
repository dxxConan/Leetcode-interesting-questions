public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        ArrayList<Integer> dp = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(dp.size() == 0 || nums[i] > dp.get(dp.size() - 1)){
                dp.add(nums[i]);
            }else{
                int index = findFirstLargeOrEqual(dp, nums[i]);
                dp.set(index, nums[i]);
            }
        }
        return dp.size();
    }
    //find the first element index which is equal or larger than target
    public int findFirstLargeOrEqual(ArrayList<Integer> dp, int target){
        int start = 0;
        int end = dp.size() - 1;

        int mid = 0;
        while(start + 1 < end){
            mid = (end - start)/2 + start;
            if(dp.get(mid) < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(dp.get(start) >= target){
            return start;
        }else if(dp.get(end) >= target){
            return end;
        }else{
            return end + 1;
        }
    }
}
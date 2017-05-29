public class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        //stack is an array to keep the length
        int[] stack = new int[paths.length + 1];
        int max = 0;
        for(String s: paths){
            int level = s.lastIndexOf("\t") + 1;
            //current level length = parents length + current folder length
            //note current level length is associated with its closest parent
            stack[level + 1] = stack[level] + s.length() - level + 1;
            //for the curLen we actually add a "/" to the length, so if it is a file, we should minus that
            int curLen = stack[level + 1];
            //is a file
            if(s.contains(".")){
                max = Math.max(max, curLen - 1);
            }
        }
        return max;
    }
}
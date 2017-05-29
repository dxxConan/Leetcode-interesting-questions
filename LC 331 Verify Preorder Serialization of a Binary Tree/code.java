public class Solution {
    //method 1, we cut off the leaf nodes and to see if what left is a legal tree.
    //eg: 9,3,4,#,#,1,#,#,2,#,6,#,#
    //9,3,4,#,# => 9,3,# 
    //9,3,#,1,#,# => 9,3,#,# => 9,# 
    //9,#2,#,6,#,# => 9,#,2,#,# => 9,#,# => #
    /*
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return false;
        }
        String[] decompose = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < decompose.length; i++){
            String cur = decompose[i];
            while(cur.equals("#") && !stack.isEmpty() && cur.equals(stack.peek())){
                stack.pop();
                if (stack.isEmpty()){
                    return false;
                }
                //pop the number
                stack.pop();
            }
            stack.push(cur);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
    */
    //method 2: use degree.
    //if a node is not #, not root, it will provide 1 indegree, 2 outdegree,
    //if is #, provide 1 indegree.
    //the indgree and outdegree difference should be 0 and never less 0 during the process;
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return false;
        }
        String[] decompose = preorder.split(",");
        //diff = out - in;
        int diff = 0;
        for(int i = 0; i < decompose.length; i++){
            //every node should has minus 1 for indegree.
            String cur = decompose[i];
            //except the root node
            if(i != 0 && --diff < 0){
                return false;
            }
            if(!cur.equals("#")){
               diff += 2; 
            }
        }
        return diff == 0;
    }    
}
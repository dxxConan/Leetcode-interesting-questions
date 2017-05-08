public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        List<Integer> row = new ArrayList<>();
        helper(n, result, row);
        return result;
    }
    //the list row record the index of Q should be placed in each queue
    public void helper(int n, List<List<String>> result, List<Integer> row){
        if(row.size() == n){
            result.add(draw(row));
        }
        for(int indexOfQueen = 0; indexOfQueen < n; indexOfQueen++){
            if(!isValid(row, indexOfQueen)){
                continue;
            }
            row.add(indexOfQueen);
            helper(n, result, row);
            row.remove(row.size() - 1);
        }
    }
    // draw the board by Q's index information stored in list row
    public List<String> draw(List<Integer> row){
        List<String> curResult = new ArrayList<String>();
        for(int i = 0; i < row.size(); i++){
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < row.size(); j++){
                temp.append(row.get(i) == j ? "Q": ".") ;
            }
            curResult.add(temp.toString());
        }
        return curResult;
    }
    
    public boolean isValid(List<Integer> row, int indexOfQueen){
        int curRow = row.size();
        for(int i = 0; i < row.size(); i++){
            //no queen on the same col
            if(row.get(i) == indexOfQueen){
                return false;
            }
            /*
                    0,0,Q,0,0
                    0,0,0,0,0
            curROW: 0,0,0,0,Q
            situation like this
            */
            if((row.get(i) - i) == (indexOfQueen - curRow)){
                return false;
            }
            /*
                    0,0,Q,0,0
                    0,0,0,0,0
            curROW: Q,0,0,0,0
            situation like this
            */
            if((row.get(i) + i) == (indexOfQueen + curRow)){
                return false;
            }
        }
        return true;
    }
}
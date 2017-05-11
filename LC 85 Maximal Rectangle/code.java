public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] height = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0){
                    height[i][j] = (matrix[i][j] == '0') ? 0 : 1;
                }else{
                    height[i][j] = (matrix[i][j] == '0') ? 0 : height[i-1][j] +1;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < row; i++){
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j <= col; j++){
                int cur = (j == col) ? 0 : height[i][j];
                while(!stack.isEmpty() && height[i][stack.peek()] > cur){
                    int h = height[i][stack.pop()];
                    int w = (stack.isEmpty()) ? j : j - stack.peek() - 1;
                    result = Math.max(result, h*w);
                }
                stack.push(j);
            }
        }
        return result;
    }
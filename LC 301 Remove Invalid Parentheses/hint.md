dfs is faster
and the way to record if it is valid in dfs(backtracking)
1. record the min left and min right parentheses, we can remove
2. record how many openParentheses we currently have
3. once those value is smaller than 0, the result is not currently
4. stringbulider has setLength method to remove the latest char we add, so that we can go back to the previous status easily
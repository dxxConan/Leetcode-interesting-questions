public class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int head = 1;
        int step = 1;
        int remaining = n;
        while(remaining > 1){
            //start from left or remaining is odd, the head will change
            if(left || remaining % 2 == 1){
                head = head + step;
            }
            remaining /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}
public class MedianFinder {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    boolean even;
    public MedianFinder() {
        //store smaller value
            maxHeap = new PriorityQueue<Integer> (new Comparator<Integer> () {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
        }
        );
        //store bigger value
        minHeap = new PriorityQueue<>();
        even = true;
    }
    
    public void addNum(int num) {
        if(even){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
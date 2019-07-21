import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder{
    // The max heap stores the smaller half of all numbers 
    // while the min heap stores the larger half.
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;
    public MedianFinder(){
        // head element is the biggest of min queue
        this.min = new PriorityQueue<>();
        // head element is the smallest of max queue
        this.max = new PriorityQueue<>(1000,Collections.reverseOrder());
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        // The size of max queue is always equal or larger than min
        if(max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if(max.size()==min.size()){
            return (max.peek() + min.peek())/2.0;
        }
        else{
            return max.peek();
        }
    }
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

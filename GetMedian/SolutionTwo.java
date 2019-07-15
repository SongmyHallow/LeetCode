import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionTwo{
  // use counter to make sure the difference between the numbers of elements in two heaps is less than 1
  private int count = 0;
  // priority is based on natural order
  private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15,new Comparator<Integer>() {
    @Override
    // change the way it compares in priority queue
    public int compare(Integer o1, Integer o2){
      return o2-o1;
    }
  });

  public void insert(Integer num){
    if(count%2 == 0){
      maxHeap.offer(num);
      int filteredMaxNum = maxHeap.poll();
      minHeap.offer(filteredMaxNum);
    }
    else{
      minHeap.offer(num);
      int filteredMinNum = minHeap.poll();
      maxHeap.offer(filteredMinNum);
    }
    count++;
  }

  public Double GetMedian(){
    if(count%2 == 0){
      return new Double((minHeap.peek()+maxHeap.peek())/2);
    }
    else{
      return new Double(minHeap.peek());
    }
  }
}
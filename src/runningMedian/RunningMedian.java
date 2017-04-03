package runningMedian;
import java.util.Scanner;

/**
 * Algorithm to compute running Mean
 * @author abhisheknigam
 *
 */
public class RunningMedian {

	static float computeMedian(MaxHeap maxHeap, MinHeap minHeap, float median, int input) {
		int minSize;
		int maxSize;
		
		if (median <= input) {
			minHeap.insert(input);
		} else {
			maxHeap.insert(input);
		}

		minSize = minHeap.getSize();
		maxSize = maxHeap.getSize();

		insertIntoHeap(maxHeap, minHeap, minSize, maxSize);

		minSize = minHeap.getSize();
		maxSize = maxHeap.getSize();

		if (maxSize == minSize) {
			median = (float) (maxHeap.getRoot() + minHeap.getRoot()) / 2;
		} else if (maxSize > minSize) {
			median = maxHeap.getRoot();
		} else {
			median = minHeap.getRoot();
		}
		return median;
	}

	private static void insertIntoHeap(MaxHeap maxHeap, MinHeap minHeap, int minSize, int maxSize) {
		if ((maxSize - minSize) > 1) {
			int b = maxHeap.removeRoot();
			minHeap.insert(b);

		} else if ((minSize - maxSize) > 1) {
			int b = minHeap.removeRoot();
			maxHeap.insert(b);
		}
	}
	
	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        int totalInstructions = scan.nextInt();
	        
	        MaxHeap maxHeap = new MaxHeap();
			MinHeap minHeap = new MinHeap();
			float median =0;
	        
	        for(int k=0; k < totalInstructions; k++){
	        	median = computeMedian(maxHeap, minHeap, median, scan.nextInt());
				System.out.println(String.format("%.1f", median));
	        }
		}
}
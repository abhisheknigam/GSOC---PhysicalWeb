package runningMedian;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RunningMedianTest {

	@Test
	public void testRunningMedianSmallValue(){
		float median = 0;
		MinHeap minHeap = new MinHeap();
		MaxHeap maxHeap = new MaxHeap();
		for(int k=0; k <= 10; k++){
			RunningMedian runMedian = new RunningMedian();
        	median = runMedian.computeMedian(maxHeap, minHeap, median, k);
        }
		assertEquals(Float.valueOf(median),Float.valueOf(5));
	}
	
	@Test
	public void testRunningMedianMediumValue(){
		float median = 0;
		MinHeap minHeap = new MinHeap();
		MaxHeap maxHeap = new MaxHeap();
		for(int k=0; k <= 50; k++){
			RunningMedian runMedian = new RunningMedian();
        	median = runMedian.computeMedian(maxHeap, minHeap, median, k);
        }
		assertEquals(Float.valueOf(median),Float.valueOf(25));
	}
	
	@Test
	public void testRunningMedianLargeValue(){
		float median = 0;
		MinHeap minHeap = new MinHeap();
		MaxHeap maxHeap = new MaxHeap();
		for(int k=0; k <= 100; k++){
			RunningMedian runMedian = new RunningMedian();
        	median = runMedian.computeMedian(maxHeap, minHeap, median, k);
        }
		assertEquals(Float.valueOf(median),Float.valueOf(50));
	}
	
	@Test
	public void testRunningMedianIntermittentValue(){
		float median = 0;
		MinHeap minHeap = new MinHeap();
		MaxHeap maxHeap = new MaxHeap();
		for(int k=1; k <= 1000; k += 13){
			RunningMedian runMedian = new RunningMedian();
        	median = runMedian.computeMedian(maxHeap, minHeap, median, k);
        }
		assertEquals(Float.valueOf(median),Float.valueOf(495));
	}
	
	@Test
	public void testRunningMedianOneValue(){
		float median = 0;
		MinHeap minHeap = new MinHeap();
		MaxHeap maxHeap = new MaxHeap();
		for(int k=1; k <= 1; k += 13){
			RunningMedian runMedian = new RunningMedian();
        	median = runMedian.computeMedian(maxHeap, minHeap, median, k);
        }
		assertEquals(Float.valueOf(median),Float.valueOf(1));
	}
}

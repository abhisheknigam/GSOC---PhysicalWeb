package queue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueTest {

	
	@Test
	public void testCreationOfQueue(){
		Queue<Integer> integers = new Queue<>();
		Queue<String> strings = new Queue<>(1);
		
		// Default Size
		assertEquals(Long.valueOf(integers.getCapacity()), Long.valueOf(16));
		
		//check with initialized size
		assertEquals(Long.valueOf(strings.getCapacity()), Long.valueOf(1));
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testDequeue(){
		Queue<Integer> integers = new Queue<>(0);
		integers.enqueue(42);
		integers.dequeue();
		assertEquals(integers.getCapacity(), (Integer)1);
		integers.getTop();
	}
	
	@Test
	public void testEnqueue(){
		Queue<Integer> integers = new Queue<>(0);
		integers.enqueue(42);
		assertEquals(integers.getTop(), (Integer)42);
		
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testDequeueFromEmptyQueue(){
		Queue<Integer> integers = new Queue<>(0);
		integers.enqueue(42);
		integers.dequeue();
		integers.dequeue();
		
	}
	
	@Test
	public void testDoublingOfQueue(){
		Queue<Integer> integers = new Queue<>(0);
		integers.enqueue(42);
		integers.enqueue(14);
		integers.dequeue();
		integers.enqueue(28);
		integers.enqueue(60);
		integers.dequeue();
		assertEquals(integers.getTop(), (Integer)28);
		assertEquals(integers.getCapacity(), (Integer)4);
	}
	
	@Test
	public void testLeftShiftingOfQueue(){
		Queue<Integer> integers = new Queue<>(0);
		integers.enqueue(42);
		integers.enqueue(14);
		integers.dequeue();
		integers.enqueue(28);
		integers.enqueue(60);
		integers.dequeue();
		integers.dequeue();
		assertEquals(integers.getTop(), (Integer)60);
		assertEquals(integers.getCapacity(), (Integer)4);
	}
	
	@Test
	public void testDoubleDoublingOfQueue(){
		Queue<Integer> integers = new Queue<>(0);
		integers.enqueue(42);
		integers.enqueue(14);
		integers.dequeue();
		integers.enqueue(28);
		integers.enqueue(60);
		integers.dequeue();
		integers.enqueue(78);
		integers.dequeue();
		integers.dequeue();
		integers.dequeue();
		integers.enqueue(42);
		integers.enqueue(14);
		integers.enqueue(42);
		integers.enqueue(14);
		integers.enqueue(14);
		assertEquals(integers.getTop(), (Integer)42);
		assertEquals(integers.getCapacity(), (Integer)8);
	}
}

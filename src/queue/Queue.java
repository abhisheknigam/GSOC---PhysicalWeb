package queue;
/**
 * Code for GSOC Physical Web Pre-screening
 * 
 * @author abhisheknigam
 *
 * @param <T>
 * 
 * Class to create a Generic Queue. 
 * TODO Add facility to specify load in constructor
 */
public class Queue<T> {

	private T[] elements;
	private int capacity;
	private int currentIndex;
	
	/**
	 * Create a Queue with an initialized capacity
	 * 
	 * @param capacity
	 * 		capacity with which queue needs to be initialized
	 */
	public Queue(int capacity){
		if(capacity == 0 ){
			this.capacity = 1;
		}else{
			this.capacity = capacity;
		}
		this.currentIndex = 0;
		this.elements  = (T[])new Object[this.capacity];
	}
	
	/**
	 * Create an empty Queue
	 * 
	 * @param capacity
	 * 		capacity with which queue needs to be initialized
	 */
	public Queue(){
		this.capacity = 16;
		this.currentIndex = 0;
		this.elements = (T[])new Object[capacity];
	}
	
	/**
	 * Adds element to the end of the Queue. FIFO
	 * 
	 * @param element
	 * 		Element which needs to be added to the Queue
	 * @return
	 * 		Element just added to the Queue.
	 */		
	public T enqueue(T element){
		if(currentIndex == capacity){
			this.elements  =  doubleSizeOfArray(elements);
		}
		elements[currentIndex] = element;
		currentIndex++;
		return element;
	}
	
	private T[] doubleSizeOfArray(T[] elements){
		if(elements != null && elements.length != 0){
			this.capacity = elements.length * 2;
			T[] doubleArray = (T[])new Object[capacity];
			for(int i =0 ; i< elements.length; i++){
				doubleArray[i] = elements[i];
			}
			
			return doubleArray;	
		}
		return null;
	}
	
	/**
	 * Use to pop the top of the queue.
	 * 
	 * @return T
	 * 		Element popped from the queue
	 */
	public T dequeue(){
		if(elements.length > 0){
			T t = elements[0];
			leftCopy();
			return t;
		}else{
			throw new ArrayIndexOutOfBoundsException(" Queue was empty while performing Dequeue operation");
		}
	}
	
	/**
	 * Left copies the array elements by 1 index. Free's up the space of the last index element.
	 */
	private void leftCopy(){
		for(int i = 1; i < elements.length; i++){
			this.elements[i-1] = elements[i];
		}
		elements[currentIndex-1] = null;
		currentIndex = currentIndex -1;
	}
	
	/**
	 * Prints the first element of the queue
	 */
	public void print(){
		if(elements.length > 0 && currentIndex != 0){
//			for(T element:elements){
//				System.out.println(element);
//			}
			System.out.println(elements[0].toString());
		}else{
			System.out.println("Queue is empty");
		}
		
	}
	
	/**
	 * Get top of the Queue
	 * 
	 * Helper function for JUNIT Test. Therefore, no access type is defined to restrict visibilty within package.
	 * 
	 * @return
	 */
	T getTop(){
		if(elements.length > 0 && currentIndex != 0){
			return elements[0];
		}else{
			throw new ArrayIndexOutOfBoundsException("Queue is Empyty");
		}
	}
	
	/**
	 * Get current capacity of the Queue
	 * 
	 * Helper Function for JUNIT Test. Therefore, no access type is defined to restrict visibilty within package.
	 * @return
	 * 		capacity of the Queue
	 */
	Integer getCapacity(){
		return this.capacity;
	}
}
	
	


package runningMedian;

import java.util.ArrayList;

/**
 * Max Heap Implementation for Integer data
 * @author Multiple Authors, abhisheknigam
 * Since this was just a placeholder for this assignment, 
 * I have combined methods from previous implementations to facilitate the algorithm
 * Preferred Minimal implementation over Priority Queues
 */
public class MaxHeap {
	
	ArrayList<Integer> data = new ArrayList<Integer>();
	
     void PrintData(){
		System.out.println(" ");
		for(int i = 0; i< data.size();i++)
			System.out.print(data.get(i) + " ");
	}
     
	int getSize(){
		return data.size();
	}
	
	int getRoot(){
		return data.get(0);
	}
	
	/**
	 * Removes root of the MaxHeap
	 * @return
	 * 		removed root node value
	 */
	int removeRoot(){
		
		Integer lChildValue;
		Integer parentValue;
		Integer rChildValue;
		int parentIndex = 0;
		int lChildIndex;
		int rChildIndex;
		
		int root = data.get(0);
		int length = data.size();
		int lastElement = data.get(length - 1);
		
		data.set(0, lastElement);
		data.remove(length - 1);
		
		length = length - 2;
		
		lChildIndex = (parentIndex*2) + 1;
		rChildIndex = lChildIndex + 1;
		while(lChildIndex<=length){
			lChildIndex = (parentIndex*2) + 1;
			rChildIndex = lChildIndex + 1;
			parentValue = data.get(parentIndex);
			if(lChildIndex <=length){
				lChildValue = data.get(lChildIndex);
			}
			else{
				lChildValue = -1;
			}
			if(rChildIndex <=length){
				rChildValue = data.get(rChildIndex);
			}
			else{
				rChildValue = null;
			}
				
			if(rChildValue == null || lChildValue >= rChildValue){
				if(lChildValue > parentValue){
					data.set(lChildIndex, parentValue);
					data.set(parentIndex, lChildValue);
					parentIndex = lChildIndex;
					
				}
				else{
					break;
				}
			}
			else{
				if(rChildValue > parentValue){
					data.set(rChildIndex, parentValue);
					data.set(parentIndex, rChildValue);
					parentIndex = rChildIndex;
				}
				else{
					break;
				}
			}	
		}
		return root;
	}
	
	/**
	 * Insert child to the MaxHeap
	 * @return
	 * 		void
	 */
	void insert(int childValue){
		data.add(childValue);
		int length = data.size();
		
		int parentIndex;
		int parentValue;
		int childIndex;
		
		parentIndex = (int)Math.floor((length-2)/2);
		childIndex = length - 1;
		
		
		while(parentIndex>=0){
			parentValue = data.get(parentIndex);
			childValue = data.get(childIndex);
			if(parentValue < childValue){
				data.set(childIndex, parentValue);
				data.set(parentIndex, childValue);
				
				childIndex = parentIndex;
				parentIndex = (int)Math.floor((childIndex-1)/2);
			}
			else{
				break;
			}	
		}	
	}
}


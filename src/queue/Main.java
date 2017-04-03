package queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Integer numberOfInstructions = scan.nextInt();
		Queue<Integer> integers = new Queue<>(0);
		while(numberOfInstructions >= 0){
			String[] instructions = scan.nextLine().split(" ");
			if(instructions.length > 1 && instructions[0].equals("1")){
				integers.enqueue(Integer.parseInt(instructions[1]));
			}else if(instructions[0].equals("2")){
				integers.dequeue();
			}else if(instructions[0].equals("3")){
				integers.print();
			}
			numberOfInstructions--;
		}
		
		
	}
}

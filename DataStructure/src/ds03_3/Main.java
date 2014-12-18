package ds03_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static String PUSH = "push";
	public static String POP = "pop";
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(read.readLine());

		// Initialize node array with index
		Node[] nodeArr = new Node[length];
		for (int i = 1; i <= length; i++) {
			Node node = new Node();
			node.index = i;
			nodeArr[i] = node;
		}
		
		int root = -1;
		int prevIndex = -1;
		String prevOperation = null;
		for (int i = 0; i < length*2; i++) {
			String[] line = read.readLine().split(" ");
			String operation = line[0];
			int index = Integer.parseInt(line[1]);
			
			if(i == 0){
				root = index;
				prevIndex = index;
				prevOperation = operation;
			}
			
			if(PUSH.equals(operation)){
				if(PUSH.equals(prevOperation)){
					nodeArr[prevIndex].leftChild = index;
					prevIndex = index;
					prevOperation = operation;
				}
				else if(POP.equals(prevOperation)){
					
				}
			}
			else if(POP.equals(prevOperation)){
				
			}
			
		}

	}

}

class Node {
	public int parent;
	public int leftChild;
	public int rightChild;
	public int index;
}

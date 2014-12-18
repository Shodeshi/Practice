package ds03_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(read.readLine());
		Node[] nodeArr = new Node[num];
		
		// The sum of all node index, will be used to calculate the root
		int sum = 0;
		
		// Initialize node array with index
		for(int i = 0;i < num; i++){
			Node node = new Node();
			node.index = i;
			nodeArr[i] = node;
			
			sum += i;
		}
		
		// Assign node parent and children with the input
		for(int i = 0;i<num;i++){
			String[] line = read.readLine().split(" ");
			Node node = nodeArr[i];
			
			if("-".equals(line[0])){
				node.leftChild = -1;
			}
			else{
				int leftChild = Integer.parseInt(line[0]);
				node.leftChild = leftChild;
				nodeArr[leftChild].parent = i;
				
				sum -= leftChild;
			}
			
			if("-".equals(line[1])){
				node.rightChild = -1;
			}
			else{
				int rightChild = Integer.parseInt(line[1]);
				node.rightChild = rightChild;
				nodeArr[rightChild].parent = i;
				
				sum -= rightChild;
			}
		}
		read.close();
		
		// Traversal the tree, output the leaves
		LinkedList<Node> linkedList = new LinkedList<Node>();
		linkedList.addLast(nodeArr[sum]);
		
		boolean isFirst = true;
		while(linkedList.size() > 0){
			Node node = linkedList.removeFirst();
			int leftChild = node.leftChild;
			int rightChild = node.rightChild;
			
			if(leftChild == -1 && rightChild == -1){
				if(isFirst){
					System.out.print(node.index);
					isFirst = false;
				}
				else
					System.out.print(" " + node.index);
			}
			else{
				if(leftChild != -1)
					linkedList.addLast(nodeArr[leftChild]);
				
				if(rightChild != -1)
					linkedList.addLast(nodeArr[rightChild]);
			}
		}
	}

}

class Node{
	public int parent;
	public int leftChild;
	public int rightChild;
	public int index;
}

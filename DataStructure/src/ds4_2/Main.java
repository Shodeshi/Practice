package ds4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(read.readLine());
		int componentCount = length;
		
//		long dataArr[] = new long[length + 1];
		int parentArr[] = new int[length + 1];
		
		String input = read.readLine();
		while(!"S".equals(input)){
			String inputArr[] = input.split(" ");
			int a = Integer.parseInt(inputArr[1]);
			int b = Integer.parseInt(inputArr[2]);
			int rootA = findRoot(parentArr, a);
			int rootB = findRoot(parentArr, b);
			
			if("C".equals(inputArr[0])){
				// When a and b has the same root, they are connected
				if(rootA == rootB)
					System.out.println("yes");
				else
					System.out.println("no");
			}
			else if("I".equals(inputArr[0])){
				if (rootA != rootB){
					if(parentArr[rootB] == 0)
						componentCount --;
					parentArr[rootB] = rootA;
				}
			}
			
			input = read.readLine();
		}
		
		if(componentCount == 1)
			System.out.println("The network is connected.");
		else
			System.out.printf("There are %d components.", componentCount);
	}
	
	public static int findRoot(int parentArr[], int data){
		int parent = parentArr[data];
		int prev = data;
		while(parent > 0 && parentArr[parent] > 0){
			parentArr[prev] = parentArr[parent];
			prev=parent;
			parent = parentArr[parent];
		}
		return parent == 0 ? data : parent;
	}

}

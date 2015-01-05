package ds5_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String firstLine[] = read.readLine().split(" ");

		// Initialize path array from input
		int vCount = Integer.parseInt(firstLine[0]);
		int eCount = Integer.parseInt(firstLine[1]);
		int pathArr[][] = new int[vCount][vCount];
		int BFSArr[][] = new int[vCount][vCount];
		
		for(int i = 0;i<eCount;i++){
			String line[] = read.readLine().split(" ");
			pathArr[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 1;
			pathArr[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = 1;
			
			BFSArr[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 1;
			BFSArr[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = 1;
		}
		read.close();
		
		for(int i = 0; i<vCount;i++){
			if(pathArr[i][i] != 1){
				System.out.print("{");
				DFS(pathArr, i);
				System.out.println(" }");
			}
		}
		
		for(int i = 0; i<vCount;i++){
			if(BFSArr[i][i] != 1){
				System.out.print("{");
				BFS(BFSArr, i);
				System.out.println(" }");
			}
		}
		
	}
	
	public static void DFS(int[][] pathArr, int vIndex){
		// Mark vIndex has been visited
		pathArr[vIndex][vIndex] = 1;
		System.out.print(" " + vIndex);
		for(int i = 0; i<pathArr.length;i++){
			if(pathArr[vIndex][i] == 1 && pathArr[i][i] != 1)
				DFS(pathArr, i);
		}
	}
	
	public static void BFS(int[][] pathArr, int vIndex){
		// Mark vIndex has been visited
		pathArr[vIndex][vIndex] = 1;
		// Add the vertices to queue
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(vIndex);
		while(list.size() > 0){
			Integer vertices  = list.poll();
			System.out.print(" " + vertices);
			// Add all unvisited vertices around current one
			for(int i = 0; i<pathArr.length;i++){
				if(pathArr[vertices][i] == 1 && pathArr[i][i] != 1){
					pathArr[i][i] = 1;
					list.addLast(i);
				}
			}
		}
	}

}

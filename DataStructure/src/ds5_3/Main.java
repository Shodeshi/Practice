package ds5_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String firstLine[] = read.readLine().split(" ");
		
		int nodeCount = Integer.parseInt(firstLine[0]);
		int linkCount = Integer.parseInt(firstLine[1]);
		
		// Read the links from input
		List<?> table[] = new List[nodeCount + 1];
		for(int i=0;i<linkCount;i++){
			String line[] = read.readLine().split(" ");
			int from = Integer.parseInt(line[0]);
			int to = Integer.parseInt(line[1]);
			
			if(table[from] == null){
				table[from] = new ArrayList<Integer>();
			}
			if(table[to] == null){
				table[to] = new ArrayList<Integer>();
			}
			ArrayList<Integer> toList = (ArrayList<Integer>) table[from];
			toList.add(to);
			toList = (ArrayList<Integer>) table[to];
			toList.add(from);
		}
		read.close();

		for(int i=1;i<=nodeCount;i++){
			int count = BFS(table, i);
			double percent = (double) count / nodeCount * 100;
			System.out.println(String.format("%d: %.2f%s", i, percent, "%"));
		}
	}
	
	public static int BFS(List<?>[] table, int value){
		int count = 1;
		// Build the array saved if one node has been visited
		int[] isVisisted = new int[table.length];
		isVisisted[value] = 1;
		// Build the queue for BFS
		LinkedList<Integer> searchList = new LinkedList<Integer>();
		searchList.addLast(value);
		int last = value;
		int tail = -1;
		int level = 0;
		while(searchList.size() > 0){
			Integer out = searchList.poll();
			ArrayList<Integer> toList = (ArrayList<Integer>) table[out];
			if(toList != null){
				for(Integer to : toList){
					if(isVisisted[to] == 0){
						count ++;
						isVisisted[to] = 1;
						searchList.addLast(to);
						tail = to;
					}
				}
			}
			
			if(out == last){
				level ++;
				last = tail;
			}
			
			if(level == 6)
				break;
			
		}
		return count;
	}

}

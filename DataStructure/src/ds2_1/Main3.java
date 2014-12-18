package ds2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main3 {

	public static void main(String[] args) throws IOException {
		int dataArr[] = new int[100000];
		int prevArr[] = new int[100000];
		int nextArr[] = new int[100000];
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		String firstLine[] = read.readLine().split(" ");
		int firstAddress = Integer.parseInt(firstLine[0]);
		int length = Integer.parseInt(firstLine[1]);
		int k = Integer.parseInt(firstLine[2]);
		k = k < 1 ? 1 : k;
		
		// Read each node from input
		for (int i = 0; i < length; i++) {
			String line[] = read.readLine().split(" ");
			int address = Integer.parseInt(line[0]);
			int data = Integer.parseInt(line[1]);
			int next = Integer.parseInt(line[2]);
			
			// Save the data and next address
			dataArr[address] = data;
			nextArr[address] = next;
		}
		
		int nextAddress = firstAddress;
		int prevAddress = -1;
		while(nextAddress != -1){
			prevArr[nextAddress] = prevAddress;
			prevAddress = nextAddress;
			nextAddress = nextArr[nextAddress];
		}
		System.gc();
		
		int leftNodeCount = length;
		int startAddress = -1;
		int startPrev = -2;
		int processCount = 0;
		int currentAddress = firstAddress;
		int firstNodeAddress = firstAddress;
		
		while(currentAddress != -1 && k > 1){
			processCount++;
			nextAddress = nextArr[currentAddress];
			// Process for first conversing node
			if(processCount == 1){
				// Save the start node info
				startAddress = currentAddress;
				startPrev = prevArr[currentAddress];
				prevArr[currentAddress] = nextArr[currentAddress];
			}
			// Process for last conversing node
			else if (processCount == k){
				// The start node's next node should be the end node's next node
				nextArr[startAddress] = nextArr[currentAddress];
				// When current node has next node, update its previous node
				if(nextArr[startAddress] != -1)
					prevArr[nextArr[startAddress]] = startAddress;
				// The end node's next node should be its previous node
				nextArr[currentAddress] = prevArr[currentAddress];
				// The end node's previous node should be the start node's previous node
				prevArr[currentAddress] = startPrev;
				
				if(startPrev == -1)
					firstNodeAddress = currentAddress;
				else{
					nextArr[startPrev] = currentAddress;
				}
				
				if(leftNodeCount < k)
					break;
				
				processCount = 0;
				System.gc();
			}
			// Middle nodes
			else{
				// swap previous and next address
				prevAddress = prevArr[currentAddress];
				prevArr[currentAddress] = nextArr[currentAddress];
				nextArr[currentAddress] = prevAddress;
			}
			leftNodeCount --;
			currentAddress = nextAddress;
		}

		System.gc();
		
		DecimalFormat format = new java.text.DecimalFormat("00000"); 
		nextAddress = firstNodeAddress;
		while(nextAddress != -1){
			System.out.println(String.format("%s %s %s", format.format(nextAddress), dataArr[nextAddress], nextArr[nextAddress] == -1 ? "-1" : format.format(nextArr[nextAddress])));
			nextAddress = nextArr[nextAddress];
		}

	}
}


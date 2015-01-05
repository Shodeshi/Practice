package ds5_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String firstLine[] = read.readLine().split(" ");

		// Initialize node array
		int nodeCount = Integer.parseInt(firstLine[0]);
		int distance = Integer.parseInt(firstLine[1]);
		int nodeArr[][] = new int[nodeCount + 1][2];
		int visitedArr[] = new int[nodeCount + 1];

		for (int i = 1; i <= nodeCount; i++) {
			String line[] = read.readLine().split(" ");
			nodeArr[i][0] = Integer.parseInt(line[0]);
			nodeArr[i][1] = Integer.parseInt(line[1]);
		}
		read.close();

		boolean isAble = false;
		boolean isFirst = true;
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(0);
		while (list.size() > 0) {
			int node = list.poll();
			visitedArr[node] = 1;
			if (Math.abs(nodeArr[node][0]) >= (50 - distance) || Math.abs(nodeArr[node][1]) >= (50 - distance)) {
				isAble = true;
				break;
			}

			for (int i = 1; i <= nodeCount; i++) {
				// Check if the node is not visited, and is reachable
				if (visitedArr[i] == 0) {
					int distanceX = nodeArr[i][0] - nodeArr[node][0];
					int distanceY = nodeArr[i][1] - nodeArr[node][1];
					int reachAbleDistance = distance;
					if (isFirst) {
						reachAbleDistance = distance + 15;
						isFirst = false;
					}
					if (distanceX * distanceX + distanceY * distanceY <= reachAbleDistance * reachAbleDistance) {
						visitedArr[i] = 1;
						list.addLast(i);
					}
				}
			}
		}

		if (isAble)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}

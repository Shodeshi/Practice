package ds03_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static String PUSH = "Push";
	public static String POP = "Pop";

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(read.readLine());

		LinkedList<Node> list = new LinkedList<Node>();
		Node[] result = new Node[length];
		int resultIndex = 0;

		for (int i = 0; i < length * 2; i++) {
			String[] line = read.readLine().split(" ");

			if (PUSH.equals(line[0])) {
				Node node = new Node();
				node.index = i;
				node.value = Integer.parseInt(line[1]);
				list.push(node);
			} else {
				result[resultIndex] = list.pop();
				resultIndex++;
			}
		}
		read.close();

		moveRootToEnd(result, 0, length - 1);

		print(result);
	}

	public static void moveRootToEnd(Node[] arr, int startIndex, int endIndex) {
		Node min = null;
		int minIndex = -1;

		// Find the root node (minimum node)
		for (int i = startIndex; i <= endIndex; i++) {
			if (min == null || arr[i].index < min.index) {
				min = arr[i];
				minIndex = i;

				if (min.index == 0)
					break;
			}
		}

		// Move the nodes after root to front
		for (int i = minIndex; i < endIndex; i++) {
			arr[i] = arr[i + 1];
		}

		arr[endIndex] = min;

		// Process for left child, if the child tree has more than 2 nodes
		// minIndex - 1 - startIndex + 1 >= 2
		if (minIndex - startIndex >= 2)
			moveRootToEnd(arr, startIndex, minIndex - 1);
		// Process for right child, if the child tree has more than 2 nodes
		// endIndex - 1 - minIndex + 1 >= 2
		if (endIndex - minIndex >= 2)
			moveRootToEnd(arr, minIndex, endIndex - 1);
	}

	public static void print(Node[] result) {
		for (int i = 0; i < result.length; i++) {
			if (i == 0)
				System.out.print(result[i].value);

			else
				System.out.print(" " + result[i].value);
		}
	}
}

class Node {
	public int value;
	public int index;
}

package ds2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		String firstLine[] = read.readLine().split(" ");
		String firstAddress = firstLine[0];
		int length = Integer.parseInt(firstLine[1]);
		int k = Integer.parseInt(firstLine[2]);
		k = k < 1 ? 1 : k;

		Map<String, Node> nodeMap = new HashMap<String, Node>();
		for (int i = 0; i < length; i++) {
			String line[] = read.readLine().split(" ");
			Node node = new Node(line[0], line[1], line[2]);
			nodeMap.put(node.address, node);
		}

		LinkedList<Node> list = new LinkedList<Node>();
		String nextAddress = firstAddress;
		List<Node> result = new ArrayList<Node>();
		Node prev = null;

		while (true) {
			while (!"-1".equals(nextAddress)) {
				Node node = nodeMap.get(nextAddress);
				nodeMap.remove(node.address);

				list.push(node);
				nextAddress = node.next;

				if (list.size() == k)
					break;
			}

			for (int i = 0; i < k; i++) {
				Node cur = list.pop();
				result.add(cur);
				if (prev != null) {
					prev.next = cur.address;
				}
				prev = cur;
			}
			
			if(nodeMap.size() < k)
				break;
		}
		
		if (!"-1".equals(nextAddress)) {
			prev.next = nextAddress;
			while (!"-1".equals(nextAddress)) {
				Node node = nodeMap.get(nextAddress);
				nodeMap.remove(node.address);

				result.add(node);
				nextAddress = node.next;
			}
		} else
			prev.next = "-1";

		for (int i = 0; i < length; i++) {
			Node node = result.get(i);
			System.out.println(String.format("%s %s %s", node.address, node.data, node.next));
		}
	}

}

class Node {
	public String address;
	public String data;
	public String next;

	public Node(String address, String data, String next) {
		this.address = address;
		this.data = data;
		this.next = next;
	}
}
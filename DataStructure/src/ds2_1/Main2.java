//package ds2_1;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//public class Main2 {
//
//	/**
//	 * @param args
//	 * @throws IOException 
//	 */
//	public static void main(String[] args) throws IOException {
//		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//		
//		String firstLine[] = read.readLine().split(" ");
//		String firstAddress = firstLine[0];
//		long length = Long.parseLong(firstLine[1]);
//		long k = Long.parseLong(firstLine[2]);
//		k = k < 1 ? 1 : k;
//		
//		Map<Long, Node> nodeMap = new HashMap<Long, Node>();
//		for(int i=0; i< length;i++){
//			String line[] = read.readLine().split(" ");
//			Node node = new Node(Long.parseLong(line[0]), Long.parseLong(line[1]), Long.parseLong(line[2]));
//			nodeMap.put(node.address, node);
//		}
//		
//		LinkedList<Node> list = new LinkedList<Node>();
//		Long nextAddress = Long.parseLong(firstAddress);
//		while(-1l != nextAddress){
//			Node node = nodeMap.get(nextAddress);
//			nodeMap.remove(node);
//			
//			list.push(nodeMap.get(nextAddress));
//			nextAddress = node.next;
//			
//			if(list.size() == k)
//				break;
//		}
//
//		List<Node> result = new ArrayList<Node>();
//		Node prev = null;
//		for(int i =0;i <k;i++){
//			Node cur = list.pop();
//			result.add(cur);
//			if(prev != null){
//				prev.next = cur.address;
//			}
//			prev = cur;
//		}
//		
//		if(-1l != nextAddress){
//			prev.next = nextAddress;
//			while(-1l != nextAddress){
//				Node node = nodeMap.get(nextAddress);
//				nodeMap.remove(node);
//				
//				result.add(nodeMap.get(nextAddress));
//				nextAddress = node.next;
//			}
//		}
//		else
//			prev.next = -1l;
//		
//		DecimalFormat format = new java.text.DecimalFormat("00000"); 
//		for(int i=0;i <length;i++){
//			Node node = result.get(i);
//			System.out.println(String.format("%s %s %s", format.format(node.address), node.data, node.next == -1l ? "-1" : format.format(node.next)));
//		}
//	}
//	
//}
//
//class Node{
//	public long address;
//	public long data;
//	public long next;
//	
//	public Node(long address, long data, long next){
//		this.address = address;
//		this.data = data;
//		this.next = next;
//	}
//}
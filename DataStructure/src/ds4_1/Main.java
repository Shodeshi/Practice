package ds4_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(read.readLine());
		
		String nodeStrArr[] = read.readLine().split(" ");
		read.close();
		
		Node root = null;
		for(int i = 0;i<length;i++){
			// Build node from input
			Node node = new Node();
			node.data = Integer.parseInt(nodeStrArr[i]);
			// Insert node
			root = insert(root, node);
		}
		
		System.out.println(root.data);
	}
	
	public static Node insert(Node root, Node node){
		if(root == null){
			root = node;
		}
		else{
			// Insert into left child tree
			if(node.data < root.data){
				root.leftChild = insert(root.leftChild, node);
				// Need left rotation
				if(getHeight(root.leftChild) - getHeight(root.rightChild) == 2)
					// Left left
					if(node.data < root.leftChild.data)
						root = llRotation(root);
					// Left right
					else
						root = lrRotation(root);
			}
			// Insert into right child tree
			else if(node.data > root.data){
				root.rightChild = insert(root.rightChild, node);
				// Need right rotation
				if(getHeight(root.leftChild) - getHeight(root.rightChild) == -2)
					// Right right
					if(node.data > root.rightChild.data)
						root = rrRotation(root);
					// Right left
					else
						root = rlRotation(root);
			}
		}
		
		updateHeight(root);
		
		return root;
	}
	
	public static int getHeight(Node node){
		if(node == null)
			return -1;
		return node.height;
	}
	
	public static void updateHeight(Node node){
		int leftH = getHeight(node.leftChild);
		int rightH = getHeight(node.rightChild);
		node.height = (leftH > rightH ? leftH : rightH) + 1;
	}
	
	public static Node llRotation(Node root){
		Node b = root.leftChild;
		root.leftChild = b.rightChild;
		b.rightChild = root;
		
		updateHeight(root);
		updateHeight(b);
		return b;
	}
	
	public static Node rrRotation(Node root){
		Node b = root.rightChild;
		root.rightChild = b.leftChild;
		b.leftChild = root;
		
		updateHeight(root);
		updateHeight(b);
		return b;
	}
	
	public static Node lrRotation(Node root){
		root.leftChild = rrRotation(root.leftChild);
		return llRotation(root);
	}
	
	public static Node rlRotation(Node root){
		root.rightChild = llRotation(root.rightChild);
		return rrRotation(root);
	}
	
}

class Node{
	public int data;
	public int height;
	public Node leftChild;
	public Node rightChild;
}

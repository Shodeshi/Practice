package ds2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String inputArr[] = read.readLine().split(" ");
		LinkedList<Integer> list = new LinkedList<Integer>();
		double sum = 0;
		for (int m = inputArr.length - 1; m >= 0; m--) {
			String str = inputArr[m];
			switch (str) {
			case "+":
				if (list.size() < 2) {
					System.out.println("ERROR");
					System.exit(-1);
				}
				sum += list.pop() + list.pop();
				break;
			case "-":
				if (list.size() < 2) {
					System.out.println("ERROR");
					System.exit(-1);
				}
				sum += list.pop() - list.pop();
				break;
			case "*":
				if (list.size() < 2) {
					System.out.println("ERROR");
					System.exit(-1);
				}
				sum += list.pop() * list.pop();
				break;
			case "/":
				if (list.size() < 2) {
					System.out.println("ERROR");
					System.exit(-1);
				}
				int a = list.pop();
				int b = list.pop();
				if (b == 0) {
					System.out.println("ERROR");
					System.exit(-1);
				}
				sum += a / b;
				break;
			default:
				list.push(Integer.valueOf(str));
				break;
			}
		}

		System.out.println(String.format("%.1f", sum));
	}
}

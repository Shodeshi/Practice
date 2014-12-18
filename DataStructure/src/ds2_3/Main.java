package ds2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String inputArr[] = read.readLine().split(" ");
		LinkedList<Double> list = new LinkedList<Double>();
		for (int m = inputArr.length - 1; m >= 0; m--) {
			String str = inputArr[m];
			if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
				
				if (list.size() < 2) {
					System.out.println("ERROR");
					System.exit(-1);
				}
				
				Double a = list.pop();
				Double b = list.pop();

				if ("/".equals(str) && b == 0) {
					System.out.println("ERROR");
					System.exit(-1);
				}

				Double result = 0.0;
				if ("+".equals(str))
					result += a + b;
				else if ("-".equals(str))
					result += a - b;
				else if ("*".equals(str))
					result += a * b;
				else if ("/".equals(str))
					result += a / b;
				
				list.push(result);
				
			} else {
				list.push(Double.valueOf(str));
			}
		}
		
		System.out.println(String.format("%.1f", list.pop()));
	}
}

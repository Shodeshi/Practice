package ds01_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(read.readLine());
		String inputArr[] = read.readLine().split(" ");

		int thisSum = 0;
		int thisStart = 0;
		int thisEnd = 0;

		int maxSum = 0;
		int maxStart = -1;
		int maxEnd = -1;

		boolean hasPositive = false;
		for (int i = 0; i < length; i++) {
			int j = Integer.parseInt(inputArr[i]);

			if (!hasPositive && j >= 0)
				hasPositive = true;

			thisSum += j;
			thisEnd = i;
			
			if(thisSum == 0 && j == 0){
				maxStart = thisStart;
				maxEnd = thisEnd;
				maxSum = thisSum;
			}
				

			if(thisSum == maxSum && ((maxStart == -1 && maxEnd == -1) || (Integer.parseInt(inputArr[thisStart]) < Integer.parseInt(inputArr[maxStart]) && Integer.parseInt(inputArr[thisEnd]) < Integer.parseInt(inputArr[maxEnd])))){
				maxStart = thisStart;
				maxEnd = thisEnd;
				maxSum = thisSum;
			}
			
			if (thisSum > maxSum) {
				maxStart = thisStart;
				maxEnd = thisEnd;
				maxSum = thisSum;
			}

			if (thisSum < 0 && i < length) {
				thisStart = i + 1;
				thisEnd = i + 1;
				thisSum = 0;
			}
		}

		if (hasPositive)
			System.out.printf("%d %d %d", maxSum, Integer.parseInt(inputArr[maxStart]), Integer.parseInt(inputArr[maxEnd]));
		else
			System.out.printf("0 %d %d", Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[length - 1]));
	}

}

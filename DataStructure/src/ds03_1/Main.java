package ds03_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static double MINIMUM_LENGTH = 0.0001;
	
	public static void main(String args[]) throws IOException{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		// Build coefficient array
		String line[] = read.readLine().split(" ");
		double arr[] = new double[4];
		for(int i=0;i<4;i++){
			arr[i] = Double.parseDouble(line[i]);
		}
		
		// Read the number a and b
		line = read.readLine().split(" ");
		read.close();
		double a = Double.parseDouble(line[0]);
		double b = Double.parseDouble(line[1]);
		
		System.out.println(String.format("%.2f", getRoot(arr, a, b)));
	}
	
	public static double calculateSum(double[] arr, double x){
		double result = 0;
		for (int i = 0; i < arr.length; i++) {
			result = x * result + arr[i];
		}
		return result;
	}
	
	public static double getRoot(double[] arr, double a, double b){
		double middle = (a + b) / 2;
		
		if(Math.abs(a - b) < MINIMUM_LENGTH)
			return middle;
		
		double resultA = calculateSum(arr, a);
		double resultB = calculateSum(arr, b);
		
		if(resultA == 0)
			return a;
		if(resultB == 0)
			return b;
		
		if(resultA * resultB < 0){
			double middleResult = calculateSum(arr, middle);
			if(middleResult == 0)
				return middle;
			
			if(middleResult * resultA > 0)
				return getRoot(arr, middle, b);
			
			if(middleResult * resultB > 0)
				return getRoot(arr, a, middle);
		}
		
		return a - 1;
		
	}
}

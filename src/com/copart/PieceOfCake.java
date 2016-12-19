package com.copart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PieceOfCake {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//Scanner scanner = new Scanner(System.in);

		String file = "data/PieceOfCakeInput.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		
		int n = Integer.parseInt(br.readLine());
		if(n>100){
			System.out.println("Value of N should be less than equal to 100");
			return;
		}
		int[] area_array = new int[n];
		int index=0;
		String line ="";
		while ((line = br.readLine()) != null) {
			if(Integer.parseInt(line)>500000000){
				System.out.println("Area should be less than equal to 500000000");
				return;
			}
			else{
			area_array[index++] = Integer.parseInt(line);
			}
		}

		int[] result_array = calclulateMinimumPerimeter(area_array);

		for (int i = 0; i < n; i++) {
			System.out.println(result_array[i]);
		}
		
		//scanner.close();
	}

	private static int[] calclulateMinimumPerimeter(int[] area_array) {

		int[] result_array = new int[area_array.length];

		for (int i = 0; i < area_array.length; i++) {
			int minPerimeter = Integer.MAX_VALUE;
			for (int a = 1; a * a <= area_array[i]; a++) {
				if (area_array[i] % a == 0) {
					minPerimeter = Math.min(minPerimeter, 2 * (area_array[i] / a + a));
				}
				result_array[i] = minPerimeter;
			}

		}

		return result_array;
	}
}

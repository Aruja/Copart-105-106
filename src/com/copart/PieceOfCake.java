package com.copart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PieceOfCake {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//Input file name
		String file = "data/PieceOfCakeInput.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		//Reading the first integer from the file. It is the number of cakes.
		int n = Integer.parseInt(br.readLine());
		//Validating the input. Value of N should be less than equal to 100
		if(n>100){
			System.out.println("Value of N should be less than equal to 100");
			return;
		}
		int[] area_array = new int[n];
		int index=0;
		String line ="";
		//Reading area of all cakes from file.
		while ((line = br.readLine()) != null) {
			if(isNotInt(line) || Integer.parseInt(line)>500000000){
				System.out.println("Area should be less than equal to 500000000");
				return;
			}
			else{
			area_array[index++] = Integer.parseInt(line);
			}
		}
		//Calling function to add the minimum perimeter of the rectangle.
		int[] result_array = calclulateMinimumPerimeter(area_array);

		//Displaying result on console.
		for (int i = 0; i < n; i++) {
			System.out.println(result_array[i]);
		}
	}

	private static boolean isNotInt(String number){
		try{
			Integer.parseInt(number);
			return false;
		}catch(Exception e){
			return true;
		}
		
		
	}
	//Method to calculate minimum perimeter for every cake. 
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

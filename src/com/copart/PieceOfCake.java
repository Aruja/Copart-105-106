package com.copart;

import java.util.Scanner;

public class PieceOfCake {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of cakes to create");
		int n = scanner.nextInt();
		System.out.println("Desired area for each cake");
		int[] area_array = new int[n];
		for (int i = 0; i < n; i++) {
			area_array[i] = scanner.nextInt();
		}

		int[] result_array = calclulateMinimumPerimeter(area_array);

		for (int i = 0; i < n; i++) {
			System.out.println(result_array[i]);
		}
		
		scanner.close();
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

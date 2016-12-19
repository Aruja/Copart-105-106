package com.copart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DNASequencing {

	static char[] charSequence = new char[4];
	static int[] subSequenceCount = new int[4];

	public static void main(String[] args) {

		String file = "data/DNASequenceInput.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String sequence = null;
		try {
			sequence = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		initializeCharSequence();
		findSubsequenceLength(sequence);
		int maxLength = Integer.MIN_VALUE;

		for (int i = 0; i < 4; i++) {
			
			if (maxLength < subSequenceCount[i]) {
				maxLength = subSequenceCount[i];
			}
		}

		// Printing the max length subsequence
		for (int i = 0; i < 4; i++) {
			if (maxLength == subSequenceCount[i]) {
				System.out.println(charSequence[i] + " " + subSequenceCount[i]);
			}
		}

		//scanner.close();

	}

	private static void initializeCharSequence() {
		charSequence[0] = 'A';
		charSequence[1] = 'T';
		charSequence[2] = 'G';
		charSequence[3] = 'C';
	}

	private static void findSubsequenceLength(String sequence) {
		for (int i = 0; i < sequence.length(); i++) {
			if(i==sequence.length() -1){
				if (sequence.substring(i, i + 1).equals("A") &&  subSequenceCount[0] == 0 )
					subSequenceCount[0] = 1;
				else if (sequence.substring(i, i + 1).equals("T") && subSequenceCount[1]==0)
					subSequenceCount[1] = 1;
				else if (sequence.substring(i, i + 1).equals("G") &&  subSequenceCount[2]==0)
					subSequenceCount[2] = 1;
				else if (sequence.substring(i, i + 1).equals("C") && subSequenceCount[3]==0)
					subSequenceCount[3] = 1;
			}
			else{
				
			if (sequence.substring(i, i + 1).equals(sequence.substring(i + 1, i + 2))) {
				int count = 1;
				for (int j = i + 1; j < sequence.length(); j++) {
					if (sequence.substring(i, i + 1).equals(sequence.substring(j, j + 1))) {
						count++;
					} else {
						break;
					}
				}
				if (sequence.substring(i, i + 1).equals("A") && count > subSequenceCount[0])
					subSequenceCount[0] = count;
				else if (sequence.substring(i, i + 1).equals("T") && count > subSequenceCount[1])
					subSequenceCount[1] = count;
				else if (sequence.substring(i, i + 1).equals("G") && count > subSequenceCount[2])
					subSequenceCount[2] = count;
				else if (sequence.substring(i, i + 1).equals("C") && count > subSequenceCount[3])
					subSequenceCount[3] = count;
			}
			else{
				if (sequence.substring(i, i + 1).equals("A") &&  subSequenceCount[0] == 0 )
					subSequenceCount[0] = 1;
				else if (sequence.substring(i, i + 1).equals("T") && subSequenceCount[1]==0)
					subSequenceCount[1] = 1;
				else if (sequence.substring(i, i + 1).equals("G") &&  subSequenceCount[2]==0)
					subSequenceCount[2] = 1;
				else if (sequence.substring(i, i + 1).equals("C") && subSequenceCount[3]==0)
					subSequenceCount[3] = 1;
			}
			}
		}
			
	}
}

package com.pranab.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] input_array=RandomArrayGenerator.get_Random_Array();
		//print_array(input_array);
		sort(input_array);
		//print_array(input_array);
	}
	
	public static void print_array(int[] array) {
		for(int data:array) {
			System.out.print(data+", ");			
		}
		System.out.println();
	}

	public static void sort(int[] unsortedArray) {
		for(int i=1;i<unsortedArray.length;i++) {
			int compare_value=unsortedArray[i];
			int j=i-1;
			for(;j>=0;j--) {
				if(unsortedArray[j]>compare_value) {
					unsortedArray[j+1]=unsortedArray[j];
				}else {
					break;
				}
			}
			unsortedArray[j+1]=compare_value;
		}
	}
}

package com.pranab.sorting;

public class RadixSort {

	public static void main(String[] args) {
		int[] input_array=RandomArrayGenerator.get_Random_Array();
		//print_array(input_array);
		sort(input_array,6);
		//print_array(out_array);
		
	}
	public static int[] sort(int[] un_Ordered,int max_digit) {
		int[] sorted_array=un_Ordered;
		for(int i=1;i<=max_digit;i++) {
			sorted_array=count_sort(sorted_array,i);
		}
		return sorted_array;
	}
	
	public static int[] count_sort(int[] un_Ordered,int position) {
		int[] sorted_Array=new int[un_Ordered.length];
		int[] sub_range=new int[10];
		for(int element:un_Ordered) {
			int digit_at_index=get_digit_at_index(element,position);
			sub_range[digit_at_index]=(sub_range[digit_at_index]+1);
		}
		for(int index=1;index<sub_range.length;index++) {
			sub_range[index]=sub_range[index]+sub_range[index-1];
		}
		for(int index=un_Ordered.length-1;index>=0;index--) {
			int digit_at_index=get_digit_at_index(un_Ordered[index],position);
			sorted_Array[(sub_range[digit_at_index]-1)]=un_Ordered[index];
			sub_range[digit_at_index]=(sub_range[digit_at_index]-1);
		}
		return sorted_Array;	
	}

	public static int get_digit_at_index(int num,int index) {
		return(int)((num%(Math.pow(10, index)))/Math.pow(10, (index-1)));
	}


	public static void print_array(int[] array) {
		for(int data:array) {
			System.out.print(data+", ");			
		}
		System.out.println();
	}
}

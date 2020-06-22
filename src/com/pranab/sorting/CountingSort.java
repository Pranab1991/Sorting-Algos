package com.pranab.sorting;

public class CountingSort {

	public static void main(String[] args) {
		int[] input_array=RandomArrayGenerator.get_Random_Array();
		//print_array(input_array);
		sort(input_array);
		//print_array(out_array);
	}
	
	public static int[] sort(int[] un_Ordered) {
		int[] sorted_Array=new int[un_Ordered.length];
		int[] sub_range=new int[findMax(un_Ordered)+1];
		for(int element:un_Ordered) {
			sub_range[element]=(sub_range[element]+1);
		}
		for(int index=1;index<sub_range.length;index++) {
			sub_range[index]=sub_range[index]+sub_range[index-1];
		}
		for(int index=un_Ordered.length-1;index>=0;index--) {
			sorted_Array[(sub_range[un_Ordered[index]]-1)]=un_Ordered[index];
			sub_range[un_Ordered[index]]=(sub_range[un_Ordered[index]]-1);
		}
		return sorted_Array;	
	}
	
	public static int findMax(int[] data_Range) {
		int max=0;
		for(int data:data_Range) {
			if(data>max) {
				max=data;
			}
		}
		return max;
	}

	public static void print_array(int[] array) {
		for(int data:array) {
			System.out.print(data+", ");			
		}
		System.out.println();
	}
}

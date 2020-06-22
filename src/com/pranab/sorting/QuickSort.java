package com.pranab.sorting;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] input_array=RandomArrayGenerator.get_Random_Array();
		/*for(int index=0;index<args.length;index++) {
			input_array[index]=Integer.parseInt(args[index]);
		}
		print_array(input_array);*/
		sort(input_array,0,(input_array.length-1));
		//print_array(input_array);
		
	}
	
	public static void sort(int[] unsorted_array,int start_index,int end_index) {
		if(start_index<end_index) {
			int partition_index=partition(unsorted_array,start_index,end_index);
			sort(unsorted_array,start_index,partition_index-1);
			sort(unsorted_array,partition_index,end_index);
		}
	}

	public static int partition(int[] unsorted_array,int start_index,int end_index) {
		int max=unsorted_array[end_index];
		int partiotion_index=start_index-1;
		for(int index=start_index;index<end_index;index++) {
			if(unsorted_array[index]<max) {
				partiotion_index++;
				swap(unsorted_array,index,partiotion_index);
			}
		}
		swap(unsorted_array,(partiotion_index+1),end_index);
		return partiotion_index+1;
	}
	
	public static void swap(int[] unsorted_array,int firstIndex,int secondIndex) {
		int temp=unsorted_array[firstIndex];
		unsorted_array[firstIndex]=unsorted_array[secondIndex];
		unsorted_array[secondIndex]=temp;
	}
	
	public static void print_array(int[] array) {
		for(int data:array) {
			System.out.print(data+", ");			
		}
		System.out.println();
	}
}

package com.pranab.sorting;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] input_array=RandomArrayGenerator.get_Random_Array();
		/*for(int index=0;index<args.length;index++) {
			input_array[index]=Integer.parseInt(args[index]);
		}
		print_array(input_array);*/
		sort(input_array,0,(input_array.length-1));
		//print_array(input_array);
	}
	
	public static void sort(int[] unsortedArray,int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			sort(unsortedArray,low,mid);
			sort(unsortedArray,mid+1,high);
			merge(unsortedArray,low,mid,mid+1,high);
		}
	}

	public static void merge(int[] arr,int low,int mid_low,int mid_high,int high) {
		int[] lower_element_array=new int[mid_low-low+1];
		int[] higher_element_array=new int[high-mid_high+1];
		for(int index=low,i_index=0;index<=mid_low;index++,i_index++) {
			lower_element_array[i_index]=arr[index];
		}
		for(int index=mid_high,j_index=0;index<=high;index++,j_index++) {
			higher_element_array[j_index]=arr[index];
		}
		for(int index=low,i_index=0,j_index=0;index<=high;index++) {
			if(j_index==(high-mid_high+1)) {
				for(;i_index<(mid_low-low+1);i_index++,index++) {
					arr[index]=lower_element_array[i_index];
				}
			}
			else if(i_index==(mid_low-low+1)) {
				for(;j_index<(high-mid_high+1);j_index++,index++) {
					arr[index]=higher_element_array[j_index];
				}
			}
			else{
				if(lower_element_array[i_index]<higher_element_array[j_index]) {
					arr[index]=lower_element_array[i_index];
					i_index++;
				}else {
					arr[index]=higher_element_array[j_index];
					j_index++;
				}
			}
		}
	}
	
	public static void print_array(int[] array) {
		for(int data:array) {
			System.out.print(data+", ");			
		}
		System.out.println();
	}
}

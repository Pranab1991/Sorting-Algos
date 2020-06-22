package com.pranab.sorting;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] input_array=RandomArrayGenerator.get_Random_Array();
		Heap heap=new Heap(input_array);
		heap.print_heap();
		heap.sort();
		//print_array(sorted_Data);
		//heap.print_heap();
	}
	
	public static void print_array(int[] array) {
		for(int data:array) {
			System.out.print(data+", ");			
		}
		System.out.println();
	}
	
	
}

class Heap{
	private int[] data_store;
	private int heap_size;
	private int length;
	public int getHeap_size() {
		return heap_size;
	}

	public int getLength() {
		return length;
	}
	
	public Heap(int[] data) {
		this.data_store=Arrays.copyOf(data, data.length);
		this.length=data_store.length;
		this.heap_size=data_store.length;
		build_Heap();
	}
	
	public  void print_heap() {
		for(int data:data_store) {
			System.out.print(data+", ");			
		}
		System.out.println();
	}
	
	private void swap(int first, int last) {
		int temp=data_store[first];
		data_store[first]=data_store[last];
		data_store[last]=temp;
	}
	
	private int get_Left_Child_Index(int index) {
		return 2*index+1;
	}
	
	private int get_Right_Child_Index(int index) {
		return 2*index+2;
	}
	
	@SuppressWarnings("unused")
	private int get_Parent_Index(int i) {
		int index=0;
		if(i==0) {
			index=0;
			}
		else {
			index=(--i/2);
		}
		return index;
	}
	
	private void maxify_Heap(int index) {
		int largest=0;
		int left_Child_Index=get_Left_Child_Index(index),right_Child_Index=get_Right_Child_Index(index);
		if((left_Child_Index<heap_size)&&(data_store[left_Child_Index]>data_store[index])) {
			largest=left_Child_Index;
		}else {
			largest=index;
		}
		if((right_Child_Index<heap_size)&&(data_store[right_Child_Index]>data_store[largest])) {
			largest=right_Child_Index;
		}
		if(largest!=index) {
			int temp=data_store[index];
			data_store[index]=data_store[largest];
			data_store[largest]=temp;
			maxify_Heap(largest);
		}
	}
	
	private void build_Heap() {
		int internal_index=(length-1)/2;
		for(;internal_index>=0;internal_index--) {
			maxify_Heap(internal_index);
		}
	}
	public int[] sort() {
		int[] sorted_array=heap_Sort();
		this.heap_size=this.length;
		build_Heap();
		return sorted_array;
	}
	
	private int[] heap_Sort() {
		for(int heap_index=length-1;heap_index>0;heap_index--) {
			swap(0,heap_index);
			this.heap_size=heap_index;
			maxify_Heap(0);
		}
		return Arrays.copyOf(data_store, length);
	}
}
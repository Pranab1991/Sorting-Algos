package com.pranab.sorting;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomArrayGenerator {
	public static void main(String[] args) {
		int length=Integer.parseInt(args[0]);
		int[] array=new int[length];
		Random random = new Random();
		for (int i = 0; i < length; i++)
		    {
			array[i]=random.nextInt(length);
		    }
		try(FileWriter fs=new FileWriter("./randomArray.txt")) {
			
			for(int data:array) {
				fs.write(""+data+" ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		/*int[] arr=get_Random_Array();
		System.out.println("END");*/
	}
	
	public static int[]  get_Random_Array() {
		int[] arr=null;
		try(BufferedReader in = new BufferedReader(
                new FileReader("./randomArray.txt"))) {
	        
	        String str;
	        String[] args=null;
	        while ((str = in.readLine())!= null) {
	        	args =str.split(" ");
	        }
	        arr=new int[args.length];
	        for(int index=0;index<args.length;index++) {
	        	arr[index]=Integer.parseInt(args[index]);
			}
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return arr;
	}
}

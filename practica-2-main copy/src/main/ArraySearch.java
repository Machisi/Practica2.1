package main;

import java.util.Random;

public class ArraySearch {
    public static int[] linealSearchIterative(int[] arr, int valor) {
    	int pos = -1;
    	int iterations = 0;
    	for (int i = 0; i < arr.length; i++) {
    		iterations++;
    		if (arr[i] == valor) {
    			return new int[] {pos, iterations};
    		}
    	}
    	return new int[] {pos, iterations};
    }
    
    public static int[] generateOrderedArray(int n) {
    	Random rand = new Random();
    	int[] arr = new int[n];
    	int val = 0;
    	for (int i = 0; i < n; i++) {
    		val += rand.nextInt(9)+1;
    		arr[i] = val;
    	}
    	return arr;
    }
}

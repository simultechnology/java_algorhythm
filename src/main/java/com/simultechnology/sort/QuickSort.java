package com.simultechnology.sort;

public class QuickSort implements Sort {

	@Override
	public int[] execute(int[] args) {
		quickSort(0, args.length - 1, args);
		return args;
	}
	
	private static void quickSort(int end, int top, int[] data) {
		int lower, upper;
		
		if (end >= top) {
			return;
		}
		int devide = data[end];
		
		for (lower = end, upper = top; lower < upper;) {
			while (lower <= upper && data[lower] <= devide) {
				lower++;
			}
			while (lower <= upper && data[upper] > devide) {
				upper--;
			}
			if (lower < upper) {
				int temp = data[lower];
				data[lower] = data[upper];
				data[upper] = temp;
			}
		}
		
		int temp = data[end];
		data[end] = data[upper];
		data[upper] = temp;
		
		quickSort(end, upper - 1, data);
		quickSort(upper + 1, top, data);
	}

}

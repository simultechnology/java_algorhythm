package sort;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.StringEscapeUtils;
import sort.BubbleSort;
import sort.QuickSort;
import sort.Sort;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = prepareData(100000, 10000000);
		
		int[] data2 = Arrays.copyOf(data, data.length);
		
		Sort sort;
		sort = new BubbleSort();
		doSort(data, sort);
		
		sort = new QuickSort();
		doSort(data2, sort);

		System.out.println(Arrays.equals(data, data2)); 
	}
	
	private static int[] prepareData(int count, int max) {
		
		int[] data = new int[count];
		Random random = new Random();
		
		for (int i = 0; i < count; i++) {
			data[i] = random.nextInt(max);
		}
		
		return data;
	}
	
	private static void doSort(int[] data, Sort sort) {
		long beforeTime = System.currentTimeMillis();
		printData(data);
		sort.execute(data);
		printData(data);
		long afterTime = System.currentTimeMillis();
		System.out.println("total time : " + (afterTime - beforeTime));
	}
	
	private static void printData(int[] data) {
		for (int i = 0; i < data.length; i++) {
			//System.out.print(data[i] + " ");
		}
		//System.out.println("");
	}
}

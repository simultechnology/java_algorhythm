package sort;

public class BubbleSort implements Sort {

	@Override
	public int[] execute(int[] args) {
		int temp;
		boolean flg;
		int k = 0;
		
		do {
			flg = false;
			for (int i = 0; i < args.length - 1 - k; i++) {
				if (args[i] > args[i + 1]) {
					flg = true;
					temp = args[i + 1];
					args[i + 1] = args[i];
					args[i] = temp;
				}
			}
			k++;
		} while (flg);
		
		return args;
	}
	
}

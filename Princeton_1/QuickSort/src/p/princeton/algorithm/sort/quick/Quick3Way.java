package p.princeton.algorithm.sort.quick;

/**
 * 三路切分的快速排序：
 * 			处理有大量重复元素的数组。
 * 			在只有若干个不用主键的元素，时间复杂度可以达到线性级别。
 */
public class Quick3Way {
	public static void sort(Comparable[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	
	private static void sort(Comparable[] arr, int low, int hig) {
		if (low >= hig) return ;
		
		int lt = low, i = low + 1, gt = hig;
		Comparable value = arr[low];
		while (i <= gt) {
			int cmp = arr[i].compareTo(value);
			// lt表示处于等于value部分的左边界
			// i-1表示等于value部分的右边界
			// gt+1表示大于value部分的左边界
			
			//发现一个小于的元素，则将该元素与等于部分最左边的进行交换，并同时+1（小于部分多了一个，同时新判断了一个元素i++）
			if			(cmp < 0)	exch(arr, lt++, i++);
			//发现一个大于的元素，则将该元素与大于部分左边的元素（未进行判断）进行交换。同时对gt-1（大于部分多了一个）
			else if		(cmp > 0)	exch(arr, i, gt--);	
			//发现一个等于的元素，直接将i++，表示
			else					i++;				
		}
		sort(arr, low, lt - 1);
		sort(arr, gt + 1, hig);
		
	} 
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0 ? true : false;
	}
	
	private static void exch(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}	
}

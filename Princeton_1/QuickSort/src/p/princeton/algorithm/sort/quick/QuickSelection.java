package p.princeton.algorithm.sort.quick;


/**
 * 若是不需要完整的排序，则可以使用QuickSelect
 * 利用快排中的分割算法，获取每一个元素的位置。时间复杂度为（2N），最坏情况下为（1/2 N^2）
 * 由于常数太大了，所有在实际中不被使用。
 */
public class QuickSelection {
	
	// 查找第k小的数
	public static Comparable select(Comparable[] arr, int k) {
		int low = 0, hig = arr.length - 1;
		
		while (low < hig) {
			int m = partition(arr, low, hig);
			if 		(m < k) 		low = m + 1;
			else if (m > k) 		hig = m - 1;
			else 					return arr[k];
		}
		return arr[k];
	}
	
	private static int partition(Comparable[] arr, int low, int hig) {
		Comparable value = arr[low];
		int left = low, right = hig + 1;
		
		while (true) {
			while (less(arr[++left], value)) 
				if (left == hig) break;
			while (less(value, arr[--right]))
				;
			if (left >= right)	break;
			exch(arr, left, right);
		}
		exch(arr, low, right);
		return right;
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

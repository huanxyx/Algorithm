/**
 * 
 */
package p.princeton.algorithm.sort;

/**
 * @ClassName: Selection
 * @author: Huan
 * @date: 2018年4月5日 上午10:02:38
 * @Description 
 * 				选择排序
 */
public class Selection {
	
	public static void sort(Comparable[] arr) {
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i+1; j < N; j++) 
				if (less(arr[j], arr[min]))
					min = j;
			
			exch(arr, min, i);
		}
	}
	
	//判断a是否小于b
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0; 
	}
	
	//交换i和j两个位置的元素
	private static void exch(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] 			= arr[j];
		arr[j]			= temp;
	}
	
	
}

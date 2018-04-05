/**
 * 
 */
package p.princeton.algorithm.sort;

/**
 * @ClassName: Insertion
 * @author: Huan
 * @date: 2018年4月5日 上午10:32:22
 * @Description 
 * 			插入排序
 */
public class Insertion {
	public static void sort(Comparable[] arr) {
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			int j = i; 
			while (j > 0 && less(arr[j], arr[j-1])) {
				exch(arr, j-1, j);
				j--;
			}
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

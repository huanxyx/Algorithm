/**
 * 
 */
package p.princeton.algorithm.sort;

/**
 * @ClassName: Shell
 * @author: Huan
 * @date: 2018年4月5日 上午11:18:57
 * @Description 
 * 			希尔排序
 */
public class Shell {
	public static void sort(Comparable[] arr) {
		int N = arr.length;
		int h = 1;
		//找到小于N的最大增量值。
		while (h < N / 3) h = 3*h + 1;
		
		while (h >= 1) {
			for (int i = h; i < N; i+=h) {
				int j = i; 
				while (j-h >= 0 && less(arr[j], arr[j-h])) {
					exch(arr, j-h, j);
					j -= h;
				}
			}
			h /= 3;
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

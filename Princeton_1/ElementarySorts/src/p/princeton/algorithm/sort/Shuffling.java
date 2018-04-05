/**
 * 
 */
package p.princeton.algorithm.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName: Shuffling
 * @author: Huan
 * @date: 2018年4月5日 上午11:44:41
 * @Description
 * 				洗牌算法
 */
public class Shuffling {
	
	public static void shuffle(Object[] arr) {
		int N = arr.length;
/*		第一种		
  		for (int i = N-1; i >= 0; i--) {
			int random = StdRandom.uniform(i + 1);
			exch(arr, i, random);
		}*/
		for (int i = 0; i < N; i++) {
			int random = StdRandom.uniform(i + 1);
			exch(arr, i, random);
		}
	}
	
	//交换i和j两个位置的元素
	private static void exch(Object[] arr, int i, int j) {
		Object temp 	= arr[i];
		arr[i] 			= arr[j];
		arr[j]			= temp;
	}
}

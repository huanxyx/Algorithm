package p.princeton.algorithm.sort.merge;

import java.util.Random;

/**
 * @ClassName: MergeBU
 * @author: Huan
 * @date: 2018年4月22日 下午1:12:37
 * @Description 
 * 			自底向上的归并排序
 */
public class MergeBU {
	public static void sort(Comparable[] arr) {
		Comparable[] aux = new Comparable[arr.length];
		
	    //len代表着每个分组的长度
	    for (int len = 1; len < arr.length; len = 2*len) {
	        //low代表着开始的位置，mid代表着中间的位置，hig代表着结束的位置
	        for (int low = 0; low < arr.length-len; low += 2*len) {
	            int hig = Math.min(low+2*len-1, arr.length-1);
	            int mid = low + len - 1;
	            merge(arr, aux, low, mid, hig);
	        }
	    }
	}
	
	
	public static boolean isSorted(Comparable[] arr) {
		int i = 1;
		while (i < arr.length) {
			if (less(arr[i], arr[i-1])) return false;
			i++;
		}
		
		return true;
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int hig) {
		for (int i = low; i <= hig; i++) 
			aux[i] = a[i];
		
		int left = low, right = mid+1;
		for (int pos = low; pos <= hig; pos++) {
			if (left > mid) 						a[pos] = aux[right++];
			else if (right > hig) 					a[pos] = aux[left++];
			else if (less(aux[right], aux[left]))	a[pos] = aux[right++];
			else 									a[pos] = aux[left++];
		}
	}
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public static void main(String[] args) {
		Integer[] testArr = new Integer[10000];
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			testArr[i] = random.nextInt(10000);
		}
		sort(testArr);
		System.out.println(isSorted(testArr));
	}
}

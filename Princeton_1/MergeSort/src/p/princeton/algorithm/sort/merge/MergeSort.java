package p.princeton.algorithm.sort.merge;

import java.util.Random;

/**
 * @ClassName: MergeSort
 * @author: Huan
 * @date: 2018年4月22日 上午10:47:44
 * @Description 
 * 				归并排序的实现
 */
public class MergeSort {	
	//排序
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		for (int i = 0; i < a.length; i++)
			aux[i] = a[i];
		sort(a, aux, 0, a.length-1);
	}
	
	//判断当前序列是否是有序的
	public static boolean isSorted(Comparable[] arr) {
		int i = 1;
		int N = arr.length;
		while(i < N) {
			if(less(arr[i], arr[i-1])) return false;
			i++;
		}
		return true;
	}
	
	//排序指定范围区间(包括lo和hi位置的值)
	//将aux数组中的数排序好放到a中
	private static void sort(Comparable[] a, Comparable[] aux, int low, int hig) {
		if (low == hig)  return ; 
		int mid = low + (hig - low) / 2;
		
		//优化2：将原数组和辅助数组的身份调换
		sort(aux, a, low, mid);
		sort(aux, a, mid+1, hig);
		merge(aux, a, low, mid, hig);
	}
	
	//合并(将排好序的aux，合并到a中)
	private static void merge(Comparable[] aux, Comparable[] a, int low, int mid, int hig) {
		int left = low, right = mid+1;
		for (int i = low; i <= hig; i++) {
			//左边遍历完毕
			if 		(left > mid) 					a[i] = aux[right++];
			//右边遍历完毕
			else if (right > hig) 					a[i] = aux[left++];
			//右边的小于左边的，先放入
			else if (less(aux[right], aux[left])) 	a[i] = aux[right++];
			//左边的小于或等于右边的
			else 									a[i] = aux[left++];
		}
	}
	
	//less
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	} 
	
	public static void main(String[] args) {
		Random random = new Random();
		Integer[] arr = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			arr[i] = random.nextInt(1000);
		}
		sort(arr);
		for (int i = 0; i < 1000; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(isSorted(arr));
	}

}

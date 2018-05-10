package p.princeton.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Random;

/**
 * 标准快速排序
 * 性能分析：
 * 		1）最好情况，每次都两等分，NlogN
 * 		2）最坏情况，每次只分得了一个，N^2
 * 		3）平均情况，1.39NlogN次比较
 * 	
 * 与归并排序的比较：
 * 		相对于归并排序，多出39%的比较次数，但是由于由更少的数据移动次数，速度比归并排序快。
 * 
 * 特性：
 * 		1）原地排序
 * 		2）不是稳定的
 * 	
 * 优化：
 * 		1）在较小的子数组时使用插入排序。（5-15）
 * 		2）在进行切分之前，将第二大的数放到左边界。
 * 		3）可以将最大的元素放在末尾作为哨兵，就可以避免右边界检测
 * 
 * 分割方法的应用：
 * 		在一个无序的序列中查找一个第k小的数。不断的进行分割，直到分割元素的位置为k。
 * 
 * 缺点：
 * 		若是在切分中遇到相同的元素不停止下来，那么在大量重复元素的情况下，算法的时间复杂度可能达到N^2
 */
public class QuickSort {
	public static void sort(Comparable[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	
	private static void sort(Comparable[] arr, int low, int hig) {
		if (low >= hig) return ;
		
		
		int m = mediaOf3(arr, low, (hig - low) + low, hig);
		exch(arr, low, m);
		
		int center = partition(arr, low, hig);
		sort(arr, low, center - 1);
		sort(arr, center + 1, hig);
	} 
	
	private static int partition(Comparable[] arr, int low, int hig) {
		Comparable value = arr[low];
		int left = low, right = hig+1;
		
		while (true) {
			while (less(arr[++left], value))
				if (left == hig) break;			//避免发生了越界的情况
			while (less(value, arr[--right]))
				;								//无论怎么样都不会发生越界，因为value所处的位置为low。
			if (left >= right) break;			//两个指针发生了交叉，意味着无需进行交换，已经达到终结状态, 此时right已经进入了更小的区域
			exch(arr, left, right);
		}
		//循环结束后，能够保证right右边的所有值都大于或等于value
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
	
	//求出三个数中中位数的位置
	private static int mediaOf3(Comparable[] arr, int a, int b, int c) {
		if (less(arr[a], arr[b])) {
			if (less(arr[c], arr[a]))
				return c;
			else {
				if (less(arr[b], arr[c]))
					return b;
				else 
					return c;
			}
		} else {
			if (less(arr[c], arr[b]))
				return b;
			else {
				if (less(arr[a], arr[c]))
					return a;
				else 
					return c;
			}
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Integer[] arr = new Integer[100];
		
		for (int i = 0; i < 100; i++) {
			arr[i] = random.nextInt(100);
		}
		
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

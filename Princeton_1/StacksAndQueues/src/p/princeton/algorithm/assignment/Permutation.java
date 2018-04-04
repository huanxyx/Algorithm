/**
 * 
 */
package p.princeton.algorithm.assignment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName: Permutation
 * @author: Huan
 * @date: 2018年4月4日 下午11:46:55
 * @Description 测试的使用
 */
public class Permutation {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			queue.enqueue(item);
		}
		for (int i = 0; i < k; i++) {
			StdOut.println(queue.dequeue());	
		}
	}
}

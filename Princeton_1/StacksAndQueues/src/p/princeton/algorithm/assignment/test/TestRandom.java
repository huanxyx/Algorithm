/**
 * 
 */
package p.princeton.algorithm.assignment.test;

import p.princeton.algorithm.assignment.RandomizedQueue;

/**
 * @ClassName: TestRandom
 * @author: Huan
 * @date: 2018年4月4日 下午11:36:39
 * @Description TODO
 */
public class TestRandom {
	public static void main(String[] args) {
		RandomizedQueue<Integer> random = new RandomizedQueue<Integer>();
		random.enqueue(1);
		random.enqueue(2);
		random.enqueue(3);
		random.enqueue(4);
		
		for (Integer i : random) {
			System.out.println(i);
		}
	}
}

/**
 * 
 */
package p.princeton.algorithm.assignment.test;

import p.princeton.algorithm.assignment.Deque;

/**
 * @ClassName: TestDeque
 * @author: Huan
 * @date: 2018年4月4日 下午10:51:20
 * @Description 
 * 				测试完add，remove，size，iterator
 */
public class TestDeque {
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addLast(4);
//		testAddAndRemove(deque);
		testIterator(deque);
	}
	
	public static void testIterator(Deque<Integer> deque) {
		for (Integer i : deque) {
			System.out.println(i);
		}
	}
	
	
	public static void testAddAndRemove(Deque<Integer> deque) {
		System.out.println(deque.removeFirst());
		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
		System.out.println(deque.isEmpty());
		System.out.println(deque.size());
		deque.addFirst(null);
		System.out.println(deque.removeFirst());
	}
}

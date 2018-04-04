/**
 * 
 */
package p.princeton.algorithm.test;

import p.princeton.algorithm.queue.ArrayQueue;
import p.princeton.algorithm.queue.Queue;

/**
 * @ClassName: TestQueue
 * @author: Huan
 * @date: 2018年4月4日 下午3:54:17
 * @Description 测试Queue的实现
 */
public class TestQueue {
	public static void main(String[] args) {
		Queue<String> queue = new ArrayQueue<String>();
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue("4");
		queue.enqueue("5");
		queue.enqueue("6");
		
		queue.enqueue("7");
		queue.enqueue("8");
		
		queue.enqueue("9");
		
		
		for (String s : queue) {
			System.out.println(s);
		}
		
	}
}

/**
 * 
 */
package p.princeton.algorithm.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName: ArrayQueue
 * @author: Huan
 * @date: 2018年4月4日 下午3:40:07
 * @Description 队列的数组实现:
 * 			出队和入队更新容量
 * 			
 */
public class ArrayQueue<Item> implements Queue<Item>{
	
	//队列
	private Item[] queue;
	//队首
	private int head = 0; 
	//队尾(最后一个元素的后一个)
	private int tail = 0;
	//队列的大小
	private int N = 0;
	
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		queue = (Item[]) new Object[1];
	}

	/**
	 * 入队
	 */
	@Override
	public void enqueue(Item item) {
		if (N == queue.length) resize(queue.length * 2);
		queue[tail] = item;
		tail = (tail + 1) % queue.length;
		N++;
	}

	/**
	 * 出队
	 */
	@Override
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException();
		Item item = queue[head];
		queue[head] = null;
		head = (head + 1) % queue.length;
		N--;
		if (N != 0 && N == queue.length / 4) resize(queue.length / 2);
		return item;
	}

	/** 
	 * 判断该队列是否为空
	 */
	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	/**
	 * 返回该队列的大小
	 */
	@Override
	public int size() {
		return N;
	}

	/*
	 * 重新设置数组的大小
	 */
	private void resize(int size) {
		@SuppressWarnings("unchecked")
		Item[] item = (Item[]) new Object[size];
		
		for (int i = 0; i < N; i++) {
			item[i] = queue[(head + i) % queue.length];
		}
		head = 0;
		tail = N;
		queue = item;
	}
	
	/**
	 * 迭代器
	 */
	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	
	private class QueueIterator implements Iterator<Item> {
		private int current = head;
		@Override
		public boolean hasNext() {
			if (current >= head && current < head + N)
				return true;
			return false;
		}

		@Override
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = queue[current % queue.length];
			current++;
			return item;
		}	
	}
}

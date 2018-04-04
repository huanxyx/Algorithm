/**
 * 
 */
package p.princeton.algorithm.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName: RandomizedQueue
 * @author: Huan
 * @date: 2018年4月4日 下午11:04:15
 * @Description 随机队列 
 * 			相当于在一个数组中随机删除一个元素
 * 			实现：
 * 				随机一个位置，将这个位置的元素删除，然后将最后一个元素移动到该位置，该集合没有先后顺序的关系。
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	//队列
	private Item[] queue;
	//队列的大小
	private int N = 0;
	
	public RandomizedQueue() {
		queue = (Item[]) new Object[1];
	}                
	/**
	 * 入队,
	 */
	public void enqueue(Item item) {
		validateItem(item);
		
		if (N == queue.length) resize(queue.length * 2);
		queue[N++] = item;
	}

	/**
	 * 随机出队：
	 * 随机选择一个元素，删除，然后将最后一个位置的元素放到被删除元素的位置
	 */
	public Item dequeue() {
		validateEmpty();
		
		int outIndex = StdRandom.uniform(N);
		Item item = queue[outIndex];
		if (outIndex != N - 1) queue[outIndex] = queue[N - 1];
		queue[N-1] = null;
		N--;
		if (N != 0 && N == queue.length / 4) resize(queue.length / 2);
		return item;
	}

	/** 
	 * 判断该队列是否为空
	 */
	public boolean isEmpty() {
		return N == 0;
	}

	/**
	 * 返回该队列的大小
	 */
	public int size() {
		return N;
	}

	/*
	 * 重新设置数组的大小
	 */
	private void resize(int size) {

		Item[] item = (Item[]) new Object[size];
		
		for (int i = 0; i < N; i++) {
			item[i] = queue[i];
		}
		queue = item;
	}
	
	//验证添加参数的合法性
	private void validateItem(Item item) {
		if (item == null)
			throw new IllegalArgumentException();
	}
	
	//验证是否能够删除
	private void validateEmpty() {
		if (isEmpty())
			throw new NoSuchElementException();
	}
	
	/**
	 * 随机取一个数
	 * @return
	 */
	public Item sample() {
		validateEmpty();
		return queue[StdRandom.uniform(N)];
	}             
	
	/**
	 * 获取迭代器
	 */
	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator();
	}   
	
	private class RandomizedQueueIterator implements Iterator<Item>{
		private Item[] container;
		private int size;
		
		public RandomizedQueueIterator() {
			container = (Item[]) new Object[N];
			for (int i = 0; i < N; i++) {
				container[i] = queue[i];
			}
			size = N;
		}

		public boolean hasNext() {
			return size != 0;
		}

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			int outIndex = StdRandom.uniform(size);
			Item item = container[outIndex];
			if (outIndex != size - 1) 
				container[outIndex] = container[size - 1];
			size--;
			return item;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}

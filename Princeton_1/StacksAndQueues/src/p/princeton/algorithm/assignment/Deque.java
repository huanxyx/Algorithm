/**
 * 
 */
package p.princeton.algorithm.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName: Deque
 * @author: Huan
 * @date: 2018年4月4日 下午10:05:10
 * @Description 两端队列
 * 				
 * 				使用双向链表实现从头部删除和从尾部删除
 */
public class Deque<Item> implements Iterable<Item> {
	private Node 	first;
	private Node 	last;
	private int 	N;
	
	public Deque() {
		first 		= null;
		last 		= null;
		N			= 0;
	}
	
	/**
	 * 判断该队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	
	/**
	 * 获取该队列的大小
	 * @return
	 */
	public int size() {
		return N;
	}
	
	/**
	 * 向该队列的头部添加元素
	 * @param item
	 */
	public void addFirst(Item item) {
		validateItem(item);
		
		Node node = new Node();
		node.item = item;
		node.next = first;
		node.pre  = null;
		if (isEmpty()) 	last = node;
		else 			first.pre = node;
		first = node;
		N++;
	}
	
	/**
	 * 向该队列的队尾添加元素
	 * @param item
	 */
	public void addLast(Item item) {
		validateItem(item);
		
		Node node = new Node();
		node.item = item;
		node.next = null;
		node.pre  = last;
		if (isEmpty()) 	first = node;
		else 			last.next = node;
		last = node;
		N++;
	}
	
	/**
	 * 删除该队列的头部元素
	 * @return
	 */
	public Item removeFirst() {
		validateRemove();
		
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) 	last      = null;
		else 			first.pre = null;
		return item;
	}
	
	/**
	 * 删除该队列尾部的元素
	 * @return
	 */
	public Item removeLast() {
		validateRemove();
		
		Item item = last.item;
		last = last.pre;
		N--;
		if (isEmpty())  first 	  = null;
		else 			last.next = null;
		return item;
	}
	
	//验证添加参数的合法性
	private void validateItem(Item item) {
		if (item == null)
			throw new IllegalArgumentException();
	}
	
	//验证是否能够删除
	private void validateRemove() {
		if (isEmpty())
			throw new NoSuchElementException();
	}
	
	private class Node {
		private Item item;
		private Node next;
		private Node pre;
	}
	
	private class DequeIterator implements Iterator<Item>{
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public Iterator<Item> iterator() {
		return new DequeIterator();
	} 
	
	public static void main(String[] args) {
		
	}
}

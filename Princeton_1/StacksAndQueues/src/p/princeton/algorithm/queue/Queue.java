/**
 * 
 */
package p.princeton.algorithm.queue;

/**
 * @ClassName: Queue
 * @author: Huan
 * @date: 2018年4月4日 下午3:38:21
 * @Description 队列的API定义
 */
public interface Queue<Item> extends Iterable<Item>{
	
	/**
	 * 入队操作
	 * @param item
	 */
	public void enqueue(Item item);
	
	/**
	 * 出队操作
	 * @return
	 */
	public Item dequeue();
	
	/**
	 * 判断该队列是否为空
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * 获取该队列的大小
	 * @return
	 */
	public int size();
}

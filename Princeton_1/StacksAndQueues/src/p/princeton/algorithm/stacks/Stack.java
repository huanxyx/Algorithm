/**
 * 
 */
package p.princeton.algorithm.stacks;

/**
 * @ClassName: Stack
 * @author: Huan
 * @date: 2018年4月3日 下午4:19:55
 * @Description 栈的方法抽象
 * 
 * 				栈的应用：
 * 					1.递归的使用
 * 					2.网页的回退
 * 					3.表达式求值
 * 						Dijkstra双栈算法（需要规范输入）：遇到操作符放到操作符栈上，遇到操作数放到操作数栈上，遇到左括号略过，遇到右括号出栈操作符和两个操作数，将运算结果入栈
 * 					4.编译器？
 * 				
 * 				数组的实现ArrayStack：时间复杂度分摊下来为3N
 * 				链表的实现LinkedStack：因为需要处理链接的原因，需要额外的时间和空间，所以相对于分摊后的ArrayStack慢一点
 * 				
 * 				使用情况：
 * 					若是需要对每个操作都需要很快，那么得使用LinkedStack，因为LinkedStack最坏情况下一次push和pop都是常数级的。而ArrayStack不能保证
 * 					若是不需要则可以使用ArrayStack
 * 					
 * 				使用了泛型和迭代器
 * 				迭代器：是用来遍历集合中的元素，不必让客户端知道我们使用的是数组还是链表，还是我们考虑的任何数据结构，这对客户端是不相关的。
 */
public interface Stack<Item> extends Iterable<Item>{
	
	/**
	 * 压栈
	 * @param ele
	 */
	public void push(Item ele);
	
	/**
	 * 出栈
	 * @return
	 */
	public Item pop();
	
	/**
	 * 判断当前栈是否为空
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * 返回当前栈的大小
	 * @return
	 */
	public int size();
}

/**
 * 
 */
package p.princeton.algorithm.test;

import java.util.Iterator;

import p.princeton.algorithm.stacks.LinkedStack;
import p.princeton.algorithm.stacks.Stack;

/**
 * @ClassName: TestStack
 * @author: Huan
 * @date: 2018年4月3日 下午4:46:25
 * @Description TODO
 */
public class TestStack {
	public static void main(String[] args) {
		Stack<String> stack = new LinkedStack<String>();
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
//		stack.push("4");
		stack.push("4");
		stack.push("4");
		
		Iterator<String> iterator = stack.iterator();
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());

		
	}
}	

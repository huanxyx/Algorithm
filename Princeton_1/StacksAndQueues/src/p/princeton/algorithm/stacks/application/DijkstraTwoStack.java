/**
 * 
 */
package p.princeton.algorithm.stacks.application;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName: DijkstraTwoStak
 * @author: Huan
 * @date: 2018年4月4日 下午8:08:44
 * @Description 
 * 				Dijkstra双栈算法(不同的符号之间通过空格隔开)
 */
public class DijkstraTwoStack {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if 		(s.equals("("))				;
			else if (s.equals("+"))		ops.push("+");
			else if (s.equals("*"))     ops.push("*");
			else if (s.equals(")"))	{
				String op = ops.pop();
				if 		(op.equals("+")) vals.push(vals.pop() + vals.pop());
				else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
			}
			else vals.push(Double.parseDouble(s));
		}
		StdOut.print(vals.pop());
	}
}

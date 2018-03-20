package p.princeton.algorithm.dynamicconnectivity;

/**
 * 并查集问题
 * 解决动态连通性问题的算法实现
 * Dynamic Connectivity
 * 方法：
 * 		connected方法：判断两个节点之间是否能连通
 * 		union方法：合并两个节点
 * 将对象名称映射为从0到N-1的整数的这种做法是符号表或搜索算法的一个漂亮的应用
 * @author Huan
 *	
 */
public abstract class UF {
	public abstract boolean connected(int p, int q);
	public abstract void union(int p, int q);
}

package p.princeton.algorithm.dynamicconnectivity.impl;

import p.princeton.algorithm.dynamicconnectivity.UF;

/**
 * Quick Union算法
 * 原理：
 * 		每个连通分量都是一颗树
 * 		当两个连通分量的节点连接时，则将其中一个分量的根节点作为另一个分量根节点的子节点即可
 * 		只要判断两个项的根节点是否是同一个就可以知道这两个项是否连通
 * 		每个数组项中存储的时该节点的父节点，若是没有父节点，则是本身
 * 分析：有些情况下可以很快，但还有一些情况下很慢
 * 缺点：树可能太高了，意味着查找操作的代价太大。
 * @author Huan
 *
 */
public class QuickUnionUF extends UF{
	private int[] id;
	
	public QuickUnionUF(int num) {
		id = new int[num];
		for(int i = 0; i < num; i++) {
			id[i] = i;
		}
	}

	// 通过回溯获取根节点
	private int root(int node) {
		while(node != id[node]) node = id[node];
		return node;
	}
	
	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	// 将p的根节点的父节点设置为q的根节点
	@Override
	public void union(int p, int q) {
		int rootp = root(p);
		int rootq = root(q);
		id[rootp] = rootq;
	}

}

package p.princeton.algorithm.dynamicconnectivity.impl;

import p.princeton.algorithm.dynamicconnectivity.UF;

/**
 * <pre>
 * 带权快速合并
 * 原理：
 * 		快速合并算法中操作的时间与树的深度成正比 
 * 		在快速合并的基础上更改合并方式
 * 		将更小的树合并到更大的树上，以降低树的深度
 * 证明：树中任何节点的深度上限是以2为底N的对数
 * 		1.对于一个在树T2中的叶子节点X
 * 		2.若是想该节点X的深度增加，那么必须要另一颗树的节点数大于或者等于X节点所在树的节点数（深度+1）
 * 		3.所以节点X的深度增加时，所在树的节点总数至少为之前的2倍。
 * 		4.最后一个树有N个节点，那么节点X的深度最多为log2(N) 
 * 进一步优化improvement（带压缩路径的带权快速合并算法）：
 * 		见root方法
 * </pre>
 * @author Huan
 *
 */
public class WeightedQuickUnionUF extends UF{

	private int[] id;
	private int[] sz; 		//代表每个节点所在树的节点数量
	
	public WeightedQuickUnionUF(int num) {
		id = new int[num];
		sz = new int[num];
		for( int i = 0; i < num; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	/*
	 * 	e^a = N;
		e^b = 2;
		2^c = N;
		e^(bc) = N;
		c = lgN / b;
		c = lgN / lg2;
	 */
	public static void main(String[] args) {
		int count = 0;
		double N = Double.MAX_VALUE;
		System.out.println(N);
		while(N > 1) {
			N = Math.log(N ) / Math.log(2);
			count++;
		}
		System.out.println(count);
	}
	
	/*
	 * 带压缩路径的戴荃快速合并算法
	 * 在实现查找一个节点的根节点的时候 ，需要访问从该节点到根节点路径上的每个节点，
	 * 因此我们可以将访问路径上的每个节点的父节点都指向根节点
	 * 时间复杂度：
	 * 		在有N个对象，M个合并与查找操作的任何序列，需要访问数组最多(N + Mlg*N)次
	 * 		lg*N（迭代对数函数）是将N变成1取对数的次数：不断的进行N = lgN,直到N小于等于1
	 * 		在真实世界中，可以认为是一个小于5的数。因为（lg*(2^65526)=5）
	 */
	private int root(int node) {
		while(node != id[node]) {
			id[node] = id[id[node]];	//优化实现部分，将当前节点指向它的爷爷节点
			node = id[node];
		}
		return node;
	}
	
	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}


	@Override
	public void union(int p, int q) {
		int rootp = root(p);
		int rootq = root(q);
		if(rootp == rootq) return ;
		if(sz[rootp] > sz[rootq]) {
			id[rootq] = rootp;
			sz[rootp] += sz[rootq];
		} else {
			id[rootp] = rootq;
			sz[rootq] += sz[rootp];
		}
	}

}

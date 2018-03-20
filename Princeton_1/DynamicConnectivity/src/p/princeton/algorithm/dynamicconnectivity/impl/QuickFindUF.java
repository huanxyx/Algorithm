package p.princeton.algorithm.dynamicconnectivity.impl;

import p.princeton.algorithm.dynamicconnectivity.UF;

/**
 * Quick Find 的实现方式
 * 原理：两个数组项中的内容相同表示属于同一个连通分量
 * 优点：查找操作很快，只需要常熟次查找数组项
 * 缺点：合并操作必须以常熟正比于N次访问数组
 * 平方级时间的算法无法成比例适应大规模问题
 * @author Huan
 *
 */
public class QuickFindUF extends UF{
	
	private int[] id;
	
	public QuickFindUF(int n) {
		for(int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	@Override
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	@Override
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i < id.length; i++) {
			if(id[i] == pid) id[i] = qid;
		}
	}

}

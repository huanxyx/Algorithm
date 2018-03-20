package p.princeton.algorithm.assignment.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * 用来执行一系列计算得到阈值的对象
 * @author Huan
 *
 */
public class PercolationStats {
	private final double meanD;
	private final double stddevD;
	private final double lowEndpoint;
	private final double hightEndpoint;
	
	/**
	 * 对n*n的方格进行trials次试验
	 * @param n
	 * @param trials
	 */
	public PercolationStats(int n, int trials) {
		if(n <= 0 || trials <= 0)
			throw new IllegalArgumentException();
		
		// 用来存储每次渗透测试时的阈值
		double[] testV = new double[trials];			
		// 测试trials次
		for(int i = 0; i < trials; i++) {
			Percolation perc = new Percolation(n);
			
			// 打开的个数
			int count = 0;							
			
			// 不断地添加新的位置，直到该系统渗透
			while(!perc.percolates()) {
				int row = StdRandom.uniform(n)+1;
				int col = StdRandom.uniform(n)+1;
				if(!perc.isOpen(row, col)) {
					perc.open(row, col);
					count++;
				}
			}
			
			// 存储每次测试的值
			testV[i] = count / (double)(n*n);
		}
		
		// 计算赋值
		this.meanD = StdStats.mean(testV);
		this.stddevD = StdStats.stddev(testV) ;
		double t = 1.96 * stddevD / Math.sqrt(trials);
		this.lowEndpoint = meanD - t;
		this.hightEndpoint = meanD + t;
	}
	
	/**
	 * 样本平均渗透阈值
	 * @return
	 */
	public double mean() {
		return this.meanD;
	}
	
	/**
	 * 渗透阈值的样本标准差
	 * @return
	 */
	public double stddev() {
		return this.stddevD;
	}
	
	/**
	 * 95%置信区间的低端点
	 * @return
	 */
	public double confidenceLo() {
		return this.lowEndpoint;
	}
	
	/**
	 * 95%置信区间的高端点
	 * @return
	 */
	public double confidenceHi() {
		return this.hightEndpoint;
	}
	
	public static void main(String[] args) {
		PercolationStats stats = new PercolationStats(200, 100);
		System.out.println(stats.mean());
		System.out.println(stats.stddev());
		System.out.println(stats.confidenceLo() + ":" + stats.confidenceHi());
	}
}

package p.princeton.algorithm.assignment.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * <pre>
 * 动态连通性的应用：
 * 		渗滤模型
 * </pre>
 * @author Huan
 *
 */
public class Percolation {
	// 带虚拟顶端和底端
	private final WeightedQuickUnionUF uf;
	// 不带虚拟底端
	private final WeightedQuickUnionUF noBottomUf;
	// 规模
	private final int n;
	// 用来存储当前模型的状态，false代表关闭，true代表打开
	private boolean[][] opened;
	// 用来存储当前模型打开site的数量
	private int count = 0;
	
	/**
	 *  初始化
	 *  创建一个n*n的网格，所有的位置都是阻塞的
	 * @param n		代表着网格的规模
	 */
	public Percolation(int n) {
		validate(n);
		
		this.uf = new WeightedQuickUnionUF(n*n + 2);			//一个虚拟顶端0，一个虚拟底端n*n+1,一个辅助虚拟底端
		this.noBottomUf = new WeightedQuickUnionUF(n*n + 1);	//只有虚拟顶端
		this.n = n;
		this.opened = new boolean[n+1][n+1];
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				this.opened[i][j] = false;
			}
		}
	}
	
	/**
	 * 打开（row，col）位置
	 * 若是row，col非法，则抛出IllegalArgumentException异常
	 * 若是(row,col)已经打开，则直接退出
	 * 若是(row,col)没有打开，则打开该site，并连接该site和他相邻的site
	 * @param row		代表着行号
	 * @param col		代表着列号
	 */
	public void open(int row, int col) {
		validate(row, col);
		
		if(this.opened[row][col]) {
			return ;
		}
		this.opened[row][col] = true;
		count++;
		
		// 连接四周的位置
		int currentOpen = xyTo1D(row, col);
		if(row != 1 && this.opened[row-1][col]) {
			uf.union(xyTo1D(row-1, col), currentOpen);
			noBottomUf.union(xyTo1D(row-1, col), currentOpen);
		}
		if(row != n && this.opened[row+1][col]) {
			uf.union(xyTo1D(row+1, col), currentOpen);
			noBottomUf.union(xyTo1D(row+1, col), currentOpen);
		}
		if(col != 1 && this.opened[row][col-1]) {
			uf.union(xyTo1D(row, col-1), currentOpen);
			noBottomUf.union(xyTo1D(row, col-1), currentOpen);
		}
		if(col != n && this.opened[row][col+1]) {
			uf.union(xyTo1D(row, col+1), currentOpen);
			noBottomUf.union(xyTo1D(row, col+1), currentOpen);
		}
		
		// 顶部连接虚拟顶端
		if(row == 1) {
			uf.union(0, currentOpen);						
			noBottomUf.union(0, currentOpen);
		}
		
		if(row == n) {
			uf.union(currentOpen, n*n+1);
		}
		
	}
	
	// 判断（row，col）是不是打开的
	public boolean isOpen(int row, int col) {
		validate(row, col);
		
		return this.opened[row][col];
	}
	
	// A full site is an open site that can be connected to an open site 
	// in the top row via a chain of neighboring (left, right, up, down) open sites. 
	// 若是该位置是满的，意味着与虚拟顶端连通
	// 通过不含虚拟底端的UF查询，避免出现回流问题
	public boolean isFull(int row, int col) {
		validate(row, col);
		
		return noBottomUf.connected(0, xyTo1D(row, col));
	}
	
	// 获取打开位置的数量
	public int numberOfOpenSites() {
		return count;
	}
	
	// 判断系统是否渗透，若是最下面有一个位置是full的，则意味着这是一个渗透系统
	public boolean percolates() {
		return uf.connected(n*n+1, 0);
	}
	
	// 用来判断参数是否合法
	private void validate(int row, int col) {
		if(row <= 0 || col <= 0 || row > n || col > n) 		
			throw new IllegalArgumentException();
	}
	
	private void validate(int n) {
		if(n <= 0)
			throw new IllegalArgumentException();
	}
	
	// 用来将二维坐标映射到一维坐标中
	private int xyTo1D(int row, int col) {
		return (row - 1)*n + col;
	}
	
	
	// Test
	public static void main(String[] args) {
	}
}

package p.princeton.algorithm.sort.merge.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: FastCollinearPoints
 * @author: Huan
 * @date: 2018年4月22日 下午3:30:49
 * @Description TODO
 */
public class FastCollinearPoints {
	
	private ArrayList<LineSegment> list;

	
	public FastCollinearPoints(Point[] points) {   
		validate(points);
		//创建临时数组，避免直接使用原数组
		Point[] tempPoints = copy(points);
		//计算
		list = calculateLine(tempPoints);
	}
	
	public int numberOfSegments() { 
		return list.size();
	}
	
	public LineSegment[] segments() {               // the line segments
		return list.toArray(new LineSegment[list.size()]);
	}
	
	//计算线段
	private static ArrayList<LineSegment> calculateLine(Point[] points) {
		ArrayList<LineSegment> list = new ArrayList<LineSegment>();
		
		//当点数小于4，则不可能形成一条线段
		if (points.length < 4) 
			return list;
		
		int N = points.length;																//点的个数
		Arrays.sort(points);
		
		Point	originPoint;
		Point[] otherPoints = new Point[N-1];			//除开原点的其他点
	
		//对每一个点进行遍历
		for (int originIndex = 0; originIndex < N; originIndex++) {
			originPoint = points[originIndex];											//当前原点
			pullLastOnePoints(points, otherPoints, originIndex);						//将原数组中的数据放到辅助数组中，其中第index个元素被剔除					
			
			//根据斜率排序
			
			Arrays.sort(otherPoints, originPoint.slopeOrder());
			
			int 							count = 1;												//同一条线上的点
			int 							leftIndex = 0;											//左端点
			double 							lastSlope = originPoint.slopeTo(otherPoints[0]);		//上一个点的斜率
			
			//遍历所有的其他节点
			for (int curIndex = 1; curIndex < otherPoints.length; curIndex++) {
				double curSlope = originPoint.slopeTo(otherPoints[curIndex]);
				//斜率相等时
				if (lastSlope == curSlope) {
					count++;
				} else {
					//斜率不相等时，若是能够进行4个节点的线条，并且当前线条并没有重复，则添加到列表中
					if (count >= 3) {
						//当最小的那个节点比原点小，那么就已经计算出了该线条
						if (otherPoints[leftIndex].compareTo(originPoint) >= 0) 
							list.add(new LineSegment(originPoint, otherPoints[curIndex-1]));
					} 
					count = 1;
					leftIndex = curIndex;
					lastSlope = curSlope;
				}
			}
			//差一(当最后一个节点满足条件)
			if (count >= 3) {
				//当最小的那个节点比原点小，那么就已经计算出了该线条
				if (otherPoints[leftIndex].compareTo(originPoint) >= 0) 
					list.add(new LineSegment(originPoint, otherPoints[otherPoints.length-1]));
			} 
		}
		
		return list;
	}
	
	//将原数组中的数据放到辅助数组中，其中第index个元素被剔除
	private static void pullLastOnePoints(Point[] points, Point[] tempPoints, int index) {
		for (int j = 0; j < points.length; j++) {
			if (j < index) tempPoints[j] = points[j];
			else if (j > index) tempPoints[j-1] = points[j];
		}
	}
	
	//验证参数的有效性
	private static void validate(Point[] points) {
		if (points == null || points.length == 0)
			throw new IllegalArgumentException();
		for (int i = 0; i < points.length; i++) { 
			if (points[i] == null)
				throw new IllegalArgumentException();
			for (int j = i+1; j < points.length; j++) 
				if (points[j] == null || points[i].compareTo(points[j]) == 0)
					throw new IllegalArgumentException();
		}
	}
	
	//复制数组
	private static Point[] copy(Point[] points) {
		Point[] tempPoints = new Point[points.length]; 
		for (int i = 0; i < points.length; i++) {
			tempPoints[i] = points[i];
		}
		return tempPoints;
	}
}

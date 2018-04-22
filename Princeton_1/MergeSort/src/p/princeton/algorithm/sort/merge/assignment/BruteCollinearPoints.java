package p.princeton.algorithm.sort.merge.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: BruteCollinearPoints
 * @author: Huan
 * @date: 2018年4月22日 下午3:30:41
 * @Description TODO
 */
public class BruteCollinearPoints {
	
	private ArrayList<LineSegment> list;
	
	public BruteCollinearPoints(Point[] points) {   // finds all line segments containing 4 points
		validate(points);
		//创建临时数组，避免直接使用原数组
		Point[] tempPoints = copy(points);
		//计算
		list = calculateLine(tempPoints);
	}
	
	public int numberOfSegments() {     // the number of line segments
		return list.size();
	}
	
	public LineSegment[] segments() {               // the line segments
		return list.toArray(new LineSegment[list.size()]);
	}
		
	//计算线段
	private static ArrayList<LineSegment> calculateLine(Point[] points) {
		Arrays.sort(points);
		
		ArrayList<LineSegment> list = new ArrayList<LineSegment>();
		
		int len = points.length;
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				for (int k = j+1; k < len; k++) {
					if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) ) {
						for (int w = k+1; w < len; w++) {
							if (points[i].slopeTo(points[k]) == points[k].slopeTo(points[w]) ) {
								//第一个点和最后一个点肯定是端点
								list.add(new LineSegment(points[i], points[w]));
							}
						}
					}
				}
			}
		}
		return list;
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

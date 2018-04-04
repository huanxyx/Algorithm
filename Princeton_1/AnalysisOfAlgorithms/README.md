#Week1.2：Analysis of Algorithms

###1.Observation：通过不同大小的输入运行程序，并测试运行时间。（预测模拟T(N)=a*N^k）
通过少量数据预测问题复杂度和规模N的关系：
- 1.1.Standard plot:规模大小 N作为横坐标，问题大小T(N)作为纵坐标
- 1.2.Log-log plot(双对数坐标):lg(N)作为横坐标，lg(T(N))作为纵坐标
	- 容易得到一条直线，这条直线的斜率就是关键。
	- 若是得到的斜率为K，则容易证明问题大小函数正比于N^K;(幂定律)
	- 若是lg(T(N))=klg(N)+c，则两边取幂得T(N)=a*N^k (a=2^c)
- 1.3.将问题的规模N翻倍，计算比率，这个比率通常会收缩到一个常数，实际上比率的对数就会收敛到N的指数k
	通过代入数据和指数就可以求出a
- 1.4.系统无关因素(算法和输入数据)决定了k，系统相关因素(硬件，软件，系统)决定了a

###2.Mathematical models：通过数学模型表示时间复杂度(分析操作得出复杂度)
数学模型通常与计算机系统无关

###3.Order-of-Growth Classification(增长阶数分类)：
- 3.1：常数级（a）
- 3.2：对数级（logN）
- 3.3：线性级（N）
- 3.4：NlogN
- 3.5：N^2
- 3.6：N^3
- 3.7：2^N

###4.Theory of Algorithms：
- 4.1：不同的输入将会导致性能剧烈的变化
	最好的情况
	最坏的情况：为分析算法提供底线
	平均的情况
- 4.2：遇到一个新问题，设计出某个算法，证明它的下界，如果存在间隔，寻找新的能够降低上界的算法，或者寻找提高下界的方法
- 4.3：通过研究持续下降的上界来了解问题的计算难度，得到了很多对于最坏情况更快的算法。

###5.Memory：
- 5.1：对象的引用：8bytes（包括数组）
- 5.2：数组：24bytes+条目的总存储空间
- 5.3：对象：16bytes(object overhead)+每个实例变量的存储空间+8byte(如果有内部类)
- 5.4：padding(用于对齐)：使存储空间填充为8byte的倍数

##知识点：
- 1.我们通常不关心小N下的开销，因为时间不长
- 2.与我们感兴趣的算法相关的只有少数几个函数
- 3.一个算法的运行时间与NlogN成正比，意味着运行时间近似cNlogN
- 4.使用波浪形~表示近似模型
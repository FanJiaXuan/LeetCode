package BFS_review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//广搜的思想
//队列
//把起点加入队列 然后扩展起点周围的点 加入队列
//起点出队列 
//下一个点继续扩展周围的 再出队列 
//直到队伍为空 为止

//下面写的这个BFS呢 
//就是说 有一群字母组成的一个连通图
//给你一个字母 当做是 起点
//然后呢 就可以进行广度优先 遍历这个图 并且输出各个点与起点的距离

public class BFS {
	public static void main(String[] args) {
		//首先要一个map来储存这个图
		HashMap<Character, LinkedList<Character>> graph = new HashMap<>();
		LinkedList<Character> list_s= new LinkedList<>();
		list_s.add('w');
		list_s.add('r');
		 LinkedList<Character> list_w = new LinkedList<Character>();
	        list_w.add('s');
	        list_w.add('i');
	        list_w.add('x');
	        LinkedList<Character> list_r = new LinkedList<Character>();
	        list_r.add('s');
	        list_r.add('v');
	        LinkedList<Character> list_x = new LinkedList<Character>();
	        list_x.add('w');
	        list_x.add('i');
	        list_x.add('u');
	        list_x.add('y');
	        LinkedList<Character> list_v = new LinkedList<Character>();
	        list_v.add('r');
	        LinkedList<Character> list_i = new LinkedList<Character>();
	        list_i.add('u');
	        list_i.add('x');
	        list_i.add('w');
	        LinkedList<Character> list_u = new LinkedList<Character>();
	        list_u.add('i');
	        list_u.add('x');
	        list_u.add('y');
	        LinkedList<Character> list_y = new LinkedList<Character>();
	        list_y.add('u');
	        list_y.add('x');
	        graph.put('s', list_s);
	        graph.put('w', list_w);
	        graph.put('r', list_r);
	        graph.put('x', list_x);
	        graph.put('v', list_v);
	        graph.put('i', list_i);
	        graph.put('y', list_y);
	        graph.put('u', list_u);
	        //这样一来 我们的图就记录下来了 
	        //然后再 需要一个能记录存储 各个字母到起点距离的Map
	        HashMap<Character, Integer> dist = new HashMap<>();
	        char start = 's';//起点
	        //准备工作完成  可以调用我们的广搜函数了
	        //传入graph, dist, start
	        bfs(graph, dist, start);
	}
	public static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, char start){
		//再次回顾一下广搜
		//我需要弄一个 队列
		//从队列开始入手搞
		//这个队列装的是结点 也就是char
		Queue<Character> q = new LinkedList<>();//新知识学到了！
		//起点 入队
		int i = 0;
		q.add(start);
		dist.put(start, i);
		while(!q.isEmpty()){//只要队伍不空
			//队首 出队 然后 队首相邻的  入队  并且 扩充 dist
			char top = q.poll();//出队
			int dis = dist.get(top);
			i++;
			System.out.println("第" + i +"个出队" + "是" + top + "距离起点：" + dis);
			
			//于是队首就滚蛋了 但还有用
			//队首周围的元素要 入队  并且 入队的元素 都有 dist的值
			for(Character temp : graph.get(top)){
				//只有每次入队列的时候 i 才会自增
				//上一句错了 不是 i 自增 而是出队列父节点的距离  自增1
				//而且有 判断条件 我不会让重复的 元素再进队列
				//if(!q.contains(temp)){//哦 是应该用dist 而不是queue
				if(!dist.containsKey(temp)){	
					q.add(temp);//入队列
					dist.put(temp, dis + 1);
				}
			}
		}
		//昨天我们写完了BFS 
		//为进一步研究用广搜解题NO2打下了基础
		//今天 我们继续 用广搜来写题2
	}
}

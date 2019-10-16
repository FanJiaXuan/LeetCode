package BFS_review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//���ѵ�˼��
//����
//����������� Ȼ����չ�����Χ�ĵ� �������
//�������� 
//��һ���������չ��Χ�� �ٳ����� 
//ֱ������Ϊ�� Ϊֹ

//����д�����BFS�� 
//����˵ ��һȺ��ĸ��ɵ�һ����ͨͼ
//����һ����ĸ ������ ���
//Ȼ���� �Ϳ��Խ��й������ �������ͼ ������������������ľ���

public class BFS {
	public static void main(String[] args) {
		//����Ҫһ��map���������ͼ
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
	        //����һ�� ���ǵ�ͼ�ͼ�¼������ 
	        //Ȼ���� ��Ҫһ���ܼ�¼�洢 ������ĸ���������Map
	        HashMap<Character, Integer> dist = new HashMap<>();
	        char start = 's';//���
	        //׼���������  ���Ե������ǵĹ��Ѻ�����
	        //����graph, dist, start
	        bfs(graph, dist, start);
	}
	public static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, char start){
		//�ٴλع�һ�¹���
		//����ҪŪһ�� ����
		//�Ӷ��п�ʼ���ָ�
		//�������װ���ǽ�� Ҳ����char
		Queue<Character> q = new LinkedList<>();//��֪ʶѧ���ˣ�
		//��� ���
		int i = 0;
		q.add(start);
		dist.put(start, i);
		while(!q.isEmpty()){//ֻҪ���鲻��
			//���� ���� Ȼ�� �������ڵ�  ���  ���� ���� dist
			char top = q.poll();//����
			int dis = dist.get(top);
			i++;
			System.out.println("��" + i +"������" + "��" + top + "������㣺" + dis);
			
			//���Ƕ��׾͹����� ��������
			//������Χ��Ԫ��Ҫ ���  ���� ��ӵ�Ԫ�� ���� dist��ֵ
			for(Character temp : graph.get(top)){
				//ֻ��ÿ������е�ʱ�� i �Ż�����
				//��һ����� ���� i ���� ���ǳ����и��ڵ�ľ���  ����1
				//������ �ж����� �Ҳ������ظ��� Ԫ���ٽ�����
				//if(!q.contains(temp)){//Ŷ ��Ӧ����dist ������queue
				if(!dist.containsKey(temp)){	
					q.add(temp);//�����
					dist.put(temp, dis + 1);
				}
			}
		}
		//��������д����BFS 
		//Ϊ��һ���о��ù��ѽ���NO2�����˻���
		//���� ���Ǽ��� �ù�����д��2
	}
}

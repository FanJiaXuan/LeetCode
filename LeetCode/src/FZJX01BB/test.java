package FZJX01BB;
import java.util.Stack;


public class test {
	public static void main(String[] args) {
		Stack<HeapNode> heap = new Stack();
		HeapNode node1 = new HeapNode();
		node1.level = 1;
		heap.push(node1);
		HeapNode node2 = new HeapNode();
		node2.level = 2;
		heap.push(node2);
		HeapNode test = heap.peek();
		System.out.println(test.level);
	}	
	
}

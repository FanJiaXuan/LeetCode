package priorityQueue;

public class PriorityQueue {
	private int[] array;
	private int size;
	public PriorityQueue(){
		array = new int[32];
	}
	//���
	private void enQueue(int key){
		if(size >= array.length)
			//resize();
		array[size++] = key;
		upAdjust();//��ӵ���Ԫ���ȷ��ڶ������  Ȼ���ϸ�
	}
	
	//����
	private int deQeue() throws Exception{
		if(size <= 0)
			throw new Exception("empty queue!");
		int head = array[0];
		//���ӵĻ� ���һ��Ԫ�طŵ��Ѷ�
		//Ȼ���³�
		array[0] = array[--size];
		downAdjust();
		return head;
	}
	
	private void upAdjust(){
		int childIndex = size - 1;
		int parentIndex = childIndex / 2;
		int temp = array[childIndex];
		while(childIndex > 0 && temp > array[parentIndex]){
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = parentIndex / 2;
		}
		array[childIndex] = temp;
	}
	
	private void downAdjust(){
		int parentIndex = 0;
		int temp = array[parentIndex];
		int childIndex = 1;
		while(childIndex < size){
			if(childIndex + 1 < size && array[childIndex + 1] > array[childIndex])
				childIndex++;
			if(temp >= array[childIndex])
				break;
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = 2 * childIndex + 1;
		}
	}
	
}

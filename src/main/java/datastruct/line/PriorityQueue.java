package datastruct.line;

public class PriorityQueue {
	private int[] arr;
	private int maxSize;
	private int size;
	private int front;
	public PriorityQueue(int maxSize) {
		super();
		this.maxSize = maxSize;
		arr = new int[maxSize];
		size=0;
		front=0;
	}

	// 进队列
	public void add(int value) {
		//插入点
		int j=0;
		for (int i = 0; i < size; i++) {
			for (j = i+1; j >0&&arr[j-1]>value; j--) {
				//如果当前值小于前面的值,前面的值后移
					arr[j]=arr[j-1];
			}
		}
		arr[j]=value;
		size++;

	}

	// 出队列
	public int remove() {
		size--;
		return arr[front++];

	}

	public boolean isEmpty() {
		return size==0;
	}

	public boolean isFull() {
		return size == maxSize;
	}

	public int getSize() {
		return this.size;
	}

	public static void main(String[] args) {
		PriorityQueue c = new PriorityQueue(6);
		System.out.println(c.isEmpty());
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		c.add(6);
		System.out.println(c.isFull());

		while(!c.isEmpty()){
			System.out.println(c.remove());
		}
		System.out.println(c.size);

	}
}

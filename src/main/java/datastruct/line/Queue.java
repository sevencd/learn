package datastruct.line;

public class Queue {
	private int[] arr;
	private int maxSize;
	private int front;
	private int end;
	private int size;

	public Queue(int maxSize) {
		super();
		this.maxSize = maxSize;
		arr = new int[maxSize];
		front = 0;
		end = 0;
		size=0;
	}

	// 进队列
	public void add(int i) {
		arr[end++] = i;
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
		Queue c = new Queue(6);
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

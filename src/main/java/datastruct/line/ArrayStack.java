package datastruct.line;

public class ArrayStack<E> {
	private Object[] arr;
	private int top;
	private int maxSize;

	public ArrayStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		arr = new Object[maxSize];
		top = -1;
	}

	// 入栈
	public void push(char c) {
		arr[++top] = c;
	}

	// 出栈
	public E pop() {
		return (E)arr[top--];
	}

	// 访问栈顶元素
	public E peek() {
		return (E)arr[top];
	}

	public boolean isEmpty() {
		return top == -1 ;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public static void main(String[] args) {
		ArrayStack c = new ArrayStack(2);
		c.push('a');
		c.push('b');
		while(!c.isEmpty()){
			System.out.println(c.pop());
		}
	}
}

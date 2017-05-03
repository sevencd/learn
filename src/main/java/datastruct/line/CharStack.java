package datastruct.line;

public class CharStack {
	private char[] arr;
	private int top;
	private int maxSize;

	public CharStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		arr = new char[maxSize];
		top = -1;
	}

	// 入栈
	public void push(char c) {
		arr[++top] = c;
	}

	// 出栈
	public char pop() {
		return arr[top--];
	}

	// 访问栈顶元素
	public char peek() {
		return arr[top];
	}

	public boolean isEmpty() {
		return top == -1 ;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public static void main(String[] args) {
		CharStack c = new CharStack(2);
		c.push('a');
		c.push('b');
		while(!c.isEmpty()){
			System.out.println(c.pop());
		}
	}
}

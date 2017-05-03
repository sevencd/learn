package datastruct.line;

public class Link {
	private int data;
	private Link next;
	public Link(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Link getNext() {
		return next;
	}
	public void setNext(Link next) {
		this.next = next;
	}
	public static void main(String[] args) {
		Link l1=new Link(1);
		Link l2=new Link(2);

		Link l3=new Link(3);

		Link l4=new Link(4);
		l1.setNext(l2);
		l2.setNext(l3);
		l3.setNext(l4);
		Link cur=l1;
		while(cur!=null){
			System.out.println(cur.getData());
			cur=cur.getNext();
		}

	}
}

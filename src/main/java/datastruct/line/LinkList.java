package datastruct.line;

import java.util.LinkedList;

public class LinkList {
	private Link first;

	public void insert(int value) {
		Link link = new Link(value);
		if (first == null) {
			first = link;
		} else {
			link.setNext(first);
			first = link;
		}
	}

	// 插入到指定位置
	public void insert(int value, int index) {
		Link link = new Link(value);
		Link cur = first;
		for (int i = 0; i < index - 1; i++) {
			cur = cur.getNext();
		}

		link.setNext(cur.getNext());
		cur.setNext(link);
	}

	public void displayAll() {
		Link cur = first;
		while (cur != null) {
			System.out.println(cur.getData());
			cur = cur.getNext();
		}
	}

	// 查找
	public Link find(int value) {
		Link cur = first;
		while (cur != null) {
			if (cur.getData() == value) {
				break;
			}
			cur = cur.getNext();
		}
		return cur;
	}

	public static void main(String[] args) {
		/*
		 * int maxSize = 10000000; LinkList linkList = new LinkList(); long
		 * beginTime = System.currentTimeMillis(); for (int i = 0; i < maxSize;
		 * i++) { linkList.insert(i); } long endTime =
		 * System.currentTimeMillis(); System.out.println("时间差" + (endTime -
		 * beginTime));
		 * 
		 * MyArray arr = new MyArray(maxSize); beginTime =
		 * System.currentTimeMillis(); for (int i = 0; i < maxSize; i++) {
		 * arr.insert(i); } endTime = System.currentTimeMillis();
		 * System.out.println("时间差" + (endTime - beginTime)); beginTime =
		 * System.currentTimeMillis(); linkList.delete(30); endTime =
		 * System.currentTimeMillis(); System.out.println("时间差" + (endTime -
		 * beginTime)); beginTime = System.currentTimeMillis(); arr.delete(30);
		 * endTime = System.currentTimeMillis(); System.out.println("时间差" +
		 * (endTime - beginTime));
		 */
		int maxSize = 5;
		MyArray arr = new MyArray(maxSize);
		for (int i = 0; i < maxSize; i++) {
			arr.insert(i);
		}
		arr.delete(4);
		arr.displayAll();
	}

	public void delete(int i) {
		Link cur = first;
		Link pre = first;
		while (cur != null) {
			if (cur.getData() == i) {
				break;
			}
			pre = cur;
			cur = cur.getNext();
		}
		// 如果匹配第一个节点
		if (cur == first) {
			first = cur.getNext();
		} else if (cur != null && cur.getNext() == null) {// 如果匹配最后一个节点
			pre.setNext(null);
		} else if (cur == null) {
			// 没匹配
		} else {
			pre.setNext(cur.getNext());
		}
	}
}

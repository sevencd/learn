package datastruct.line;

import java.util.LinkedList;

/*
单向单链表
 */
public class LinkList<E> {
    private Link<E> first;
    private Link<E> tail;
    private int size;
    private int maxSize = 6;//最大缓存大小

    public static void main(String[] args) {
        LinkList arr = new LinkList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.displayAll();
        arr.reverse().displayAll();
        System.out.println("缓存大小" + arr.getSize());
    }

    //翻转链表
    public LinkList reverse() {
        LinkList reverse = new LinkList();
        Link cur = this.first;
        while (cur != null) {
            reverse.linkFirst(cur.getData());
            cur = cur.getNext();
        }
        return reverse;
    }

    //添加元素
    public void add(E value) {
        linkLast(value);
    }

    //头部插入
    public void linkFirst(E value) {
        Link link = new Link(value);
        if (first == null) {
            first = link;
            tail = link;
            size++;
        } else {
            link.setNext(first);
            first = link;
            size++;

        }
    }

    //尾部插入
    public void linkLast(E value) {
        Link link = new Link(value);
        if (first == null) {
            first = link;
            tail = link;
            size++;

        } else {
            tail.setNext(link);
            tail = link;
            size++;

        }
    }

    // 插入到指定位置
    public void insert(E value, int index) {
        Link link = new Link(value);
        Link cur = first;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.getNext();
        }

        link.setNext(cur.getNext());
        cur.setNext(link);
        size++;

    }

    public void displayAll() {
        Link cur = first;
        while (cur != null) {
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }

    // 查找
    public Link find(E value) {
        Link cur = first;
        while (cur != null) {
            if (cur.getData() == value) {
                break;
            }
            cur = cur.getNext();
        }
        return cur;
    }


    //删除节点
    public void delete(E value) {
        Link cur = first;
        Link pre = first;
        while (cur != null) {
            if (cur.getData() == value) {
                break;
            }
            pre = cur;
            cur = cur.getNext();
        }
        // 如果匹配第一个节点
        if (cur == first) {
            first = cur.getNext();
            size--;
        } else if (cur != null && cur.getNext() == null) {// 如果匹配最后一个节点
            pre.setNext(null);
            size--;
            tail = pre;
        } else if (cur == null) {
            // 没匹配
        } else {
            pre.setNext(cur.getNext());
            size--;

        }
    }

    public int getSize() {
        return size;
    }

    //LRU缓存淘汰算法
    public void LRUCacheRemove(E value) {
        /*1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。

        2. 如果此数据没有在缓存链表中，又可以分为两种情况：

        如果此时缓存未满，则将此结点直接插入到链表的头部；

        如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。*/
        Link link = find(value);
        if (link != null) {
            this.delete(value);
            this.linkFirst(value);
        } else {
            if (size < maxSize) {
                this.linkFirst(value);
            } else {
                this.delete(tail.getData());
                this.linkFirst(value);
            }
        }
    }

}
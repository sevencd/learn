package datastruct.line;

public class LinkLoopQuene<E> {
    /*private Link<E> data;*/
    private int size;//队列元素个数
    private Node<E> head;
    private Node<E> tail;
    private int maxSize;//队列大小
    public LinkLoopQuene(int maxSize) {
        this.maxSize=maxSize;
    }

    public static void main(String[] args) {
        LinkLoopQuene<String> obj = new LinkLoopQuene<String>(5);
        obj.enquene("abc");
        obj.enquene("a");
        obj.enquene("b");
        obj.enquene("c");
        obj.enquene("d");
        obj.enquene("e");
        obj.enquene("f");
        obj.enquene("g");
        System.out.println(obj.dequene());
        System.out.println(obj.dequene());
        System.out.println(obj.dequene());
        System.out.println(obj.dequene());
        System.out.println(obj.dequene());
        System.out.println(obj.dequene());
        System.out.println(obj.dequene());
        obj.enquene("a");
        System.out.println(obj.dequene());
        System.out.println(obj.dequene());

    }

    //入队
    public boolean enquene(E value) {
        if(isFull()){
            tail.next=head;
            return  false;
        }
        linkLast(value);
        return true;
    }

    //尾部插入
    private void linkLast(E e) {
        final Node<E> l = tail;
        if(isEmpty()){
            Node<E> newNode = new Node<>(l, e, null);
            head=tail=newNode;
        }
        else {
            if (l.next == null){
                Node<E> newNode = new Node<>(l, e, null);
                l.next = newNode;
                tail=newNode;
            }
            else{
                l.next.item = e;
            }
        }
        size++;
    }

    private boolean isEmpty() {
        return size == 0;
    }
    private boolean isFull() {
        return size == maxSize;
    }
    //出队
    public E dequene() {
        if (isEmpty()) {
            return null;
        }
        E r = head.item;
        head = head.next;
        size--;
        return r;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}

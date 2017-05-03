package datastruct.tree;


public class Node<E> {
	 E item;
     Node<E> left;
     Node<E> right;
     Node(E element){
    	 this.item=element;
     }
     Node(Node<E> prev, E element, Node<E> next) {
         this.item = element;
         this.left = next;
         this.right = prev;
     }
}

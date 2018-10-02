package datastruct.tree;

public class Tree {
	private Node<Integer> root;

	// 插入
	public void insert(int key) {
		if (root == null) {
			Node<Integer> node = new Node<Integer>(key);
			root = node;
		} else {
			Node<Integer> cur = root;
			Node<Integer> parent;
			Node<Integer> node = new Node<Integer>(key);
			while (true) {
				parent = cur;
				if (key < cur.item) {
					cur = cur.left;
					if (cur == null) {
						parent.left = node;
						break;
					}
				} else {
					cur = cur.right;
					if (cur == null) {
						parent.right = node;
						break;
					}
				}
			}
		}
	}

	// 查找
	public Node<Integer> get(int key) {
		Node<Integer> tmp=root;
		while(key!=tmp.item){
			if(key<tmp.item){
				tmp=tmp.left;
			}
			if(key>tmp.item){
				tmp=tmp.right;
			}
			if(tmp==null){
				return null;
			}
		}
		return tmp;
		
	}

	// 删除
	public void remove(int key) {

	}

	// 修改
	public void modify(int key, int value) {

	}

	// 遍历
	public void display(Node<Integer> node) {
		if (node != null) {
			System.out.println(node.item);
			display(node.left);
			display(node.right);
		}
	}

	public static void main(String[] args) {
		Tree t = new Tree();
		t.insert(40);
		t.insert(20);
		t.insert(25);
		t.insert(50);
		t.display(t.root);
		System.out.println(t.get(20).item);
	}
}

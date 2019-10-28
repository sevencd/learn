package algorithm.sort;

/*
冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，
看是否满足大小关系要求。如果不满足就让它俩互换。
一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
 */
public class BubbleSort extends Sort {
    BubbleSort(int size) {
        this.size=size;
        a = new int[size];
    }
    public static void main(String[] args) {
        int size=5;
        BubbleSort sort = new BubbleSort(size);
        sort.createData();
        System.out.print("排序前数据为");
        sort.display();
        System.out.println();
        sort.bubbleSort();
        System.out.print("排序后数据为");
        sort.display();
    }


    // 冒泡排序，a 表示数组，n 表示数组大小
    private void bubbleSort() {
        int n=size-1;
        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }
}

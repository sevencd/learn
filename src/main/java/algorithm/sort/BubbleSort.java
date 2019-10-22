package algorithm.sort;

/*
冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，
看是否满足大小关系要求。如果不满足就让它俩互换。
一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
 */
public class BubbleSort extends Sort {
    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] a = {1, 3, 5, 2, 4, 6};
        sort.bubbleSort(a, a.length);
        sort.display(a, a.length);
    }


    // 冒泡排序，a 表示数组，n 表示数组大小
    private void bubbleSort(int[] a, int n) {
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

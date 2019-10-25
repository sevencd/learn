package algorithm.sort;

/*
如果要排序数组中下标从 p 到 r 之间的一组数据，
我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 */
public class QuickSort extends Sort {
    public QuickSort(int size) {
        a = new int[size];
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort(5);
        sort.createData();
        System.out.print("排序前数据为");
        sort.display(sort.a, sort.a.length);
        System.out.println();
        sort.quickSort(sort.a, 0, sort.a.length - 1);
        System.out.print("排序后数据为");
        sort.display(sort.a, sort.a.length);

    }

    public void quickSort(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r); // 获取分区点
        quickSort(a, p, q - 1);
        quickSort(a, q + 1, r);
    }

    public int partition(int[] a, int p, int r) {
        int pivot = a[r];//用来确定分区点的值
        int i = p;//确定分区点
        for (int j = p; j < r;j++ ) {
            if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }
}

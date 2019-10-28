package algorithm.sort;

/*
如果要排序数组中下标从 p 到 r 之间的一组数据，
我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 */
public class QuickSort extends Sort {
    public QuickSort(int size) {
        this.size=size;
        a = new int[size];
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort(5);
        sort.createData();
        System.out.print("排序前数据为");
        sort.display();
        System.out.println();
        sort.quickSort(0, sort.size - 1);
        System.out.print("排序后数据为");
        sort.display();

    }

    private void quickSort(int p, int r) {
        if (p >= r) return;
        int q = partition(p, r); // 获取分区点
        quickSort( p, q - 1);
        quickSort(q + 1, r);
    }

    protected int partition( int p, int r) {
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
